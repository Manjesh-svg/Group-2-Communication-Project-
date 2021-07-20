package Source;

public class User {
	private String username;
	private String password;
	private String FirstName;
	private String LastName;
	
	public User(String Username,String Password,String fName, String lName) {
		setUser(Username);
		setPass(Password);
		setFirstName(fName);
		setLastName(lName);
	}
	
	public void setUser(String Username) {
		this.username = Username;
	}
	
	public void setPass(String Password) {
		this.password = Password;
	}
	
	public void setFirstName(String fName) {
		this.FirstName = fName;
	}
	
	public void setLastName(String lName) {
		this.LastName = lName;
	}
	
	public String getUser() {
		return this.username;
	}
	
	public String getPass() {
		return this.password;
	}
	
	public String getfName() {
		return this.FirstName;
	}
	
	public String getlName() {
		return this.LastName;
	}
	
	public String toString() {
		return (getUser() + "/" + getPass() + "/" + getfName() + "/" + getlName());
	}
}
