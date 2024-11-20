public class Admin extends Employee {

  public Admin(String name, int age, int cups) {
    super(name, age, cups);
  }

  @Override
  public void talk() {
    System.out.println(getName() + " говорит: работать!!");
  }

  @Override
  void eat() {
    System.out.println(getName() + " ест ланч");
  }

  @Override
  public void drinkCoffee(int cups) {
    super.drinkCoffee(cups);
    System.out.println(getName() + " просыпается, выпив " + cups + " чашек кофе");
  }
}
