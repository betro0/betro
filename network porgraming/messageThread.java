           public class messageThread implements Runnable {
             private Thread theThread;
             // Thread theThread = new Thread();
             public messageThread(String theName ) {

                 theThread =new Thread(this);
            }
            public void go() {
                theThread.start();
            }
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(theThread.getName() + "count = " + i);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {  }  }  }  }
         class mult_of_thread {
            public static void main(String[] args) {
                messageThread t = new messageThread("thread1");
                messageThread t1 = new messageThread("thread2");
                t.go();
                t1.go();
            }  }

