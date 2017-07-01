package Practice1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by huchao on 2017/7/1.
 */
public class ThreadTest {

    static {
        System.out.println("我是static模块");
    }

    public static void main(String[] args) {
        Thread t1 = new Mythread1();
        Thread t2 = new Thread(new Myrunnable());
        Callable callable = new Mycallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        Thread t3 = new Thread(futureTask);
        t1.start();//处于就绪态，真正的运行态，取决于CPU调度
        t2.start();
        t3.start();
        try{
             int sum = futureTask.get();
            System.out.println("sum = "+sum);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
    //线程的创建方法1:继承Thread类，重写run方法，实现线程的创建
    class Mythread1 extends  Thread{
        int i;
        @Override
        //线程执行体
        public void run() {
            for ( i=0 ; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-Mythread1-"+i);
            }
        }
    }
    //线程的创建方法2:实现Runnable接口，重写run方法，以Myrunnable实例作为Thread的target
  class Myrunnable implements Runnable{
        int j;
        @Override
        public void run() {
            for (j = 0; j <10 ; j++) {
                System.out.println(Thread.currentThread().getName()+"-Myrunnable-"+j);
            }
        }
    }
   /*线程创建的方法3:实现Callable接口，重写call方法，将Mycallable实例对象作为FutureTask的target,同时
    Thread包装FutureTask对象。
    */
  class Mycallable implements Callable<Integer>{
      private  int i=0;
      @Override
      public Integer call(){
         int sum = 0;
          for (; i <10 ; i++) {
              System.out.println(Thread.currentThread().getName()+"-Mycallable-"+i);
              sum+=i;
          }
          return sum;
      }
  }
