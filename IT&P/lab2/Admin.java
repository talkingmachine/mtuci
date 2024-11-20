package lab2;

public class Admin extends Employee {

  public Admin(String name, int age, double cups) {
    super(name, age, cups);
  }

  @Override
  public void talk() {
    System.out.println(getName() + " says: no one is working!");
  }

  @Override
  void eat() {
    System.out.println(getName() + " is eating lunch");
  }

  @Override
  void drinkCoffee(int cups) {
    System.out.println(getName() + " wakes up");
  }
}
