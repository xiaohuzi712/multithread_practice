package Practice1;

/**
 * Created by huchao on 2017/7/2.
 */
public class ThreadTest2 {
        public static void main(String[] args) throws Exception{
            ThreadTest2 threadTest2 = new ThreadTest2();
            Thread thread = new Thread1("线程1");
//            threadTest2.firstMethod();
            thread.start();
        }
        public void firstMethod() throws Exception{
//            synchronized (this) {
                Thread.sleep(5000);
                System.out.println("线程睡眠");
//            }
        }
        public void secondMethod(){

        }
    }
        class Thread1 extends  Thread{
            public Thread1(String name){
                super(name);
            }
            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }
