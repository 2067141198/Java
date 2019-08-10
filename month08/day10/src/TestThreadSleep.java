class SleepThread implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(i == 3) {
                try{
                    Thread.sleep(2000);     //当前线程休眠2000ms
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("线程一正在输出" + i);

            try{
                Thread.sleep(500);          //当前线程休眠500ms
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TestThreadSleep {
    public static void main(String[] args) throws Exception {
            SleepThread st = new SleepThread();
            Thread thread = new Thread(st);
            thread.start();
        for (int i = 0; i < 10; i++) {
            if(i == 5) {
                Thread.sleep(2000);     //当前线程休眠2000ms
            }

            System.out.println("主线程正在输出" + i);
            Thread.sleep(500);          //当前线程休眠500ms
        }
    }
}
