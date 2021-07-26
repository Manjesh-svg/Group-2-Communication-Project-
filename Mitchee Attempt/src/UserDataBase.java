import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class UserDataBase {
	public int numUsers;
	private User[] userArray;
	private String sourceName;
	private static int MAX_USER_SIZE = 10;
	
	public UserDataBase() {
		numUsers = 0;
		userArray = new User[MAX_USER_SIZE];
	}
	
	public void addOrModifyUser(String username, String password, String isAdmin) {
		
		// Turn isAdmin to a boolean
		boolean adminBool;
		if (isAdmin == "true") {
			adminBool = true;
		}		
		
		else {
			adminBool = false;
		}
		
		// Check if array is full
		if (numUsers >= MAX_USER_SIZE) {
			return; // TODO SEND ERROR MESSAGE SAYING ARRAY IS FULL
		}
		
		// Go to open space in array
		int index = 0;
		while (userArray[index] != null) {
			
			// Stop iterating and break out of loop if user is already in array
			String tempUser = userArray[index].getUsername().toString();
			if (tempUser.equals(username)) {
				return; // TODO SEND ERROR MESSAGE SAYING USER IS IN ARRAY ALREADY
			}
			
			index++;
		}
		
		// Add user to the array
		userArray[index] = new User(username, password, adminBool);
		numUsers++;
		
		// Sort Alphabetically
		this.alphaOrder();
				
	}
	
	public int getArraySize() {
		return numUsers;
	}
	
	public void loadData() throws FileNotFoundException {
		
		sourceName = "userdata.txt";
		File inFile = new File(sourceName);
		Scanner scan = new Scanner(inFile);
		
		// Navigate through file until at the end
		while (scan.hasNextLine()) {
			String[] info = scan.nextLine().split(",");
			addOrModifyUser(info[0], info[1], info[2]);
		}
		
		scan.close();
	}
	
	public void removeUser(String username) {

		// Make an array copy to hold content temporarily
		User[] tempArray;
		tempArray = new User[userArray.length];
		
		// navigate through array until item is found or no more items
		int index = 0;
		String tempString = userArray[index].getUsername();
		
		while (!tempString.equals(username)) {
			index++;
			
			// Break out if index = null
			if (userArray[index] == null) {
				break;
			}
			
			tempString = userArray[index].getUsername();
		}
		
		if (tempString.equals(username)) {
			
			// Put Content Back in array
			System.arraycopy(userArray, 0, tempArray, 0, index);
			System.arraycopy(userArray, index + 1, tempArray, index, userArray.length - index - 1);
			
			// Sort alphabetically
			this.alphaOrder();
			
			numUsers--;
		}

	}
	
	public User getUser(int index) {
		return userArray[index];
	}
	
	public String getUserName(User findUser) {
		return findUser.username;	
	}

	public void saveData() throws IOException {
		FileWriter outFile = new FileWriter(this.sourceName);
		for (int i = 0; i < this.numUsers; i++) {
			String line = this.userArray[i].toString().replace("/", ",");
			outFile.write(line + "\n");
		}
		outFile.close();
	}
	
	private void alphaOrder() {
		Arrays.sort(userArray, 0, this.numUsers, (x, y) -> {
			return x.getUsername().compareTo(y.getUsername());
		});
	}
	
	public String getUsernames() {
		String temp = "";
		
		int index = 0;
		while (userArray[index] != null) {
			temp += userArray[index].getUsername() + "\n";
			
			index++;
		}
		
		return temp;
	}
	
	public String getPasswords() {
		String temp = "";
		for(int i = 0; i< numUsers; i++) {
			temp += userArray[i].getPassword() + ",";
		}
		return temp;
	}
	
	public User findUserString(String userLogged) {
		int index = 0;
		
		// navigate the array
		while (userArray[index] != null) {
			
			// compare names
			if (userArray[index].getUsername().equals(userLogged)) {
				return userArray[index];
			}
			
			index++;
		}
		
		return userArray[index];
		
	}
	
	public boolean checkCredentials(String userInfo, String passInfo) {
		int index = 0;
		
		// Navigate through array until user is found or array reaches end
		while (userArray[index] != null) {
			
			// If User name is found
			if (userArray[index].getUsername().equals(userInfo)) {
				
				// Check password for user
				if (userArray[index].getPassword().equals(passInfo)) {
					return true;
				}
				
				else {
					return false;
				}
			}
			
			index++;
		}
		
		if (userArray[index] == null) {
			return false;
		}
		
		// return false since user name wasn't found
		else {
			return false;
		}

	}
}