package com.flying.day004;

class ReorderExample {
    volatile int a = 0;
    volatile boolean flag = false;

    // 写入线程
    public void writer() {
        flag = true; // 2
        a = 1; // 1

    }
    // 1.1行代码和2行代码没有任何依赖关系
    // 读取的线程
    public void reader() {
        if (flag) { // 3
            int i = a * a; // 4  0

        }
    }
}
