import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 複数のスレッドから値を更新する
 * (排他制御なし)
 */
public class ParallelCount2 {
    private static int a = 0;
    private static int b = 0;

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

        a++;
        b++;
    }
}
