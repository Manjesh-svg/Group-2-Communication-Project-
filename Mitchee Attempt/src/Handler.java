
import io.github.pixee.security.BoundedLineReader;
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
            data.loadData();
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
        	while ((toSplit = BoundedLineReader.readLine(inputStream, 5_000_000)) != null) {
        		
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
        	String answer = BoundedLineReader.readLine(inputStream, 5_000_000);
        	if (answer.equals("create room")) {
        		String info = data.getUsernames();
        		
        		output.println(info);
        	}
        	
        	
        } catch (IOException e) {
        	System.out.println("Everything is wrong.");
        }

    }
}
