package Source;

public class User {
	private String username;
	private String password;
	private String FirstName;
	private String LastName;
	
	public User(String Username,String Password,String fName, String lName) {
		SetUser(Username);
		SetPass(Password);
		SetFirstName(fName);
		SetLastName(lName);
	}
	
	public void SetUser(String Username) {
		this.username = Username;
	}
	
	public void SetPass(String Password) {
		this.password = Password;
	}
	
	public void SetFirstName(String fName) {
		this.FirstName = fName;
	}
	
	public void SetLastName(String lName) {
		this.LastName = lName;
	}
	
	public String GetUser() {
		return this.username;
	}
	
	public String GetPass() {
		return this.password;
	}
	
	public String GetfName() {
		return this.FirstName;
	}
	
	public String GetlName() {
		return this.LastName;
	}
	
	public String toString() {
		return (GetUser() + "/" + GetPass() + "/" + GetfName() + "/" + GetlName());
	}
}
