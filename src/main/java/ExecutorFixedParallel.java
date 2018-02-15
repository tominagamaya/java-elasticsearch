import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executor#newFixedThreadPool()
 * を使った並列処理
 */
public class ExecutorFixedParallel {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            executor.execute(() -> System.out.println("Fixed:" + Thread.currentThread().getId()));
            executor.execute(() -> System.out.println("Fixed:" + Thread.currentThread().getId()));
            executor.execute(() -> System.out.println("Fixed:" + Thread.currentThread().getId()));
            executor.execute(() -> System.out.println("Fixed:" + Thread.currentThread().getId()));
            executor.execute(() -> System.out.println("Fixed:" + Thread.currentThread().getId()));

        } finally {
            executor.shutdown();
        }
    }
}
