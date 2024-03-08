import java.io.*;
import java.net.*;
import java.util.*;
public class Server {
    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        int ConnectionCount = 0;
        String lineReader = "";
        Object o;
        String reply = "";
        System.out.println("Server Starting");
        Hashtable names = new Hashtable();
        names.put("Fred Smith","f.smith@br.uk");
        names.put("Joe Bbgges","Joe.Bbgges@lei.uk");
        System.out.println( "Database done");
        try{
            ServerSocket ss = new ServerSocket (2500);
            while (true) {
                Socket s = ss.accept();
                ConnectionCount++;
                System.out.println("Connection "+ConnectionCount+" Once");
                is = s.getInputStream();
                os = s.getOutputStream();
                pw= new PrintWriter (os, true);
                br = new BufferedReader (new InputStreamReader (is));
                System.out.println("System Setup");
                lineReader = "";
                while (true) {
                    lineReader=br.readLine();
                    if (lineReader.equals("Exit"))
                        break;
                    o =names.get (lineReader);
                    if (o ==null)
                        reply ="User not Knows";
                    else{
                        reply = (String) o;
                        pw.println(reply);
                    }
                }
                pw.close();
                br.close();
                is.close();
                os.close();
                System.out.println( "Cloused Connection");
            }}
        catch (IOException e) {
            System.out.println("Trouble "+e);
        }}}