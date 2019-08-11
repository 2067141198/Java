class PrintThread implements Runnable {
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "第" + i + "次打印：new");
        }
    }
}

public class Day11TsetPrintThread {
    public static void main(String[] args) {
        PrintThread printThread = new PrintThread();
        Thread thread = new Thread(printThread,"线程一");
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("主线程第" + i + "次打印：main");
        }
    }
}
