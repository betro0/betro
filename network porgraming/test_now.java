public class test_now {
    public static void main(String[] args) {
        float x = 11;
        float y = 4;
        //لمعادلة رقم 1 وهيا مثل ما وضعت ف سؤال
        float prosses1 = x-x/y*y;
        System.out.println("prosses1 :" +prosses1);
        //المعادلة رقم 2 وهيا وضع الاقواس لتحديد اولويات العمليات ولتسهيل الحل وتوضيح
        float prosses2 = (x-x)/(y*y);
        System.out.println("\n prosses2 :"+ prosses2);
        //المعادلة رقم 3 وهيا اعطاء اولويات مثل مايقول الدكتور
        float prosses3 = x-(x/y)*y;
        System.out.println("\n prosses3 : "+prosses3);
        //نجد ان رياضيا وعلميا كل النواتج تتشابه اي يعني لافرق
    }
}
