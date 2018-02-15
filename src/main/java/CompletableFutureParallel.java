import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletableFutureを使った並列処理
 */
public class CompletableFutureParallel {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newWorkStealingPool();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int num = i;
            futures.add(CompletableFuture.runAsync(() -> System.out.println("task" + num), executor));
        }

        CompletableFuture<Void> cf = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[futures.size()]));

        cf.whenComplete((ret, ex) -> {
            if (ex == null) {
                System.out.println("OK!");

            } else {
                System.out.println("NG!");
            }
        });
    }
}
