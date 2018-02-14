/**
 * 並列処理
 */
public class Parallel {

    public static void main(String[] args) {
        ParallelThreadA parallelA = new ParallelThreadA();
        ParallelThreadB parallelB = new ParallelThreadB();
        parallelA.start();
        parallelB.start();
    }
}

class ParallelThreadA extends Thread {
    public void run() {

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("スレッドA:" + (i + 1) + "番目");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ParallelThreadB extends Thread {
    public void run() {

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
                System.out.println("スレッドB:" + (i + 1) + "番目");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
