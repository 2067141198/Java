package AboutSychronized.Demo01;

public class ContinuePrintABC {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("A");
        }, "线程A");
        Thread thread2 = new Thread(() -> {
            System.out.println("B");
        }, "线程B");
        Thread thread3 = new Thread(() -> {
            System.out.println("C");
        }, "线程C");

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
    }
}
