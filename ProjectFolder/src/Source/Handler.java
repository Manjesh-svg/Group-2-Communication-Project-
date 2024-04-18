package Source;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Handler implements Runnable {


    private final Socket clientSocket;
    private UserDataBase data;

    Handler(Socket socket) {
        this.data = new UserDataBase();

        try {
            data.loadData("userdata.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.clientSocket = socket;

    }

    public void run() {
    	
        
        try {
        	
        	BufferedReader inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        	PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);      	
        	
        	
        	// Check Authentication
        	String toSplit;
        	while ((toSplit = inputStream.readLine()) != null) {
        		
        		String[] clientInfo = toSplit.split(",");
        		
        		boolean results = data.checkCredentials(clientInfo[0], clientInfo[1]);
            	
            	if (results == false) {
            		output.println("false");        		
            	}
            	
            	else {
            		output.println("true");
            	}
        		
        	}
     	
        } catch (IOException e) {
        	System.out.println("Something went wrong.");
        }
        
        // create new chat room
        try {
        	
          	BufferedReader inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        	PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);      	
        	
        	// Get user list
        	String answer = inputStream.readLine();
        	if ("create room".equals(answer)) {
        		String info = data.getUsernames();
        		
        		output.println(info);
        	}
        	
        	
        } catch (IOException e) {
        	System.out.println("Everything is wrong.");
        }

    }
}
