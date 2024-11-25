import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SalesTracker {

  private Map<String, Integer> salesMap;

  public SalesTracker() {
    salesMap = new TreeMap<>();
  }

  public void addSale(String product) {
    salesMap.put(product, salesMap.getOrDefault(product, 0) + 1);
  }

  public void printSales() {
    System.out.println("Проданное:");
    for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }

  public int getTotalSales() {
    return salesMap.values().stream().mapToInt(Integer::intValue).sum();
  }

  public String getMostPopularProduct() {
    return salesMap
      .entrySet()
      .stream()
      .max(Map.Entry.comparingByValue())
      .map(Map.Entry::getKey)
      .orElse("Нет проданных продуктов");
  }

  public static void main(String[] args) {
    SalesTracker tracker = new SalesTracker();
    Scanner scanner = new Scanner(System.in);
    String command;

    System.out.println("Напишите 'exit' для завершения программы");

    while (true) {
      System.out.print("Введите название проданного продукта: ");
      command = scanner.nextLine();

      if (command.equalsIgnoreCase("exit")) {
        break;
      }

      tracker.addSale(command);
    }

    tracker.printSales();
    System.out.println("Всего продано: " + tracker.getTotalSales());
    System.out.println("Самый популярный продукт: " + tracker.getMostPopularProduct());

    scanner.close();
  }
}
