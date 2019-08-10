class MaxPriority implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread th = Thread.currentThread();
            String th_name = th.getName();
            System.out.println(th_name + "正在输出" + i);
        }
    }
}

class MinPriority implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread th = Thread.currentThread();
            String th_name = th.getName();
            System.out.println(th_name + "正在输出" + i);
        }
    }
}

public class TestThreadPriority {
    public static void main(String[] args) {
        MaxPriority maxPriority = new MaxPriority();
        MinPriority minPriority = new MinPriority();
        Thread maxp = new Thread(maxPriority,"优先级高的线程");    //创建线程的实例对象
        Thread minp = new Thread(minPriority,"优先级低的线程");
        maxp.setPriority(Thread.MAX_PRIORITY);          //设置线程的优先级
        minp.setPriority(1);                            //设置线程的优先级

        maxp.start();           //启动线程
        minp.start();           //启动线程
    }
}
