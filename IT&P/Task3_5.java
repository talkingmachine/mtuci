import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Task3_5 {

  public static void main(String[] args) {
    // 1
    System.out.println(isStrangePair("ratio", "orator"));
    System.out.println(isStrangePair("sparkling", "groups"));
    System.out.println(isStrangePair("bush", "hubris"));
    System.out.println(isStrangePair("", ""));
    System.out.println("");

    // 2
    String[][] items = { { "Laptop", "100000" }, { "Phone", "50000" }, { "Headphones", "10000" } };
    int discount = 25;
    List<String[]> result = sale(items, discount);
    for (String[] item : result) {
      System.out.println(item[0] + ": " + item[1]);
    }
    System.out.println("");

    // 3
    System.out.println(sucsessShoot(0, 0, 5, 2, 2));
    System.out.println(sucsessShoot(-2, -3, 4, 5, -6));
    System.out.println("");

    // 4
    System.out.println(parityAnalysis(243));
    System.out.println(parityAnalysis(12));
    System.out.println(parityAnalysis(3));
    System.out.println("");

    // 5
    System.out.println(rps("rock", "paper"));
    System.out.println(rps("paper", "rock"));
    System.out.println(rps("paper", "scissors"));
    System.out.println(rps("scissors", "scissors"));
    System.out.println(rps("scissors", "paper"));
    System.out.println("");

    // 6
    System.out.println(bugger(39));
    System.out.println(bugger(999));
    System.out.println(bugger(4));
    System.out.println("");

    // 7
    Object[][] inventory = { { "Скакалка", 550, 8 }, { "Шлем", 3750, 4 }, { "Мяч", 2900, 10 } };
    System.out.println(mostExpensive(inventory));
    System.out.println("");

    // 8
    System.out.println(longestUnique("abcba"));
    System.out.println(longestUnique("bbb"));
    System.out.println("");

    // 9
    System.out.println(isPrefix("automation", "auto-"));
    System.out.println(isSuffix("arachnophobia", "-phobia"));
    System.out.println(isPrefix("retrospect", "sub-"));
    System.out.println(isSuffix("vocation", "-logy"));
    System.out.println("");

    // 10
    System.out.println(doesBrickFit(1, 1, 1, 1, 1));
    System.out.println(doesBrickFit(1, 2, 1, 1, 1));
    System.out.println(doesBrickFit(1, 2, 2, 1, 1));
  }

  public static boolean isStrangePair(String str1, String str2) {
    // 1
    return (
      (str1.length() > 0 &&
        str2.length() > 0 &&
        str1.charAt(0) == str2.charAt(str2.length() - 1) &&
        str1.charAt(str1.length() - 1) == str2.charAt(0)) ||
      (str1.isEmpty() && str2.isEmpty())
    );
  }

  public static List<String[]> sale(String[][] items, int discount) {
    // 2
    List<String[]> discountedItems = new ArrayList<>();

    for (String[] item : items) {
      String name = item[0];
      int price = Integer.parseInt(item[1]);
      double discountedPrice = price * (1 - discount / 100.0);
      int finalPrice = (int) Math.round(discountedPrice);
      if (finalPrice < 1) {
        finalPrice = 1;
      }
      discountedItems.add(new String[] { name, String.valueOf(finalPrice) });
    }

    return discountedItems;
  }

  public static boolean sucsessShoot(int x, int y, int r, int m, int n) {
    // 3
    int distanceSquared = (m - x) * (m - x) + (n - y) * (n - y);
    return distanceSquared <= r * r;
  }

  public static boolean parityAnalysis(int number) {
    // 4
    boolean isNumberEven = (number % 2 == 0);
    int sumOfDigits = 0;
    int temp = Math.abs(number);

    while (temp > 0) {
      sumOfDigits += temp % 10;
      temp /= 10;
    }
    boolean isSumEven = (sumOfDigits % 2 == 0);

    return isNumberEven == isSumEven;
  }

  public static String rps(String player1, String player2) {
    // 5
    player1 = player1.toLowerCase();
    player2 = player2.toLowerCase();

    if (player2.equals(player1)) {
      return "Tie";
    }

    switch (player1) {
      case "rock":
        return player2.equals("scissors") ? "Player 1 wins" : "Player 2 wins";
      case "scissors":
        return player2.equals("paper") ? "Player 1 wins" : "Player 2 wins";
      case "paper":
        return player2.equals("rock") ? "Player 1 wins" : "Player 2 wins";
      default:
        return "Incorrect input";
    }
  }

  public static int bugger(int number) {
    // 6
    if (number < 10) {
      return 0;
    }

    int count = 0;

    while (number >= 10) {
      int product = 1;
      while (number > 0) {
        product *= number % 10;
        number /= 10;
      }
      number = product;
      count++;
    }

    return count;
  }

  public static String mostExpensive(Object[][] items) {
    // 7
    String mostExpensiveItem = "";
    int maxTotalValue = 0;

    for (Object[] item : items) {
      String name = (String) item[0];
      int price = (int) item[1];
      int quantity = (int) item[2];

      int totalValue = price * quantity;

      if (totalValue > maxTotalValue) {
        maxTotalValue = totalValue;
        mostExpensiveItem = name;
      }
    }

    return "Наиб. общ. стоимость у предмета " + mostExpensiveItem + " - " + maxTotalValue;
  }

  public static String longestUnique(String str) {
    // 8
    int n = str.length();
    int maxLength = 0;
    int start = 0;
    String longestSubstr = "";

    HashSet<Character> charSet = new HashSet<>();

    for (int end = 0; end < n; end++) {
      while (charSet.contains(str.charAt(end))) {
        charSet.remove(str.charAt(start));
        start++;
      }
      charSet.add(str.charAt(end));

      if (end - start + 1 > maxLength) {
        maxLength = end - start + 1;
        longestSubstr = str.substring(start, end + 1);
      }
    }

    return longestSubstr;
  }

  public static boolean isPrefix(String word, String prefix) {
    // 9
    if (prefix.endsWith("-")) {
      prefix = prefix.substring(0, prefix.length() - 1);
    }
    return word.startsWith(prefix);
  }

  public static boolean isSuffix(String word, String suffix) {
    // 9
    if (suffix.startsWith("-")) {
      suffix = suffix.substring(1);
    }
    return word.endsWith(suffix);
  }

  public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
    // 10
    return (
      (a <= h && b <= w) ||
      (a <= w && b <= h) ||
      (a <= h && c <= w) ||
      (a <= w && c <= h) ||
      (b <= h && c <= w) ||
      (b <= w && c <= h) ||
      (c <= h && a <= w) ||
      (c <= w && a <= h)
    );
  }
}
