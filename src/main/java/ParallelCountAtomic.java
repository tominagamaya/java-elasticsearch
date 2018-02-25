import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 複数のスレッドから値を更新する
 * (Atomic変数を使った排他制御)
 */
public class ParallelCountAtomic {
    private static AtomicInteger a = new AtomicInteger();
    private static AtomicInteger b = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            for (int i = 0; i < 100; i++) {
                executor.execute(() -> {
                    increment();
                    System.out.println("a:" + a + ", b:" + b);
                });
            }
        } finally {
            executor.shutdown();
        }
    }

    static private void increment() {

        a.incrementAndGet();
        b.incrementAndGet();
    }
}
