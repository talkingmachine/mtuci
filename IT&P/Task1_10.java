import java.util.HashMap;

class Task1_10 {
  public static void main(String[] args) {
    System.out.println(factorial(7));
  }

  public static double convert(int gallons) {
    return gallons * 3.785;
  }

  public static int fitCalc(int calories, int intensity) {
    return calories * intensity;
  }

  public static int containers(int box, int bag, int barrel) {
    HashMap<String, Integer> size = new HashMap<>();
    size.put("box", 20);
    size.put("bag", 50);
    size.put("barrel", 100);

    int res = box * size.get("box") + bag * size.get("bag") + barrel * size.get("barrel");

    return res;
  }

  public static String triangleType(int side1, int side2, int side3) {
    if (side1 + side2 > side3 && side2 + side3 > side1 && side3 + side1 > side2) {
      if (side1 == side2 && side2 == side3) {
        return "равносторонний";
      } else if (side1 == side2 || side2 == side3 || side3 == side1) {
        return "равнобедренный";
      } else {
        return "разносторонний";
      }
    } else {
      return "не является треугольником";
    }
  }

  public static int ternaryEvaluation(int a, int b) {
    return a > b ? a : b;
  }

  public static int howManyItems(double n, double w, double h) {
    double totalSquareMeters = n * 2;
    double blanketArea = w * h;
    // ?
    return (int) Math.floor(totalSquareMeters / blanketArea);
  }

  public static long factorial(int digit) {
    long res = 1;
    for (int i = digit; i > 1; i--) {
      res = res * i;
    }
    return res;
  }

  public static int ticketSaler(int n, int price) {
    return n * price;
  }

  public static int tables(int students, int tables) {
    return (tables * 2) >= students ? 0 : (int) Math.ceil((double) (students - tables * 2) / 2);
  }
}