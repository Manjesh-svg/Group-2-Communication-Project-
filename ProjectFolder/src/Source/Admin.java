package Source;

import java.io.IOException;
import java.util.Scanner;


public class Admin {
	public static void main(String[] args) throws IOException {
		AdminUserInterface auInterface;
		UserDataBase udb = new UserDataBase();
		
		Scanner scan = new Scanner(System.in);
		
		auInterface = new AdminGUI(udb);
		auInterface.processCommands();
		
		
		
	}
}
