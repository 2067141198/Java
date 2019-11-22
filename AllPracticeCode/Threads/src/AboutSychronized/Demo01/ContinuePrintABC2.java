package AboutSychronized.Demo01;



class MyThread extends Thread{
    private Object lock;
    private int printCount;
    private String showChar;
    private int showCharPosition;
    private volatile static int addNum = 1;
    public MyThread(Object lock, String showChar, int showCharPosition) {
        this.lock = lock;
        this.showChar = showChar;
        this.showCharPosition = showCharPosition;
    }
    @Override
    public void run() {
        try {
            synchronized(lock) {
                while(true) {
                    if(addNum % 3 == showCharPosition) {
                        System.out.println(Thread.currentThread().getName() + "运行结果时打印：" + showChar + "第"
                            + (printCount + 1) + "打印");
                        lock.notifyAll();
                        addNum++;
                        printCount++;
                        if(printCount == 10) {
                            break;
                        }
                    } else {
                        lock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ContinuePrintABC2 {
    public static void main(String[] args) {
        Object obj = new Object();
        Thread thread1 = new MyThread(obj, "A", 1);
        Thread thread2 = new MyThread(obj, "B", 2);
        Thread thread3 = new MyThread(obj, "C", 0);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
