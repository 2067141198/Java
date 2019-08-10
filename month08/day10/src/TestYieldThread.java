class YieldThread extends Thread {
    public YieldThread(String name) {
        super(name);        //调用父类的构造方法
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            Thread th = Thread.currentThread();
            String th_name = th.getName();
            System.out.println(th_name + "---" + i);

            if(i == 2) {
                System.out.println("线程让步：");
                Thread.yield();     //线程进行到此进行让步
            }
        }
    }
}

public class TestYieldThread {
    public static void main(String[] args) {
        Thread t1 = new YieldThread("线程A");     //创建线程
        Thread t2 = new YieldThread("线程B");
        t1.start();     //启动线程
        t2.start();
    }
}
