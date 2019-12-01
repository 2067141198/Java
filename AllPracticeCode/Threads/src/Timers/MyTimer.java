package Timers;

public class MyTimer {
    public static void main(String[] args) {
        new MyTimer().schedule(() -> System.out.println("运行了"), 0, 1000);
    }

    public static void schedule(Runnable task, long delay, long period) {
        try {
            long next = System.currentTimeMillis() + delay;
            while (true) {
                long cur = System.currentTimeMillis();
                if (cur < next)
                    Thread.sleep(next - cur);
                task.run();

                if (period > 0)
                    next += period;
                else
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
