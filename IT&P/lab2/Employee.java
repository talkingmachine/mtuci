public abstract class Employee {

  private String name;
  private int age;
  private int cupsOfCoffeeDrunk;

  public Employee(String name, int age, double cupsOfCoffeeDrunk) {
    this.name = name;
    this.age = age;
    this.cupsOfCoffeeDrunk = cupsOfCoffeeDrunk;
  }

  abstract void eat();

  abstract void talk();

  public void drinkCoffee(int cups) {
    this.cupsOfCoffeeDrunk += cups;
  }

  // GET & SET
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getDrunkCupsOfCoffee() {
    return this.cupsOfCoffeeDrunk;
  }

  public void setDrunkCupsOfCoffee(int cups) {
    this.cupsOfCoffeeDrunk = cups;
  }
}
