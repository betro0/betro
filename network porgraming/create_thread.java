public class create_thread extends Thread{
    public create_thread(String thename){
     super(thename);
    }
    public void run(){
        for ( int i = 0 ; i < 5 ; i++){
            System.out.println(this.getName()+"count" + i);}
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e ){
        }
        }
    }
class Thread_test {
    public static void main(String[] args) {
        create_thread t1 = new create_thread("thread 1  :");
        create_thread t2 = new create_thread("thread 2  :");
        create_thread t4 = new create_thread("thread 4  :");
        t1.start();
        t2.start();
        t4.start();
    }
}



