public class main_thread {
    public static void main(String[] args) throws InterruptedException {

      Thread t = Thread.currentThread();
      System.out.println("current thread : " + t);
        //chang the name of the thread
        t.setName("my_thread");
        System.out.println("After name chande : " + t);
        try {
            int i;
            for (i = 5; i > 0; i--) ;
            System.out.println(t);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
            System.out.println("main thread intrpead ");
        }
        try {
t.start();
        }catch (IllegalThreadStateException E) {
            t.setPriority(Thread.MAX_PRIORITY);
            System.out.println("priority : " + t.getPriority() + "\nalive or no : " + t.isAlive()+"\n name:"+t.getName());
        }
}}
