public class Maximum {

  private int maximum = 0;

  public synchronized void checkIsMax(int number) {
    if (number > maximum) {
      maximum = number;
    };
  }

  public int getMaximum() {
    return maximum;
  }
}
