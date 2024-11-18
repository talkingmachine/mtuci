package ITIP.lab1;

public class Primes {
  public static boolean isPrime(int n) {
    if (n <= 1) {
        return false;
    }
    for (int i = 2; i < n; i++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
  }

  public static void main(String[] args) {
      System.out.println("Простые числа от 2 до 100:");
      for (int i = 2; i <= 100; i++) {
          if (isPrime(i)) {
              System.out.print(i + " ");
          }
      }
  }
} 
