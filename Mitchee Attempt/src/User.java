
public class User {
	
	// Fields
	String username;
	String password;
	ChatRoom[] includedChatRooms = new ChatRoom[10];
	int chatNum = 0;
	boolean isAdmin;
	
	public User(String username, String password, boolean isAdmin) {
		setUsername(username);
		setPassword(password);
		setAdmin(isAdmin);
	}
	
	// Setters
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	// Getters
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean getAdminStatus() {
		return isAdmin;
	}
	
	// Functions
	
	public void AddChatRoom(ChatRoom toAdd) {
		
		int index = 0;
		
		while (includedChatRooms[index] != null) {
			index++;
		}
		
		includedChatRooms[index] = toAdd;
		
	}
}
