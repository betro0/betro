
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.io.Serializable;

public class UserDataHandler {
    // UserApp Class


    class UserApp implements Serializable {
        private String name;
        private String email;

        public UserApp(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    private Hashtable<String, String> userData = new Hashtable<>();

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);  // Server listens on port 12345

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());

            // Receive UserApp object from the client
            UserApp user = (UserApp) inputStream.readObject();

            // Store user data in the Hashtable
            userData.put(user.getName(), user.getEmail());

            // Send acknowledgment back to the client
            sendAcknowledgment(clientSocket);

            inputStream.close();
            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void sendAcknowledgment(Socket clientSocket) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            // Send acknowledgment back to the client
            outputStream.writeObject("Data received and stored successfully.");

            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create an instance of UserDataHandler and start the server
        UserDataHandler userDataHandler = new UserDataHandler();
        userDataHandler.startServer();
    }
}
