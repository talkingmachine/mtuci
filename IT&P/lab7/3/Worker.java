import java.util.ArrayList;
import java.util.List;

class Worker implements Runnable {

  private static final int MAX_WEIGHT = 150;
  private final Warehouse warehouse;
  private final List<Integer> loadedGoods = new ArrayList<>();
  private int totalWeight = 0;

  public Worker(Warehouse warehouse) {
    this.warehouse = warehouse;
  }

  @Override
  public void run() {
    while (true) {
      loadGoods();
      if (totalWeight > 0) {
        unloadGoods();
      } else {
        break;
      }
    }
  }

  private synchronized void loadGoods() {
    while (totalWeight < MAX_WEIGHT) {
      Integer good = warehouse.getNextGood(totalWeight, MAX_WEIGHT);
      if (good == null) {
        break;
      }

      totalWeight += good;
      System.out.println(Thread.currentThread().getName() + " загрузил товар весом: " + good + " кг");
    }
  }

  private void unloadGoods() {
    System.out.println(Thread.currentThread().getName() + " завершил загрузку. Общий вес: " + totalWeight + " кг");
    System.out.println(Thread.currentThread().getName() + " отправляется на другой склад.");
    totalWeight = 0;
  }
}
