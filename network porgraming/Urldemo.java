import java.net.URL;
import java.io.*;
import java.net.URLConnection;
import java.util.*;

public class Urldemo {
    public static void main(String[] args) throws Exception  {
        URL hp = new URL("ftp://www.facebook.com/");
        URL hp1 = new URL("https://www.instagram.com/?hl=en");
        //   - يستخدم للحصول على بروتوكول الاتصال المستخدم في العنوان، في هذه الحالة سيكون "ftp".
        System.out.println("protocol wep 1 : "+hp.getProtocol() +"\n protocol wep 2 : " + hp1.getProtocol());
//   - يستخدم للحصول على رقم المنفذ المستخدم في الاتصال. إذا لم يكن هناك رقم منفذ محدد في العنوان URL، ستكون القيمة -1.
        System.out.println("ports wep 1 : "+hp.getPort() + "\n port wep 2 " + hp1.getPort()) ;
        //   - يستخدم للحصول على اسم المضيف (عنوان الموقع) في العنوان URL، في هذه الحالة سيكون "www.feacbook.com".
        System.out.println("host wep 1 : "+hp.getHost() + "\n host wep 2" + hp1.getHost());
        //   - يستخدم للحصول على جزء المسار بعد اسم المضيف في العنوان URL، في هذه الحالة لا يوجد مسار وستكون القيمة فارغة.
        System.out.println("files wep 1 :"+hp.getFile() +"\n files wep 2 " + hp1.getFile());
        //   - يستخدم للحصول على العنوان URL بشكل نصي كامل.
        System.out.println("externt form wep 1 :"+hp.toExternalForm() + "\n externt form wep 2 :" + hp1.toExternalForm()+"\n");

        URL obj1 = new URL("ftp://www.feacbook.com");
        System.out.println(obj1.getProtocol()+obj1.getHost()+ obj1.getFile()+obj1.toExternalForm()+obj1.getPort());
     URL obj2 = new URL("shkjgsdhkjg");
        URLConnection obj4=obj2.openConnection();
    }
}
