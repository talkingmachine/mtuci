public class Counter {

  private int count;

  public synchronized void add(int number) {
    count += number;
  }

  public int getCount() {
    return count;
  }
}
