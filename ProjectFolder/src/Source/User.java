package Source;


public class User {
	private String username;
	private String password;
	private String FirstName;
	private String LastName;
	
	private int ArraySize = 1000;
	private String[] chatID;
	private int numChat = 0;
	
	public User(String Username,String Password,String fName, String lName) {
		setUser(Username);
		setPass(Password);
		setFirstName(fName);
		setLastName(lName);
		
		setnumChat(0);
		newChatlist();
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
	
	public void newChatlist() {
		chatID = new String[ArraySize];
	}
	
	public void addChatID(String ID) {
		this.chatID[numChat] = ID;
		numChat += 1;
	}
	
	public void setnumChat(int num) {
		this.numChat = num;
	}
	
	public void removeChatID(String ID) {
		for(int i = 0; i < numChat; i++) {
			if(ID.equals(chatID[i])) {
				this.numChat = this.numChat - 1;
				for (int x = i; x < this.numChat; x++) {
					chatID[x] = chatID[x + 1];
				}
			}
		}
	}
	
	public int getnumChat() {
		return this.numChat;
	}
	
	public String[] getChatID() {
		return chatID;
	}
	
	
	public String chatToString() {
		String temp = "";
		for(int i = 0; i < numChat; i++) {
			temp += (chatID[i] + ", ");
		}
		temp = temp.substring(0,temp.length()-2);
		return temp;
	}
}
