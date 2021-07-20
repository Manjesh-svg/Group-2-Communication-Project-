package Source;

import java.io.*;
import java.net.*;

public class handler implements Runnable{

	

        private final Socket clientSocket;
  
        // Constructor
        handler(Socket socket)
        {
            this.clientSocket = socket;
        }
  
        public void run()
        {
            PrintWriter writer = null;
            BufferedReader reader = null;
            try {
                    
                writer = new PrintWriter( clientSocket.getOutputStream(), true);
  
                reader = new BufferedReader( new InputStreamReader( clientSocket.getInputStream()));
  
                String line;
                while ((line = reader.readLine()) != null) {
  
                    // writing the received message from
                    // client
                    System.out.printf(" Sent from the client: %s\n",
                        line);
                    writer.println(line);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                    else if (reader != null) {
                        reader.close();
                        clientSocket.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

}
