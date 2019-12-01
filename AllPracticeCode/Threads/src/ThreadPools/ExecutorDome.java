package ThreadPools;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorDome {
    private final static Executor EXE = Executors.newSingleThreadExecutor();
//    private final static Executor EXE = Executors.newFixedThreadPool(5);
//    private final static Executor EXE = Executors.newCachedThreadPool();
//    private final static Executor EXE = Executors.newScheduledThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            final int j = i;
            EXE.execute(() -> {
                System.out.println((char) ('A' + j));
            });
        }
    }
}
