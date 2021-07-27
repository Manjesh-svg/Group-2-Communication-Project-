package Source;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.swing.JOptionPane;


public class Client {
	private static String server = "localhost";	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{	
		
		// Fields
		ClientGUI cgui = new ClientGUI();
		Scanner scan = new Scanner(System.in);
		
		// Check if server is running
		try(Socket socket = new Socket(server, 6868)) {
			while(true) {
				
				// Display Login Screen
				String loginInfo = cgui.loginScreen();
				
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out.println(loginInfo);
				String loginResponse = in.readLine();
				
				int attempts = 0;
				// Send back to login screen if failed
				while (loginResponse.equals("false") && attempts < 3) {
					JOptionPane.showMessageDialog(null, "Login Failed. Please Try Again!", "!thiscord", JOptionPane.INFORMATION_MESSAGE);
					
					loginInfo = cgui.loginScreen();
					out.println(loginInfo);
					loginResponse = in.readLine();
					
					attempts++;
				}
				
				// Failed Attempts
				if (attempts >= 3) {
					JOptionPane.showMessageDialog(null, "Too Many Attempts", "!thiscord", JOptionPane.INFORMATION_MESSAGE);
					
					return;
				}
				
				// Access Main interface if successful
				if (loginResponse.equals("true")) {
					
					// Main Menu choice
					cgui.processCommands();
								
					
				}
				

				
			}
		}
	
		

	}

}
