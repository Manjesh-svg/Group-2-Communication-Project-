package Source;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

public class AdminGUI implements AdminUserInterface {

	private UserDataBase udb;

	public AdminGUI(UserDataBase Users) {
		udb = Users;
	}

	public void processCommands() throws IOException {
		this.enterFilename();
		String[] commands = { "Add/Modify User", "Remove User","Exit and Save", "Exit without Saving" };

		int choice;

		do {
			choice = JOptionPane.showOptionDialog(null, udb.getNames() + "\n" + "Select a command: \n", "UserDataBase",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, commands,
					commands[commands.length - 1]);

			switch (choice) {
			case 0:
				doAddOrModifyUser();
				break;
			case 1:
				doRemoveUser();
				break;
			case 2:
				doSave();
				System.exit(2);
				break;
			default: // do nothing
			}

		} while (choice != commands.length - 1);
		System.exit(0);
	}

	private void doAddOrModifyUser() {
		String user = JOptionPane.showInputDialog(udb.getNames() + "\n" + "Enter Username:");
		if (user == null) {
			return; // dialog was cancelled
		}
		user = user.toUpperCase();

		String[] commands = { "Username", "Password", "First Name", "Last Name", "Cancel" };

		int choice;

		do {
			choice = JOptionPane.showOptionDialog(null, udb.getInfo(user) + "\n" + "Edit Info:" + "\n", "User Database",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, commands,
					commands[commands.length - 1]);
			
			String[] word = udb.getInfo(user).split("/");

			switch (choice) {
			case 0:
				String newUser = JOptionPane.showInputDialog(udb + "\n" + "Enter Username");
				if (newUser == null) {
					return; // dialog was cancelled
				}
				newUser = newUser.toUpperCase();
				udb.addOrModifyUser(newUser, word[1] , word[2], word[3]);
				break;
			case 1:
				String newPass = JOptionPane.showInputDialog("Enter new Password for " + user);
				if (newPass == null) {
					return; // dialog was cancelled
				}
				udb.addOrModifyUser(word[0], newPass , word[2], word[3]);
				break;
			case 2:
				String newFirst = JOptionPane.showInputDialog("Enter new First Name for " + user);
				if (newFirst == null) {
					return; // dialog was cancelled
				}
				newFirst = newFirst.toUpperCase();
				udb.addOrModifyUser(word[0], word[1] , newFirst, word[3]);
				break;
			case 3:
				String newLast = JOptionPane.showInputDialog("Enter new Last Name for " + user);
				if (newLast == null) {
					return; // dialog was cancelled
				}
				newLast = newLast.toUpperCase();
				udb.addOrModifyUser(word[0], word[1] , word[2], newLast);
				break;
			default: // do nothing
			}

		} while (choice != commands.length - 1);

	}

	private void doRemoveUser() {
		String user = JOptionPane.showInputDialog(udb.getNames() + "\n" + "Enter Username: ");
		if (user == null) {
			return; // dialog was cancelled
		}
		user = user.toUpperCase();
		udb.removeUser(user);

		JOptionPane.showMessageDialog(null, "Removing: " + user);
	}


	private void enterFilename() throws FileNotFoundException {
		String filename = JOptionPane.showInputDialog("Enter Filename");
		if (filename == null) {
			return; // dialog was cancelled
		}
		udb.loadData(filename);
	}

	private void doSave() throws IOException {
		udb.save();

	}

}
