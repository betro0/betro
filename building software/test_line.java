import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class test_line {
    public static void main(String[] args) throws IOException {


           /*              ***************************************************
                           *******            الجزء الاول               *******
                           ***************************************************
         */
        //مطلوب رقم 1 يبدا من هنا
        String equation = "";
        // انشاء الملفات
        // انشاء ملف جديد
        File file1 = new File("test1.txt");
        file1.createNewFile();
        File file2 = new File("test3.txt");
        file2.createNewFile();
        FileWriter file_2 = new FileWriter("test3.txt");
        //اكتب محتوى الملف             ادخال محتوى الملف من كيبورد
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the content you want to transfer to another file \n" +
                "And take out the token for the content :");
        //  equation = in.nextLine();


        //ازالة تشغيل البرنامج اتناء ضغط انتر اي يعني سماح بي اضافة اسطر
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.equalsIgnoreCase("stop")) {
                break; //  عندما يتم كتابة "توقف"
            }
            equation += line + System.lineSeparator();
        }


        // ادخال محتوى الذي تمت كتابته للملف
        FileWriter text = new FileWriter("test1.txt");
        text.write(equation);
        text.close();
        // انشاء ملف جديد
        File e = new File("test2.txt");
        e.createNewFile();
        // قراءة محتوي الملف القديم
        FileReader fr = new FileReader("test1.txt");
        //ادخال المحتوى الملف  القديم للملف الجديد
        FileWriter ee = new FileWriter("test2.txt");
        //هده اللوب الغرض منها اخد الكلمات من الملف الاول بي الحرف ونقلها للملف الاخر بي الحرف كل حرف بروحه
        int i;
        while ((i = fr.read()) != -1)
            //ادخال الحروف المنقوله للملف الجديد
            ee.write( i);
        // equation = equation.replaceAll("(?m)^[ \t]*\r?\n", "");
        //equation.replaceAll("(?m)^[ \t]*\r?\n", "")

        //ازالة المسافات
        String result =  equation.replaceAll("\\s+", " ");
        ee.write("\nالمطلوب التالت وهوا ازالة المسافات \n" + result);
        // ee.close();



        /*              ***************************************************
                        ********            الجزء الثاني            *******
                        ***************************************************
        */

        //تكوين مصفوفة
        List<String> tokens = new ArrayList<>();
        StringBuilder token = new StringBuilder();
        for(int j =0 ; j < result.length(); j++){
            char c = result.charAt(j);  //شروط المتغيرات التي اريد تخصيصها
            if((c=='&' && j < result.length() - 1 && result.charAt(j+1) == '&') ||
                (c=='|' && j < result.length() - 1 && result.charAt(j+1) == '|') ||
                (c=='+' && j < result.length() - 1 && result.charAt(j+1) == '+') ||
                (c=='-' && j < result.length() - 1 && result.charAt(j+1) == '-') ||
                (c=='=' && j < result.length() - 1 && result.charAt(j+1) == '=') ||
                (c=='!' && j < result.length() - 1 && result.charAt(j+1) == '=') ||
                (c=='<' && j < result.length() - 1 && result.charAt(j+1) == '=') ||
                (c=='>' && j < result.length() - 1 && result.charAt(j+1) == '=') ||
                    //شرط  العمليات الحسابية والاقواس والعلامات الترقيم والخ
                 (c == ' ') || (c == '+') || (c == '-') || (c == '=') || (c == '*') || (c == '%') || (c == '/') ||
                 (c == '@') || (c == ';') || (c == ':') ||  (c == '}') || (c == '(') ||
                 (c == ')') || (c == '?') || (c == '<') || (c == '>')){

                 if (token.length() > 0) {
                  tokens.add(token.toString());
                  token.setLength(0);
                 }//هدا الشرط للمتغيرات التي تتكون من خانتين لكي يتعاملمعاها
                if (c != ' ') {
                    if((c =='&' && result.charAt(j+1) == '&') || (c == '|' && result.charAt(j+1) =='|') ||
                       (c == '+' && result.charAt(j+1) =='+') || (c == '-' && result.charAt(j+1) =='-') ||
                       (c == '=' && result.charAt(j+1) =='=') || (c == '!' && result.charAt(j+1) =='=') ||
                       (c == '<' && result.charAt(j+1) =='=') || (c == '>' && result.charAt(j+1) =='='))
                    {
                        tokens.add(String.valueOf(c)+ result.charAt(j+1));
                        j++;
                    } else {
                        tokens.add(String.valueOf(c));
                        //j++;
                    }
                }
            }
            else {
                token.append(c);
            }
        }
        if (token.length() > 0) {
            tokens.add(token.toString());
        }




        /*              ***************************************************
                        ********            الجزء الثالث            *******
                        ***************************************************
         */
        int id = 1;
        //مصفوفة لتخزين المتغيرات المخصصه وكل ماتم ادخاله
        List<String> processedTokens = new ArrayList<>();
        for (String t : tokens) {

            if (!processedTokens.contains(t)) {
                processedTokens.add(t);
//الان سوف نختبر الدي تم ادخاله وننضر في حال تم تكرار او لا لكي لا يتم تكرار توكن
                if (isLogicalOperation(t)) {
                    System.out.print("<logic," + t + ">");
                    file_2.write("<logic," + t + ">");
                } else if (isArithmeticOperation(t)) {
                    System.out.print("<op," + t + ">");
                    file_2.write("<op," + t + ">");
                } else if (kewords(t)) {
                    System.out.print("<" + t + ">");
                    file_2.write("<" + t + ">");
                } else if(consel(t)){
                    System.out.print("<consel >");
                    file_2.write("<consel >");
                }else if(token(t)){
                    System.out.print("<id,"+id+ ">");
                    file_2.write("<id,"+id+ ">");
                    id++;
                }else if(isArithmetic(t)){
                    System.out.print("<s,"+t+ ">");
                    file_2.write("<s,"+t+ ">");
                }
                else{
                    System.out.print("<id," + id + ">");
                    file_2.write("<id," + id + ">");
                    id++;
                }
            } else {// في حال تكرار
                int existingID = processedTokens.indexOf(t) + 1;
                if (isLogicalOperation(t)) {
                    System.out.print("<logic," + t + ">");
                    file_2.write("<logic," + t + ">");
                } else if (isArithmeticOperation(t)) {
                    System.out.print("<op," + t + ">");
                    file_2.write("<op," + t + ">");
                } else if (kewords(t)) {
                    System.out.print("<" + t + ">");
                    file_2.write("<" + t + ">");
                }else if(consel(t)){
                    System.out.print("<consel >");
                    file_2.write("<consel >");
                }else if(token(t)) {
                    System.out.print("<id ," + existingID + ">");
                    file_2.write("<id ," + existingID + ">");
                    id++;
                }else if(isArithmetic(t)){
                    System.out.print("<s,"+t+ ">");
                    file_2.write("<s,"+t+ ">");
                } else {
                    System.out.print("<id , " + existingID + " > ");
                    file_2.write("<id , " + existingID + " > ");
                }
            }
        }
        //اغلاق مسارات او قناوات الخاصات بي الفايل
    ee.close();
    file_2.close(); }

    //دوال لتخصيص قيم في طباعة
    private static boolean isArithmeticOperation(String word) {//دالة لاختبار العمليات الحسابية والهخ وتقوم يتعامل معا مخراجات اتناء طباعه
        return word.equals("=") ||  word.equals("+") || word.equals("-") ||  word.equals("*") ||  word.equals("/") ||  word.equals("%");
             //  word.equals("<") ||  word.equals(">") || word.equals("?") ||  word.equals(":") ||  word.equals(";") ||  word.equals(",") ||
              // word.equals(" ") ||  word.equals("@") || word.equals("(") ||  word.equals(")") ||  word.equals("{") ||  word.equals("}") ;
    }
    private static boolean isArithmetic(String word) {//دالة لاختبار العمليات الحسابية والهخ وتقوم يتعامل معا مخراجات اتناء طباعه
        return
                word.equals("<") ||  word.equals(">") || word.equals("?") ||  word.equals(":") ||  word.equals(";") ||  word.equals(",") ||
                word.equals(" ") ||  word.equals("@") || word.equals("(") ||  word.equals(")") ||  word.equals("{") ||  word.equals("}") ;
    }
    private static boolean isLogicalOperation(String word) {//دالة لاختبار المتغيرات المنطقية وتتعامل معا مخراجات في طباعتهم
        return word.equals("&&") || word.equals("||") ||
               word.equals("<=") || word.equals("++") ||
               word.equals("--") || word.equals(">=") ||
               word.equals("==") || word.equals("!=")  ;
    }
    private static boolean kewords(String word){//دالة تتعامل معا الكلمات المحجوزة
        return  word.equals("float") || word.equals("int")   || word.equals("char") ||
                word.equals("if")    || word.equals("scanf") || word.equals("print") ;
    }
    private static boolean consel (String word){

    return word.matches("\\d+[a-zA-Z]|\\d+\\.\\d+[a-zA-Z]|\\d+|\\d+\\.\\d+" ) ;
    }
    private static boolean token (String word){

        return word.matches("[a-zA-Z]\\d+|[a-zA-Z]\\d+\\.\\d+" ) ;
    }
}



