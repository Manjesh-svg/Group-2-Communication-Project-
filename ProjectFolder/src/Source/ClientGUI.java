package Source;

import java.util.Scanner;
import java.io.*;

import javax.swing.*;

public class ClientGUI {

	private UserDataBase data = new UserDataBase();
	public ChatRoom chatRoom;
	public User tempUser;
	public Message[] tempMessage;
	public String userLogged;
	public String passLogged;
	
	
	
	public ClientGUI() throws FileNotFoundException {
		data.loadData("userdata.txt");
	}
	
	
	public String loginScreen() {
		String info;
		Scanner scan = new Scanner(System.in);
		
		// Put User name
		String userAttempt = JOptionPane.showInputDialog("Enter Username");
		if (userAttempt == null) {
			return null;	// dialog is cancelled
		}
		
		info = userAttempt + ",";
		
		// Put Password
		String passAttempt = JOptionPane.showInputDialog("Enter Password");
		if (passAttempt == null) {
			return null; // dialog is cancelled
		}
		
		info += passAttempt;
		
		// remember Users Login info for later
		userLogged = userAttempt;
		passLogged = passAttempt;
		
		
		return info;
	}
	
	
	
	public void processCommands() {
		String[] commands = {"Create New Chat Room",
				"View Existing Chat Rooms",
				"Settings",
				"Exit"};
		
		int choice = 9;
		
		while (choice != 0) {
			choice = JOptionPane.showOptionDialog(null, 
					"Select a command", 
					"!thiscord", 
					JOptionPane.YES_NO_CANCEL_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					commands, 
					commands[commands.length - 1]);
			
			switch (choice) {
			case 0: createRoom(); break;
			case 1: joinRoom(); break;
			case 2: settings(); break;
			case 3: exit(); break;
			default:
			}
		}
			
			
	}
	
	public void createRoom() {
		
		chatRoom = new ChatRoom();
		boolean allUsers = false;
		
		// add users to chat room
		while (allUsers == false ) {
			
			User addUser = UserList();
			chatRoom.addUser(addUser);
			
			// update user chatroom data
			
			String[] commands = {"Add More Users", "Done Adding"};
		 
			int choice;
		 
			do {
				choice = JOptionPane.showOptionDialog(null,
						"Add more Users?", 
					 	"!notthiscord", 
					 	JOptionPane.YES_NO_CANCEL_OPTION, 
					 	JOptionPane.QUESTION_MESSAGE, 
					 	null, 
					 	commands,
					 	commands[commands.length - 1]);
		 
				switch (choice) {
					case 0: addUser = UserList(); break;
					case 1: allUsers = true; break;
				}
			} while (choice != commands.length - 1);
		}
		
		// Display chatroom just made
		int id = chatRoom.id;
		displayChatRoom(id);
		

		
	}
	
	public void joinRoom() {
		
		
	}
	
	public void settings() {
		
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public void displayChatRoom(int id) {
		String[] commands = {"Read Chat Log", "Send Message", "Exit"};
		 
		int choice;
	 
		do {
			choice = JOptionPane.showOptionDialog(null,
					"ChatRoom #" + chatRoom.id, 
				 	"!notthiscord", 
				 	JOptionPane.YES_NO_CANCEL_OPTION, 
				 	JOptionPane.QUESTION_MESSAGE, 
				 	null, 
				 	commands,
				 	commands[commands.length - 1]);
	 
			switch (choice) {
				case 0: showChatLog(); break;
				case 1: sendMessage(); break;
			}
		} while (choice != commands.length - 1);
		
	}
	
	public void showChatLog() {
		tempMessage = chatRoom.getMessageHistory();
		
		// Make array of strings from tempMessage
		String[] messageString = new String[chatRoom.messageCount];
		
		int index = 0;
		while (index < chatRoom.messageCount) {
			messageString[index] = tempMessage[index].getSender() + ": " + tempMessage[index].contents;
			
			index++;
		}
		
		JOptionPane.showMessageDialog(null, messageString, "!thiscord", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void sendMessage() {
		
		String message = JOptionPane.showInputDialog("Enter Message");
		Message toAdd = new Message(message);
		
		// Apply Sender details to message
		toAdd.sender = data.findUserString(userLogged);
		chatRoom.addMessage(toAdd);	
		
	}
	
	public User UserList() {
		
		// Make an array that has all users
		User[] list = new User[data.getArraySize()];
		String[] nameList = new String[data.getArraySize()];
		
		// Fill up array with each User
		int index = 0;
		while (index < data.getArraySize()) {
			list[index] = data.getUser(index);
			nameList[index] = data.getUserName(list[index]);
			index++;
		}
		
		index = 0;
		Object selectedUser = JOptionPane.showInputDialog(null, "Select User to Add" , "!thiscord", JOptionPane.QUESTION_MESSAGE, null, nameList, data.getUser(index));
		
		// return null if no user was selected
		if (selectedUser == null) {
			return null;
		}
		
		// figure out which user was selected in array
		{
			index = 0;
			while (index < data.getArraySize() ) {
				if (selectedUser.toString().equals(list[index].getUser())) {
					return list[index];
				}
				
				index++;
			}
		}
		
		return list[index];
	}
	
}
