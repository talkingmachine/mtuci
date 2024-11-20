public abstract class Employee {

  private String name;
  private int age;
  private int cupsOfCoffeeDrunk;

  private static int count = 0;

  public Employee(String name, int age, int cupsOfCoffeeDrunk) {
    this.name = name;
    this.age = age;
    this.cupsOfCoffeeDrunk = cupsOfCoffeeDrunk;
    count++;
  }

  abstract void eat();

  abstract void talk();

  public void drinkCoffee(int cups) {
    this.cupsOfCoffeeDrunk += cups;
  }

  // GET & SET

  public static int getCount() {
    return count;
  }

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
