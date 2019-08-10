class SaleThread2 implements Runnable {
    private int tickets = 10;
    Object lock = new Object();             //定义任意一个对象，作为同步代码块的锁
    public void run() {
        while(true) {
            synchronized(lock) {
                try{
                    Thread.sleep(100);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }

                if(tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "---卖出的票号：" + tickets--);
                } else {
                    break;
                }
            }
        }
    }
}

public class TestSaleThread2 {
    public static void main(String[] args) {
        SaleThread2 st2 = new SaleThread2();
        new Thread(st2, "窗口一").start();
        new Thread(st2, "窗口二").start();
        new Thread(st2, "窗口三").start();
        new Thread(st2, "窗口四").start();
    }
}
