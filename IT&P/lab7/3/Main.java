import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) {
    List<Integer> goods = new ArrayList<>();
    goods.add(10);
    goods.add(20);
    goods.add(30);
    goods.add(40);
    goods.add(50);
    goods.add(60);
    goods.add(70);

    goods.add(15);
    goods.add(25);
    goods.add(35);
    goods.add(45);
    goods.add(55);
    goods.add(65);
    goods.add(75);

    Warehouse warehouse = new Warehouse(goods);
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    List<Worker> loaders = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      loaders.add(new Worker(warehouse));
    }

    for (Worker loader : loaders) {
      executorService.execute(loader);
    }

    executorService.shutdown();
    while (!executorService.isTerminated()) {
    }

    System.out.println(warehouse.getCurrentIndex() + " - текущий индекс из " + warehouse.getListSize());

    System.out.println("Все товары перенесены.");
  }
}
