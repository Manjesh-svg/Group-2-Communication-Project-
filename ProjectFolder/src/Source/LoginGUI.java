package Source;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.awt.event.ActionListener;

import javax.swing.*; 
public class LoginGUI extends MainPanel{
	
	private static JLabel label;
	private static JTextField userText;
	private static JLabel label2;
	private static JPasswordField passwordText;
	private static Socket socket; 
	 private static String server = "127.0.0.1";         // the ip address the server is being run on
	 
	
	
	public static void buildGUI() throws UnknownHostException, IOException { 
		//try(Socket socket = new Socket(server, 6868)){              // if the server is running, and the client
		// creating the entire layout
		JPanel panel = new JPanel(); 
		JFrame frame = new JFrame(); 
		
		
		frame.setSize(500, 500); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel); 
		
		panel.setLayout(null); 
		label = new JLabel("UserName"); 		// create the entire labels
											// for prompting the users for 
											// loggin name and passwords 
		label.setBounds(10, 20, 80, 25);
		panel.add(label); 
		
		
		userText = new JTextField(); 
		userText.setBounds(100, 20, 165, 25); 
		panel.add(userText); 
		
		label2 = new JLabel("Password"); 		 
		label2.setBounds(10, 50, 80, 25);
		panel.add(label2); 
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25); 
		panel.add(passwordText);
		
		JButton button = new JButton("Login"); 
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try(Socket socket = new Socket(server, 6868)){              // if the server is running, and the client
					// creating the entire layout
				
				// TODO Auto-generated method stu
				String user = userText.getText(); 
				String password = passwordText.getText(); 
				System.out.println(user + ", " + password);
				
				
				PrintWriter out;
					out = new PrintWriter( socket.getOutputStream(), true);
		
		            // reading from server
		            BufferedReader in
		                = new BufferedReader(new InputStreamReader(
		                		socket.getInputStream()));

		            while (true) {
		                
		  
		                // sending the user input to server
		                out.println(user + "," + password);
		                out.flush();
		                if(in.readLine(). contains("true")) { 
//		                	System.out.println("Login Successful"); 
		                	
		                	MainPanel.main("Hello wold");
		                	
		                	break;
		                }
		                else { 
		                	System.out.println("Try Again");
		                	break;
		                	
		                }
		
		            }   
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
		            }
			
		});
		button.setBounds(10, 80, 80, 25); 
		panel.add(button); 
		
		
		frame.setVisible(true);
	}
	//return; 
//}

		
		public static void main(String[] args) { 
			try {
				buildGUI();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	
		
}
