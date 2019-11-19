package com.flying.day004;

// 共享对象
class Res {

    // 姓名
    public String name;
    // 性别
    public String sex;
    // 为true情况下 允许读，不能写
    // 为false情况下 允许写，不能读。
    public boolean flag = false;

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
            synchronized (res) {
                if (res.flag) {
                    try {
                        res.wait();// 釋放当前锁对象
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
                if (count == 0) {
                    res.name = "小红";
                    res.sex = "女";
                } else {
                    res.name = "小军";
                    res.sex = "男";
                }
                count = (count + 1) % 2;// 0 1 0 1 0 1
                res.flag = true;// 标记当前线程为等待
                res.notify();// 唤醒被等待的线程
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
            synchronized (res) {
                try {
                    if (!res.flag) {
                        res.wait();
                    }
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }

                System.out.println(res.name + "," + res.sex);
                res.flag = false;
                res.notify();
            }

        }
    }

}

public class Test0001 {
    public synchronized static void main(String[] args) throws InterruptedException {

        Res res = new Res();
        IntThread intThread = new IntThread(res);
        OutThread outThread = new OutThread(res);
        intThread.start();
        outThread.start();
    }
}
