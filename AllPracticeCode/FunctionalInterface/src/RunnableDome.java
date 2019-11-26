public class RunnableDome {
    public static void main(String[] args) {
        //匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "启动了");
            }
        });

        //Lambda表达式
        startThread(() -> System.out.println(Thread.currentThread().getName() + "启动了"));
    }

    public static void startThread(Runnable r) {
        new Thread(r).start();
    }
}
