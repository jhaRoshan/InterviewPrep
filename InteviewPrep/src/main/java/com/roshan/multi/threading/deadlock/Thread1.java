package com.roshan.multi.threading.deadlock;

public class Thread1 implements Runnable{

   private Object monitor1;
   private Object monitor2;


    public Thread1(Object monitor1 , Object monitor2){
       this.monitor1 = monitor1;
       this.monitor2 = monitor2;
   }

    @Override
    public void run() {
        synchronized (monitor1){
            System.out.println("Taking lock on monitor:"+monitor1);
            try {
                Thread.sleep(5000);
                synchronized (monitor2){
                    System.out.println("Taking lock on monitor2:"+monitor2);
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public static  void main(String[] args){
        Object m1 = new Object();
        Object m2 = new Object();

        Thread1 th1 = new Thread1(m1,m2);
        Thread1 th2 = new Thread1(m2,m1);

        new Thread(th1).start();
        new Thread(th2).start();

    }
}
