import java.util.stream.IntStream;

/**
 * Streamを使った並列処理
 */
public class StreamParallel {
    public static void main(String[] args) throws Exception {
        IntStream.range(1, 10).boxed()
                .parallel()
                .map(x -> "task" + x)
                .forEach(System.out::println);
    }
}
