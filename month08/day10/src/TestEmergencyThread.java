class EmergencyThread implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            Thread th = Thread.currentThread();
            String th_name = th.getName();
            System.out.println(th_name + "输入" + i);

            try{
                Thread.sleep(500);      //线程休眠500ms
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TestEmergencyThread {
    public static void main (String[] args) throws Exception{
        EmergencyThread et = new EmergencyThread();
        Thread thread = new Thread(et, "线程一");
        thread.start();         //开启线程

        for (int i = 0; i < 5; i++) {
            //获取当前线程，然后获取当前线程的名字，最后在打印
            System.out.println(Thread.currentThread().getName() + "输入" + i);

            if(i == 1) {
                thread.join();      //调用 join() 方法将 线程一 插队执行
            }
            Thread.sleep(500);      //线程休眠500ms
        }
    }
}
