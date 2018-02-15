import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executor#newWorkStealingPool()
 * を使った並列処理
 */
public class ExecutorStealingParallel {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newWorkStealingPool();

        try {
            executor.execute(() -> System.out.println("Stealing:" + Thread.currentThread().getName()));
            executor.execute(() -> System.out.println("Stealing:" + Thread.currentThread().getName()));
            executor.execute(() -> System.out.println("Stealing:" + Thread.currentThread().getName()));
            executor.execute(() -> System.out.println("Stealing:" + Thread.currentThread().getName()));
            executor.execute(() -> System.out.println("Stealing:" + Thread.currentThread().getName()));
            Thread.sleep(500);

        } finally {
            executor.shutdown();
        }
    }
}
