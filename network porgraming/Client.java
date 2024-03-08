import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class Client extends Frame implements ActionListener {

    TextField UserName,EmailAddress;
    Button StartProcessing,Quit;
    InputStream is=null;
    OutputStream os=null;
    PrintWriter pw=null;
    BufferedReader br=null;
    Socket s;
    Client(String title){
        super(title);
        UserName=new TextField(10);
        EmailAddress=new TextField(20);
        StartProcessing=new Button("Start");
        Quit=new Button("Quit");
        setLayout(new GridLayout(4,1));
        add(new Label("User Name"));
        add(UserName);
        add(new Label("Email Address"));
        add(EmailAddress);
        add(StartProcessing);
        add(Quit);
        setSize(150,300);
        setVisible(true);
        StartProcessing.addActionListener(this);
        Quit.addActionListener(this);
        try{
            s=new Socket("127.0.0.1",2500);
            is=s.getInputStream();
            os=s.getOutputStream();
            pw=new PrintWriter(os,true);
            br =new BufferedReader(new InputStreamReader(is));
        }
        catch(IOException e){
            System.out.println("Error Connection with the Server "+e);
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String buttonTest=ae.getActionCommand();
        String typedName;
        String receivedAddress;
        try{
            if(buttonTest.equals("Quit")){
                pw.println("Exiting The Server");
                pw.println("Exit");
                is.close();
                os.close();
                pw.close();
                br.close();
                s.close();
                System.exit(0);}
            if(buttonTest.equals("Start")){
                typedName=UserName.getText();
                pw.println(typedName);
                receivedAddress=br.readLine();
                EmailAddress.setText(receivedAddress);
            }
        }
        catch(IOException e){
            System.out.println("Problem Connecting The Server to send/recevied "+e);
        }
    }
    public static void main(String[] args){
        Client c=new Client("client Example");
    }
}
