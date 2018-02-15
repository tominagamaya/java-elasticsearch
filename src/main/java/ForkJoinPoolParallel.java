import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinPoolを使った並列処理
 */
public class ForkJoinPoolParallel {
    public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = forkJoinPool.submit(new Task(1, 100));
        long result = task.join();
        System.out.println(result);
    }
}


class Task extends RecursiveTask<Long> {
    private static final long serialVersionUID = 1L;

    private final int start;
    private final int end;

    Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int size = end - start;
        if (size <= 1000) {
            long sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }

        int split = start + size / 2;
        ForkJoinTask<Long> task1 = new Task(start, split).fork();
        ForkJoinTask<Long> task2 = new Task(split + 1, end).fork();
        return task1.join() + task2.join();
    }
}