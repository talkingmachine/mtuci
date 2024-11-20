public class Palindrome {
  public static String reverseString(String s) {
      StringBuilder reversed = new StringBuilder();
      for (int i = s.length() - 1; i >= 0; i--) {
          reversed.append(s.charAt(i));
      }
      return reversed.toString();
  }

  public static boolean isPalindrome(String s) {
    String reversedString = reverseString(s);
    return s.equals(reversedString);
}

  public static void main(String[] args) {
    for (int i = 0; i < args.length; i++) {
      String s = args[i];
      System.out.print(isPalindrome(s) + " ");
    }
  }
}
