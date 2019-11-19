package com.flying.threadTest;

class ThreadDemo1 extends Thread{

    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("sub : " + i);
        }
    }
}
public class Test001 {
    public static void main(String[] args) {
        //继承Thread类
        System.out.println("main : bigin ");
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        threadDemo1.start();
        for(int i=0; i<10; i++){
            System.out.println("main : " + i);
        }
        System.out.println("main : end" );
        //实现runnable接口
        //使用匿名内部类
        //线程池
    }
}
