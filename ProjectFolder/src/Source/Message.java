package Source;

public class Message {
	
	// Fields
	String contents;
	User sender;
	
	public Message(String contents) {
		this.contents = contents;
	}
	
	public void setSender(User sender) {
		this.sender = sender;
	}
	
	public String getSender() {
		return sender.getUser();
	}

}
