package com.flying.day0041;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 共享对象
class Res {

    // 姓名
    public String name;
    // 性别
    public String sex;
    // 为true情况下 允许读，不能写
    // 为false情况下 允许写，不能读。
    public boolean flag = false;
    public Lock lock = new ReentrantLock();
    public Condition condition=lock.newCondition();
}

// 生产这线程
class IntThread extends Thread {
    public Res res;

    public IntThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0; // 1
        while (true) {
            try {
                res.lock.lock();// 上锁
                if(res.flag){
                    res.condition.await();
                }
                if (count == 0) {
                    res.name = "小红";
                    res.sex = "女";
                } else {
                    res.name = "小军";
                    res.sex = "男";
                }
                count = (count + 1) % 2;// 0 1 0 1 0 1
                res.flag=true;
                res.condition.signal();
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                res.lock.unlock();// 释放当前锁
            }

        }

    }

}

// 读取线程
class OutThread extends Thread {

    public Res res;

    public OutThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {

            try {
                res.lock.lock();
                if(!res.flag){
                    res.condition.await();
                }
                Thread.sleep(1000);
                System.out.println(res.name + "," + res.sex);
                res.flag = false;
                res.condition.signal();
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                res.lock.unlock();
            }
        }

    }
}

public class Test0002 {
    public synchronized static void main(String[] args) throws InterruptedException {

        Res res = new Res();
        IntThread intThread = new IntThread(res);
        OutThread outThread = new OutThread(res);
        intThread.start();
        outThread.start();
    }
}
