package ITIP.lab1;

public class Palindrome {
  public static String reverseString(String s) {
      StringBuilder reversed = new StringBuilder();
      // Перебираем символы строки с конца до начала
      for (int i = s.length() - 1; i >= 0; i--) {
          reversed.append(s.charAt(i)); // Добавляем каждый символ в новый StringBuilder
      }
      return reversed.toString(); // Преобразуем StringBuilder обратно в строку
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
