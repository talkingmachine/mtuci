public class Main {
	public static void main(String[] args) {
			Admin admin = new Admin("Евгений", 32, 24);
      admin.drinkCoffee(1);
			admin.talk();
			admin.eat();

			Developer developer = new Developer("Дмитрий", 23, 844);
      developer.drinkCoffee(2);
			developer.talk();
			developer.eat();

			Manager manager = new Manager("Александр", 44, 51);
      manager.drinkCoffee(1);
			manager.talk();
			manager.eat();

			System.out.println("Всего сотрудников в компании: " + Employee.getCount());
	}
}