import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {
    int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
    int numberOfThreads = 2;

    System.out.println("Сумма элементов массива: " + calculateArraySum(array, numberOfThreads));
  }

  public static long calculateArraySum(int[] array, int numberOfThreads) {
    Counter counter = new Counter();
    ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
    int partSize = (array.length + numberOfThreads - 1) / numberOfThreads;

    for (int i = 0; i < numberOfThreads; i++) {
      int start = i * partSize;
      int end = Math.min(start + partSize, array.length);
      Thread task = new ArraySumRunnable(array, start, end, counter);
      executor.execute(task);
    }

    executor.shutdown();

    try {
      boolean result = executor.awaitTermination(10, TimeUnit.SECONDS);
      if (!result) {
        executor.shutdownNow();
      }
    } catch (InterruptedException e) {
      executor.shutdownNow();
    }

    return counter.getCount();
  }
}
