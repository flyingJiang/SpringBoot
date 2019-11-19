package com.flying.threadTest;

class ThreadDemo2 implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println("sub : " + i);
        }

    }
}
public class Test002 {
    public static void main(String[] args) {
        System.out.println("main : bigin ");
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        Thread thread = new Thread(threadDemo2);
        thread.start();
        for(int i=0; i<10; i++){
            System.out.println("sub : " + i);
        }
        System.out.println("main : end" );

    }
}
