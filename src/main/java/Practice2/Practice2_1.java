package Practice2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by huchao on 2017/7/2.
 */
public class Practice2_1{
    static boolean flag = true;
    static  Object lock  = new Object();
    public static void main(String[] args) throws Exception
    {
        Thread waitThread = new Thread(new Wait(),"waitThread");
        waitThread.start();
        Thread notifyThread = new Thread(new Notify(),"notifyThread");
        TimeUnit.SECONDS.sleep(7);
        notifyThread.start();
    }
    static class Wait implements  Runnable{
        @Override
        public void run() {
            //加锁，拥有lock的monitor
            synchronized (lock){
                //当条件不满足时，继续wait，同时释放lock锁
                while (flag){
                    try{
                        System.out.println(Thread.currentThread()+" flag is true.wait@ "+
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //条件满足时，完成工作
                System.out.println(Thread.currentThread()+" flag is false.running@ "+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
    static class Notify implements  Runnable{
        @Override
        public void run() {
            synchronized (lock){
                try {
                    System.out.println(Thread.currentThread() + "hold lock.notify@ " +
                            new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    lock.notify();
                    flag = false;
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                        e.printStackTrace();
                }
            }
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread() + "hold lock again.sleep@ " +
                            new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
