public class super_use {
    int i;
    int c;
    public super_use(int a){

        i = a ;
    }
}
class b extends super_use {
    int i;

     b(int a, int b,int c){
            super(a);
            super.c = c;
            i = b;
    }
    public void show(){
        System.out.println("print i super :" + super.i+"\n"+super.c);
        System.out.println("print i sub :" + i);

    }
    public static void main(String[] args) {
        b sub = new b(1,2,8);
        sub.show();
    }
}