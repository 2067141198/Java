class TicketWindow implements Runnable {
    private int tickets = 100;
    public void run() {
        while(true) {
            if(tickets > 0) {
                Thread th = Thread.currentThread();     //获取当前线程
                String th_name = th.getName();          //获取当前线程的名字
                System.out.println(th_name + "正在发售第" + tickets-- + "张票");
            }
        }
    }
}

public class TestTicketWindow {
    public static void main(String[] args) {
        TicketWindow tw = new TicketWindow();        //创建 TicketWindow 的实例对象 tw
        new Thread(tw, "窗口1").start();      //创建线程对象并命名为窗口1，开启线程
        new Thread(tw, "窗口2").start();
        new Thread(tw, "窗口3").start();
        new Thread(tw, "窗口4").start();
    }
}
