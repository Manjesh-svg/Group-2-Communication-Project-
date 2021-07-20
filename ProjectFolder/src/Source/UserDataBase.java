package Source;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class UserDataBase {
	private int numUsers;
	private User[] userArray;
	private String sourceName;
	
	public UserDataBase() {
		numUsers = 0;
		userArray = new User[7];
	}
	
	public void addOrModifyUser(String Username, String Password, String fName, String lName) {
		Username = Username.toUpperCase();
		fName = fName.toUpperCase();
		lName = lName.toUpperCase();
		
		if(!passwordChecker(Password)) {
			System.out.println("Invalid Password...Try Again.");
			return;
		}
		
		if (this.numUsers == 0) {
			User newUser = new User(Username, Password, fName, lName);
			userArray[this.numUsers] = newUser;
			this.numUsers = this.numUsers + 1;

		} else if (this.numUsers >= this.userArray.length) {
			User[] temp = new User[this.numUsers];
			System.arraycopy(userArray, 0, temp, 0, numUsers);
			userArray = new User[this.numUsers * 2];
			System.arraycopy(temp, 0, userArray, 0, numUsers);
			for (int i = 0; i < numUsers; i++) {
				if (Username.equals(this.userArray[i].getUser())) {
					userArray[i].setPass(Password);
					userArray[i].setFirstName(fName);
					userArray[i].setLastName(lName);
					return;
				}
			}
			User newUser = new User(Username, Password, fName, lName);
			userArray[this.numUsers] = newUser;
			this.numUsers = this.numUsers + 1;
			this.alphaOrder();
		} else if (this.numUsers != 0) {
			for (int i = 0; i < this.numUsers; i++) {
				if (Username.equals(this.userArray[i].getUser())) {
					userArray[i].setPass(Password);
					userArray[i].setFirstName(fName);
					userArray[i].setLastName(lName);
					return;
				}
			}
			User newUser = new User(Username, Password, fName, lName);
			userArray[this.numUsers] = newUser;
			this.numUsers = this.numUsers + 1;
			this.alphaOrder();
		}
	}
	
	public void loadData(String filename) throws FileNotFoundException {
		this.sourceName = filename;
		File inFile = new File(this.sourceName);
		Scanner temp = new Scanner(inFile);
		while (temp.hasNextLine()) {
			String line = temp.nextLine();
			String[] word = line.split(",");
			if (word.length == 4) {
				addOrModifyUser(word[0], word[1], word[2],word[3]);
			}
		}
		temp.close();
	}
	
	public void removeUser(String username) {
		for (int i = 0; i < this.numUsers; i++) {
			if (userArray[i].getUser().contains(username)) {
				this.numUsers = this.numUsers - 1;
				for (int x = i; x < this.numUsers; x++) {
					userArray[i].setUser(userArray[x + 1].getUser());
					userArray[i].setPass(userArray[x + 1].getPass());
					userArray[i].setFirstName(userArray[x + 1].getfName());
					userArray[i].setLastName(userArray[x + 1].getlName());
				}
			}
		}
		this.alphaOrder();
	}
	
	public String getNames() {
		String temp = "";
		for(int i = 0; i < numUsers; i++) {
			temp += userArray[i].getUser() + ", " + userArray[i].getlName() +", " + userArray[i].getfName() + "\n";
		}
		return temp;
	}
	
	public String getInfo(String Username) {
		String temp = "";
		for (int i = 0; i < numUsers; i++) {
			if (Username.equals(this.userArray[i].getUser())) {
				temp += this.userArray[i].getUser() + "/";
				temp += this.userArray[i].getPass() + "/";
				temp += this.userArray[i].getfName()+ "/";
				temp += this.userArray[i].getlName();
				break;
			}
		}
		return temp;
	}

	public void save() throws IOException {
		FileWriter outFile = new FileWriter(this.sourceName);
		for (int i = 0; i < this.numUsers; i++) {
			String line = this.userArray[i].toString().replace("/", ",");
			outFile.write(line + "\n");
		}
		outFile.close();
	}
	
	private void alphaOrder() {
		Arrays.sort(userArray, 0, this.numUsers, (x, y) -> {
			return x.getlName().compareTo(y.getlName());
		});
	}
	
	private boolean passwordChecker(String Password) {
		String[] invalidPass = {"test", "1234567", "help", "", "password"};
		for(int i = 0; i < invalidPass.length; i++) {
			if(Password.equals(invalidPass[i])) {
				return false;
			}
		}
		return true;
		
	}
}
