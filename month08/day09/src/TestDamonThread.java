class DamonThread implements Runnable {
    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName() + "--------is running.");
        }
    }
}

public class TestDamonThread {
    public static void main(String[] args) {
        System.out.println("main 线程是后台线么？" + Thread.currentThread().isDaemon());
        DamonThread dt = new DamonThread();                //创建一个 DamonThread 对象 dt
        Thread t = new Thread(dt, "后台线程");      //创建线程 t 共享 dt 资源
        System.out.println("t线程默认是后台线程么?" + t.isDaemon());      //判断是否为后台线程
        t.setDaemon(true);                                  //将线程 t 设置为后台线程
        t.start();                                          //开启线程
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
