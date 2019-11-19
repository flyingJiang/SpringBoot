package com.flying.threadTest;

public class Test003 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main : bigin ");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    System.out.println("sub : " + i);
                }

            }
        });
        t1.setDaemon(true);
        t1.start();
        for(int j=0; j<10; j++){
            System.out.println("main : " +j);
        }
        t1.join();
        System.out.println("main : end" );
    }
}
