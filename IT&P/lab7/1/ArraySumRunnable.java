public class ArraySumRunnable extends Thread {

  private int[] array;
  private int start;
  private int end;
  private Counter counter;

  public ArraySumRunnable(int[] array, int start, int end, Counter counter) {
    this.array = array;
    this.start = start;
    this.end = end;
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int i = start; i < end; i++) {
      counter.add(array[i]);
    }
  }
}
