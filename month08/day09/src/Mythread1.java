class MyThread extends Thread {
    public void run() {
        while(true) {                           //通过死循环语句打印输出
            System.out.println("MyThread 类的 run() 方法在运行");
        }
    }
}

public class Mythread1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();     //创建线程MyThread 的线程对象
        myThread.start();                       //开启线程
        while(true) {                           //通过死循环语句打印输出
            System.out.println("main() 方法正在运行");
        }
    }
}
