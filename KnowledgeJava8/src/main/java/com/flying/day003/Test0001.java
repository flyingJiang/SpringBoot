package com.flying.day003;


class ThreadDemo01 implements Runnable {
    // 同时多个窗口共享100
    private  volatile static int count = 100;// 存放方法区中
    private static Object oj = new Object();
    public boolean flag = true;

    public void run() {
        if (flag) {
            while (count > 0) {

//				synchronized (this.getClass()) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + ",出售" + (100 - count + 1) + "张票");
                    count--;
                }
            }
//			}

        } else {
            while (count > 0) {

                sale();
            }
        }
    }

    // public synchronized void sale() {
    // if (count > 0) {
    // System.out.println(Thread.currentThread().getName() + ",出售" + (100 -
    // count + 1) + "张票");
    // count--;
    // }
    // }
    public static  void sale() {

        try {
            Thread.sleep(10);
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + ",出售" + (100 - count + 1) + "张票");
            count--;
        }

    }
}

public class Test0001 {
    public static void main(String[] args) throws InterruptedException {

        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        Thread t1 = new Thread(threadDemo01, "窗口1");
        Thread t2 = new Thread(threadDemo01, "窗口2");
        t1.start();
        Thread.sleep(40);
        threadDemo01.flag = false;
        t2.start();
    }
}