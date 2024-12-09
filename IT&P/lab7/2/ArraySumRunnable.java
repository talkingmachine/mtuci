public class ArraySumRunnable extends Thread {

  private int[] array;
  private int start;
  private int end;
  private Maximum maximum;

  public ArraySumRunnable(int[][] array, int start, int end, Maximum maximum) {
    this.array = array;
    this.start = start;
    this.end = end;
    this.maximum = maximum;
  }

  @Override
  public void run() {
    for (int i = start; i < end; i++) {
      counter.checkIsMax(array[i]);
    }
  }
}
