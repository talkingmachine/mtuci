import java.util.HashMap;

public class EMarket {

  private HashMap<String, Product> products;

  public EMarket() {
    products = new HashMap<>();
  }

  public void addProduct(String articule, Product product) {
    products.put(articule, product);
    System.out.println("Продукт добавлен " + product);
  }

  public Product findProduct(String articule) {
    if (products.containsKey(articule)) {
      return products.get(articule);
    } else {
      System.out.println("Продукт по артикулу " + articule + " не найден");
      return null;
    }
  }

  public Product removeProduct(String articule) {
    if (products.containsKey(articule)) {
      Product removedProduct = products.remove(articule);
      System.out.println("Продукт удален " + removedProduct);
      return removedProduct;
    } else {
      System.out.println("Продукт по артикулу " + articule + " не найден");
      return null;
    }
  }

  public void displayAllProducts() {
    if (products.isEmpty()) {
      System.out.println("Продуктов нет");
    } else {
      for (String articule : products.keySet()) {
        System.out.println("Артикул " + articule + ", " + products.get(articule));
      }
    }
  }

  public static void main(String[] args) {
    EMarket eMarket = new EMarket();

    Product product1 = new Product("product1", 1.99, 1000, "Product_1 description");
    Product product2 = new Product("product2", 0.75, 978, "Product_2 description");
    Product product3 = new Product("product3", 1984, 2, "Product_3 description");

    eMarket.addProduct("123", product1);
    eMarket.addProduct("124", product2);
    eMarket.addProduct("125", product3);

    System.out.println("Продукт с артикулом " + "123 найден: " + eMarket.findProduct("123"));

    eMarket.removeProduct("129");

    eMarket.removeProduct("124");

    eMarket.displayAllProducts();
  }
}
