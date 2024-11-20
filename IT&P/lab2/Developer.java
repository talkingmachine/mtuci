package lab2;

public class Developer {

  public Developer(String name, int age, double cups) {
    super(name, age, cups);
  }

  @Override
  public void talk() {
    System.out.println(getName() + " says: nothing's working. f/ck ");
  }

  @Override
  void eat() {
    System.out.println(getName() + " is eating lunch");
  }

  @Override
  void drinkCoffee(int cups) {
    super.drinkCoffee(cups * 2)
    System.out.println(getName() + " wakes up");
  }
}
//
