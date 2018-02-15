import java.util.Arrays;
import java.util.List;

/**
 * parallelStreamを使った並列処理
 */
public class ParallelStream {
    public static void main(String[] args) throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.parallelStream()
                .map(x -> "task" + x)
                .forEach(System.out::println);
    }
}
