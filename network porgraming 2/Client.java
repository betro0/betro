import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Client extends JFrame implements ActionListener {

    JTextField userName, emailAddress;
    JButton saveData, quit;
    JTextField imageField, videoField;
    JButton uploadImage, uploadVideo;
    InputStream is = null;
    OutputStream os = null;
    PrintWriter pw = null;
    BufferedReader br = null;
    Socket socket;

    public Client() {
        setTitle("Client Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userName = new JTextField(10);
        emailAddress = new JTextField(20);
        saveData = new JButton("Save Data");
        quit = new JButton("Quit");
        imageField = new JTextField(10);
        videoField = new JTextField(10);
        uploadImage = new JButton("Upload Image");
        uploadVideo = new JButton("Upload Video");

        JPanel panel = new JPanel();
        panel.add(new JLabel("User Name:"));
        panel.add(userName);
        panel.add(new JLabel("Email Address:"));
        panel.add(emailAddress);
        panel.add(new JLabel("Image File:"));
        panel.add(imageField);
        panel.add(uploadImage);
        panel.add(new JLabel("Video File:"));
        panel.add(videoField);
        panel.add(uploadVideo);
        panel.add(saveData);
        panel.add(quit);

        add(panel);
        setVisible(true);

        saveData.addActionListener(this);
        quit.addActionListener(this);
        uploadImage.addActionListener(this);
        uploadVideo.addActionListener(this);

        try {
            socket = new Socket("127.0.0.1", 2500);
            is = socket.getInputStream();
            os = socket.getOutputStream();
            pw = new PrintWriter(os, true);
            br = new BufferedReader(new InputStreamReader(is));
        } catch (IOException e) {
            System.out.println("Error connecting to the server: " + e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String buttonTest = ae.getActionCommand();
        String typedName;
        String typedEmail;
        try {
            if (buttonTest.equals("Quit")) {
                pw.println("Exiting The Server");
                pw.println("Exit");
                is.close();
                os.close();
                pw.close();
                br.close();
                socket.close();
                System.exit(0);
            }
            if (buttonTest.equals("Save Data")) {
                typedName = userName.getText();
                typedEmail = emailAddress.getText();
                pw.println(typedName + "," + typedEmail);

                // Display confirmation message to the user
                System.out.println("Data Saved Successfully!");

                // Optionally, you can also read a response from the server if needed.
            }
            if (buttonTest.equals("Upload Image") || buttonTest.equals("Upload Video")) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    if (buttonTest.equals("Upload Image")) {
                        imageField.setText(selectedFile.getAbsolutePath());
                    } else {
                        videoField.setText(selectedFile.getAbsolutePath());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Problem Connecting The Server to send/receive " + e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Client();
            }
        });
    }
}
