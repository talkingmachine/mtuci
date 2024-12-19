import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {
    int[][] matrix = new int[3][3];

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        matrix[i][j] = new java.util.Random().nextInt(90) + 10;
      }
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    int numberOfThreads = 2;

    System.out.println("Максимальный элемент массива: " + findMaxInMatrix(matrix, numberOfThreads));
  }

  public static long findMaxInMatrix(int[][] matrix, int numberOfThreads) {
    Maximum maximum = new Maximum();
    ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
    int partSize = (matrix.length + numberOfThreads - 1) / numberOfThreads;

    for (int i = 0; i < numberOfThreads; i++) {
      int start = i * partSize;
      int end = Math.min(start + partSize, matrix.length);
      Thread task = new ArrayMaxRunnable(matrix, start, end, maximum);
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

    return maximum.getMaximum();
  }
}
