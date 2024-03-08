import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inet_address_test {
    public static void main(String[] args) throws UnknownHostException {
        //تُستخدم للحصول على InetAddress للجهاز الحالي (الجهاز الذي يقوم بتشغيل الكود). يتم تخزين عنوان IP المحلي للجهاز في InetAddress ويتم طباعته.
       InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
//تُستخدم للحصول على InetAddress باستخدام اسم المضيف (Hostname) أو عنوان IP. في هذا الحالة، يتم استخدام سلسلة فارغة ""، وهو يرجع InetAddress يمثل عنوان IP للجهاز الحالي.
         address = InetAddress.getByName("www.facebook.com");
        System.out.println(address);
        //يُستخدم للحصول على عنوان IP الذي تمثله InetAddress بشكل نصي.
        System.out.println( address.getHostAddress());
        System.out.println(address);
//تُستخدم للحصول على مصفوفة من InetAddress تمثل جميع عناوين IP المرتبطة بالاسم المضيف. في هذا الحالة، يتم استخدام سلسلة فارغة ""، ويُطبع عنوان كل جهاز على الشبكة.
       InetAddress[] sw =InetAddress.getAllByName("www.facebook.com");
        for (int i = 0 ; i < sw.length ; i++){
           System.out.println(sw[i]);
     }
   }
}
