import java.net.URL;
import java.io.*;
import java.net.URLConnection;

public class url_connectio {
    public static void main(String[] args) throws IOException {
        URL hp = new URL ("https://www.facebook.com/");
        URLConnection hplon = hp.openConnection();
        //ستخدم للحصول على طول المحتوى المرتبط بالاتصال. يُرجى ملاحظة أن قيمة الطول قد تكون -1 إذا لم تكن معروفة.
        System.out.println(hplon.getContentLength());
        //يستخدم للحصول على المسار (الجزء بعد اسم المضيف في عنوان URL) المرتبط بالكائن URL.
        System.out.println(hp.getFile());
        //ستخدم للحصول على تاريخ آخر تحديث للمحتوى المتصل. يمكن أن تعود قيمة  إذا لم يتم تحديد تاريخ.0
        System.out.println("DATE : " + hplon.getDate());
        //يستخدم للحصول على نوع المحتوى المتصل. على سبيل المثال، "text/html" لصفحات الويب HTML.
        System.out.println("contunt type : " + hplon.getContentType());
        //يستخدم للحصول على تاريخ انتهاء الصلاحية للمحتوى المتصل، إذا كان هذا التاريخ معروفًا.
        System.out.println("Expines : " + hplon.getExpiration());
    }
}
