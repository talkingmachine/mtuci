class Product {

  private String name;
  private double price;
  private int quantity;
  private String description;

  public Product(String name, double price, int quantity, String description) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.description = description;
  }

  // GET && SET

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getDesciption() {
    return description;
  }

  public void setDesciption(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "{ " + "name= '" + name + '\'' + ", price= " + price + ", quantity= " + quantity + ", description= " + description + " }";
  }
}
