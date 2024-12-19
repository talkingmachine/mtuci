import java.util.List;

class Warehouse {

  private final List<Integer> goods;
  private int currentIndex = 0;

  public Warehouse(List<Integer> goods) {
    this.goods = goods;
  }

  public synchronized Integer getNextGood(int totalWeight, int MAX_WEIGHT) {
    if (currentIndex < goods.size() && totalWeight + goods.get(currentIndex) <= MAX_WEIGHT) {
      return goods.get(currentIndex++);
    }
    return null;
  }

  public int getCurrentIndex() {
    return currentIndex;
  }

  public int getListSize() {
    return goods.size();
  }
}
