import javax.swing.*; 
public class LoginGUI {

	public static void buildGUI() { 
		
		// creating the entire layout
		JPanel panel = new JPanel(); 
		JFrame frame = new JFrame(); 
		
		
		frame.setSize(500, 500); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel); 
		
		panel.setLayout(null); 
		JLabel label = new JLabel("UserName"); 		// create the entire labels
											// for prompting the users for 
											// loggin name and passwords 
		label.setBounds(10, 20, 80, 25);
		panel.add(label); 
		
		
		JTextField userText = new JTextField(); 
		userText.setBounds(100, 20, 165, 25); 
		panel.add(userText); 
		
		JLabel label2 = new JLabel("Password"); 		 
		label2.setBounds(10, 50, 80, 25);
		panel.add(label2); 
		
		JPasswordField passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25); 
		panel.add(passwordText);
		
		JButton button = new JButton("Login"); 
		button.setBounds(10, 80, 80, 25); 
		panel.add(button); 
		
		
		frame.setVisible(true); 
	}
		
		public static void main(String[] args) { 
			buildGUI();  
		}
		
}
