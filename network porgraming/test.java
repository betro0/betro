import java.net.InetAddress;
import java.net.UnknownHostException;

public class test {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        address=InetAddress.getByName("www.facebook.com");
        System.out.println(address.getHostAddress());
    }
    }