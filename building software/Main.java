import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println(" انتظر ينتهي البرنامج من فحص الملف ");

        //استدعاء الملف الدي نريد قرائته
        FileReader h = new FileReader("ekhlas.txt");
        StringBuilder content = new StringBuilder();
        int character;
        while ((character = h.read()) != -1) {
            content.append((char) character);
        }
        //تخزين محتوى الملف في متغير نصي لمعالجته
        String resul = content.toString();
        //انشاء ملفات لنتخزين فيها token
        File file2 = new File("token.txt");
        file2.createNewFile();
        FileWriter file_2 = new FileWriter("token.txt");
        File e = new File("text_on_space.txt");
        e.createNewFile();
        FileWriter l = new FileWriter("text_on_space.txt");
        //ازالة المسافات
        int i;
        while ((i = h.read()) != -1)
            l.write(i);
        String result = resul.replaceAll("\\s+", " ");
        l.write("\nالمطلوب هوا ازالة المسافات \n" + result);

        //معالجة لاخراج التوكن
        List<String> to = new ArrayList<>();
        StringBuilder tok = new StringBuilder();
        for (int j = 0; j < result.length(); j++) {
            char a = result.charAt(j);
            if ((a == '&' && j < result.length() - 1 && result.charAt(j + 1) == '&') ||
                    (a == '|' && j < result.length() - 1 && result.charAt(j + 1) == '|') ||
                    (a == '+' && j < result.length() - 1 && result.charAt(j + 1) == '+') ||
                    (a == '-' && j < result.length() - 1 && result.charAt(j + 1) == '-') ||
                    (a == '=' && j < result.length() - 1 && result.charAt(j + 1) == '=') ||
                    (a == '!' && j < result.length() - 1 && result.charAt(j + 1) == '=') ||
                    (a == '<' && j < result.length() - 1 && result.charAt(j + 1) == '=') ||
                    (a == '>' && j < result.length() - 1 && result.charAt(j + 1) == '=') ||
                    //شرط  العمليات الحسابية والاقواس والعلامات الترقيم والخ
                    (a == ' ') || (a == '+') || (a == '-') || (a == '=') || (a == '*') || (a == '%') || (a == '/') ||
                    (a == '@') || (a == ';') || (a == ':') || (a == '.') || (a == '{') || (a == '}') || (a == '(') ||
                    (a == ')') || (a == '?') || (a == '>') ) {
                if (tok.length() > 0) {
                    to.add(tok.toString());
                    tok.setLength(0);
                }
                if (a != ' ') {
                    if ((a == '&' && result.charAt(j + 1) == '&') || (a == '|' && result.charAt(j + 1) == '|') ||
                            (a == '+' && result.charAt(j + 1) == '+') || (a == '-' && result.charAt(j + 1) == '-') ||
                            (a == '=' && result.charAt(j + 1) == '=') || (a == '!' && result.charAt(j + 1) == '=') ||
                            (a == '<' && result.charAt(j + 1) == '=') || (a == '>' && result.charAt(j + 1) == '=')) {
                        to.add(String.valueOf(a) + result.charAt(j + 1));
                        j++;
                    } else {
                        to.add(String.valueOf(a));
                    }
                }
            } else {
                tok.append(a);
            }
        }
        if (tok.length() > 0) {
            to.add(tok.toString());
        }
        //طباعة وتخزين التوكن بعد المعالجة
        int ID = 1;
        List<String> processedTokens = new ArrayList<>();
        for (String T : to) {
            if (!processedTokens.contains(T)) {
                processedTokens.add(T);
                if (isLogicalOperation(T)) {
                    System.out.print("<logic," + T + ">");
                    file_2.write("<logic," + T + ">");
                } else if (isArithmeticOperation(T)) {
                    System.out.print("<op," + T + ">");
                    file_2.write("<op," + T + ">");
                } else if (kewords(T)) {
                    System.out.print("<" + T + ">");
                    file_2.write("<" + T + ">");
                } else {
                    System.out.print("<id," + ID + ">");
                    file_2.write("<id," + ID + ">");
                    ID++;
                }
            } else {// في حال تكرار
                int existingID = processedTokens.indexOf(T) + 1;
                if (isLogicalOperation(T)) {
                    System.out.print("<logic," + T + ">");
                    file_2.write("<logic," + T + ">");
                } else if (isArithmeticOperation(T)) {
                    System.out.print("<op," + T + ">");
                    file_2.write("<op," + T + ">");
                } else if (kewords(T)) {
                    System.out.print("<" + T + ">");
                    file_2.write("<" + T + ">");
                } else {
                    System.out.print("<id , " + existingID + " > ");
                    file_2.write("<id , " + existingID + " > ");
                }
            }
        }
        l.close();
        file_2.close();
    }
    private static boolean isArithmeticOperation(String word) {//دالة لاختبار العمليات الحسابية والهخ وتقوم يتعامل معا مخراجات اتناء طباعه
        return word.equals("=") ||  word.equals("+") || word.equals("-") ||  word.equals("*") ||  word.equals("/") ||  word.equals("%") ||
                word.equals(">") ||  word.equals("<") || word.equals("?") ||  word.equals(":") ||  word.equals(";") ||  word.equals(",") ||
                word.equals(".") ||  word.equals("@") || word.equals("(") ||  word.equals(")") ||  word.equals("{") ||  word.equals("}") ;
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
}
