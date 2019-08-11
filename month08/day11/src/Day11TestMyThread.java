class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class Day11TestMyThread {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("线程一");      //创建线程对象
        MyThread mt2 = new MyThread("线程二");

        mt1.start();        //开启线程
        mt2.start();
    }
}
