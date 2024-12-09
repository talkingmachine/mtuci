public class ArrayMaxRunnable extends Thread {

  private int[][] matrix;
  private int start;
  private int end;
  private Maximum maximum;

  public ArrayMaxRunnable(int[][] matrix, int start, int end, Maximum maximum) {
    this.matrix = matrix;
    this.start = start;
    this.end = end;
    this.maximum = maximum;
  }

  @Override
  public void run() {
    for (int i = start; i < end; i++) {
      for (int j = 0; j < matrix[i].length; j++)
      maximum.checkIsMax(matrix[i][j]);
    }
  }
}
