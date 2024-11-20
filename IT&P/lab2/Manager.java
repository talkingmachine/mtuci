public class Manager extends Employee {
  public Manager(String name, int age, int cups) {
    super(name, age, cups);
  }

  @Override
  public void talk() {
    System.out.println(getName() + " уважительно просит работать");
  }

  @Override
  void eat() {
    System.out.println(getName() + " ест я.доставку");
  }

  @Override
  public void drinkCoffee(int cups) {
    super.drinkCoffee(cups);
    System.out.println(getName() + " просыпается, выпив " + cups + " чашек латте");
  }
}
