import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 複数のスレッドから値を更新する
 * (synchronizedを使った排他制御)
 */
public class ParallelCountSynchronized {
    private static int a = 0;
    private static int b = 0;

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

    synchronized static private void increment() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a++;
        b++;
    }
}
