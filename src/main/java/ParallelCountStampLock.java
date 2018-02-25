import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

/**
 * 複数のスレッドから値を更新する
 * (StampLockを使った排他制御)
 */
public class ParallelCountStampLock {
    private static int a = 0;
    private static int b = 0;
    private static final StampedLock sl = new StampedLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            for (int i = 0; i < 5; i++) {
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
        long stamp = sl.writeLock();

        try {
            Thread.sleep(100);
            a++;
            b++;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sl.unlockWrite(stamp);
        }
    }
}
