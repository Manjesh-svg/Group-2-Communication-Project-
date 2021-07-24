
import java.io.*;
import java.net.*;
import java.util.HashMap;

public class handler implements Runnable {


    private final Socket clientSocket;
    private HashMap<String, String> loggin;
    private String[] Password;
    private String[] Username;
    private UserDataBase data;


    handler(Socket socket) {
        this.data = new UserDataBase();

        try {
            data.loadData("userdata.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        loggin = new HashMap<>();                            // This will store all the nessessary Username and
        // passwords within the hash and handle client connections
        Password = new String[14];
        Username = new String[14];
        loadHashMap();
        this.clientSocket = socket;

    }

    public void loadHashMap() {

        String password = data.getUsernames();
        String user = data.getUsernames();


        this.Password = password.split(",");
        this.Username = user.split(",");
        for (int count = 0; count < Username.length; count++) {
            loggin.put(Username[count], Password[count]);
        }
        return;


    }

    public void run() {

        PrintWriter writer = null;
        BufferedReader reader = null;
        try {

            writer = new PrintWriter(clientSocket.getOutputStream(), true);

            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {

                String loginns[] = new String[2];
                        loginns = line.split(",");
                writer.println(loggin.containsKey(loginns[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                } else if (reader != null) {
                    reader.close();
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}