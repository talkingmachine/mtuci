public class Developer extends Employee {

  public Developer(String name, int age, int cups) {
    super(name, age, cups);
  }

  @Override
  public void talk() {
    System.out.println(this.getName() + " говорит: почему не работает.. ");
  }

  @Override
  public void drinkCoffee(int cups) {
    super.drinkCoffee(cups * 2);
    System.out.println(this.getName() + " выпивает " + cups + " чашек кофе");
  }

  @Override
  void eat() {
    drinkCoffee(1);
  }
}
