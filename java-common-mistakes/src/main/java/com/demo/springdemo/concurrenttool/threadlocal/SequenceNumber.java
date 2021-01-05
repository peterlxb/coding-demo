package com.demo.springdemo.concurrenttool.threadlocal;

public class SequenceNumber {

    // 1. 通过匿名内部类覆盖 ThreadLocal 的 initialValue() 方法
    public static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    // 2. 获取下一个序列值
    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    private static class TestClient extends Thread {
        private SequenceNumber sn;

        public TestClient(SequenceNumber sn) {
            this.sn = sn;
        }

        public void run () {
            // 每个线程打出三个序列值
            for (int i = 0 ;i < 3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName() + 
                                "] sn[" + sn.getNextNum() + "]");
            }
        }
    }

    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();

        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);

        t1.start();
        t2.start();
        t3.start();
    }
}
