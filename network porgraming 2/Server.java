import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        int connectionCount = 0;
        Hashtable<String, String> names = new Hashtable<>();
        Hashtable<String, String> images = new Hashtable<>();
        Hashtable<String, String> videos = new Hashtable<>();

        System.out.println("Server Starting");

        try {
            ServerSocket ss = new ServerSocket(2500);

            while (true) {
                Socket s = ss.accept();
                connectionCount++;
                System.out.println("Connection " + connectionCount + " Accepted");

                is = s.getInputStream();
                os = s.getOutputStream();
                pw = new PrintWriter(os, true);
                br = new BufferedReader(new InputStreamReader(is));

                System.out.println("System Setup");

                // Read user input and store it in the Hashtable
                String userInput = br.readLine();
                String[] userData = userInput.split(",");
                if (userData.length == 2) {
                    names.put(userData[0], userData[1]);

                    // Display confirmation message in the Run window
                    System.out.println("Data Saved: " + userData[0] + ": " + userData[1]);

                    // Send a confirmation message to the client
                    pw.println("User data saved successfully!");
                } else {
                    pw.println("Invalid input format. Please enter data in the format: name,email");
                    continue;
                }

                // Handle image and video uploads
                String userImage = br.readLine();
                String userVideo = br.readLine();
                if (!userImage.isEmpty()) {
                    images.put(userData[0], userImage);
                    System.out.println("Image file saved for user " + userData[0] + ": " + userImage);
                }
                if (!userVideo.isEmpty()) {
                    videos.put(userData[0], userVideo);
                    System.out.println("Video file saved for user " + userData[0] + ": " + userVideo);
                }

                // Display stored data in the Run window
                System.out.println("Data Stored in Hashtables:");
                System.out.println("Names: " + names);
                System.out.println("Images: " + images);
                System.out.println("Videos: " + videos);

                pw.close();
                br.close();
                is.close();
                os.close();

                System.out.println("Closed Connection");
            }
        } catch (IOException e) {
            System.out.println("Trouble " + e);
        }
    }
}
