package Source;

public class ChatRoom {

	// Fields
	User[] activeUsers;
	Message[] messageHistory;
	int userCount;
	int messageCount;
	
	static private int count = 0;
	int id;
	
	static private int MAX_USER_SIZE = 20;
	static private int MAX_MESSAGE_SIZE = 1000;
	
	
	// Constructor
	
	public ChatRoom() {
		activeUsers = new User[MAX_USER_SIZE];
		messageHistory = new Message[MAX_MESSAGE_SIZE];
		
		this.id = count++;		
	}
	
	// SETTERS
	
	public void setUsers(User[] users) {
		
		int index = 0;
		
		// navigate through array until empty
		while (users[index] != null) {
			activeUsers[index] = users[index];
			
			userCount++;
			index++;
		}
	}
	
	// GETTERS
	
	public Message[] getMessageHistory() {
		return messageHistory;
	}
	
	
	// FUNCTIONS
	
	public void addUser(User username) {
		
		// see if array is full
		if (activeUsers.length == MAX_USER_SIZE) {
			// TODO Handle Error Message
			
			return;
		}
		
		// add user to the user list
		activeUsers[userCount++] = username;
	}
	
	public void removeUser(User username) {
		int index = 0;
		
		// navigate through array until user is found or empty
		while (activeUsers[index] != null || activeUsers[index] != username) {
			index++;
		}
		
		// remove user if found
		if (activeUsers[index] == username) {
			activeUsers[index] = null;
		}
		
		// exit if not found
		else
			return;
	}
	
	public void addMessage(Message message) {
		
		// check to see if message array is full
		if (this.messageCount == MAX_MESSAGE_SIZE) {
			//TODO Add error message
			
			return;
		}
		
		messageHistory[messageCount] = message;
		messageCount++;
	}
}
