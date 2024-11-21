import java.util.HashMap;
import java.util.HashSet;

class Task3_5 {

  public static void main(String[] args) {
    System.out.println(rps("rock", "paper"));
    System.out.println(rps("paper", "rock"));
    System.out.println(rps("paper", "scissors"));
    System.out.println(rps("scissors", "scissors"));
    System.out.println(rps("scissors", "paper"));
    System.out.println("");

    System.out.println(bugger(39));
    System.out.println(bugger(999));
    System.out.println(bugger(4));
    System.out.println("");

    Object[][] inventory = { { "Скакалка", 550, 8 }, { "Шлем", 3750, 4 }, { "Мяч", 2900, 10 } };
    System.out.println(mostExpensive(inventory));
    System.out.println("");

    System.out.println(longestUnique("abcba"));
    System.out.println(longestUnique("bbb"));
    System.out.println("");

    System.out.println(isPrefix("automation", "auto-"));
    System.out.println(isSuffix("arachnophobia", "-phobia"));
    System.out.println(isPrefix("retrospect", "sub-"));
    System.out.println(isSuffix("vocation", "-logy"));
    System.out.println("");

    System.out.println(doesBrickFit(1, 1, 1, 1, 1));
    System.out.println(doesBrickFit(1, 2, 1, 1, 1));
    System.out.println(doesBrickFit(1, 2, 2, 1, 1));
  }

  public static String rps(String player1, String player2) {
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
    if (prefix.endsWith("-")) {
      prefix = prefix.substring(0, prefix.length() - 1);
    }
    return word.startsWith(prefix);
  }

  public static boolean isSuffix(String word, String suffix) {
    if (suffix.startsWith("-")) {
      suffix = suffix.substring(1);
    }
    return word.endsWith(suffix);
  }

  public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
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
