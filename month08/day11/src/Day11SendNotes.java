class SendNotes implements Runnable {
    private int notes = 80;
    Object lock = new Object();         //创建任意对象作为锁对象
    public void run() {
        while(true) {
            synchronized(lock) {
                try{
                    Thread.sleep(500);      //让线程休眠500ms
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }

                if(notes > 0) {
                    System.out.println(Thread.currentThread().getName() + "发第" + notes-- + "份笔记");
                } else {
                    break;
                }
            }
        }
    }
}

public class Day11SendNotes {
    public static void main(String[] args) {
    SendNotes sn = new SendNotes();

    new Thread(sn,"教师A").start();           //创建线程并开启线程
    new Thread(sn,"教师B").start();
    new Thread(sn,"教师C").start();
}
}
