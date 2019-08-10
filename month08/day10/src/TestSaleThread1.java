class SaleThread implements Runnable {
    private int tickets = 10;
    public void run() {
        while(tickets > 0) {
            try{
                Thread.sleep(10);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "----卖出的票号" + tickets--);
        }
    }
}

public class TestSaleThread1 {
    public static void main(String[] args) {
        SaleThread saleThread = new SaleThread();
        new Thread(saleThread, "窗口一").start();
        new Thread(saleThread, "窗口二").start();
        new Thread(saleThread, "窗口三").start();
        new Thread(saleThread, "窗口四").start();
    }
}
