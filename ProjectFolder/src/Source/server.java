import java.util.*;
import java.io.*;
import java.net.*; 

public class Server {
	
    public static void buildconnetion() {
        System.out.println("Configuring the server "); 												// socket = ip address + port number
        int port = 6868;
        ServerSocket socket = null;
        int count = 0;
        try {
            socket = new ServerSocket(port);
            socket.setReuseAddress(true);
            while(true) {



                System.out.println("\nServer Successfully started ");
                InetAddress localhost = InetAddress.getLocalHost();

                System.out.println("Listening on... " +  (localhost.getHostAddress()).trim() + ":6868");
              

                Socket connectionSocket = socket.accept();
                
                
                //TO DELETE
                InputStream inputStream = connectionSocket.getInputStream();
                System.out.println(inputStream.toString());
                
                
                Handler clientSocket = new Handler(connectionSocket);
                System.out.println("New client successfully connected " + count++); // it will continue to listen until there is a 																	// new connection that is pottentially trying to
                new Thread(clientSocket).start();										// creating a new thread....
               
                



            }

        } catch (IOException e) {
            System.out.println("There is something wrong with the connection, please try again");
            e.printStackTrace();
        }
    }




    public static void main(String args[])
    {
        buildconnetion();
    }

}
