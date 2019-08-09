class MyThread02 implements Runnable {
    public void run() {
        while (true) {
            System.out.println("MyThread 类的 run() 方法在运行");
        }
    }
}

public class MyThread2 {
    public static void main(String[] args) {
        MyThread02 myThread02 = new MyThread02();
        Thread thread = new Thread(myThread02);
        thread.start();
        while (true) {
            System.out.println("main() 方法在运行");
        }
    }
}
