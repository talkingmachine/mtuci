class Task2 {
  public static void main(String[] args) {
    System.out.println(tables(5, 2));
    System.out.println(tables(31, 20));
    System.out.println(tables(123, 58));
  }

  public static int ticketSaler(int n, int price) {
    return n * price;
  }

  public static int tables(int students, int tables) {
    return (tables * 2) >= students ? 0 : (int) Math.ceil((double) (students - tables * 2) / 2);
  }
}