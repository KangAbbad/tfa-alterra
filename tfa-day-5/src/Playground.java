import java.util.HashMap;
import java.util.Map;

public class Playground {
  public static void main(String[] args) {
    System.out.println(sumOfDigit(12345));
    System.out.println(factorial(5));
    System.out.println(fibonacciRecursive(9));
  }

  static int sumOfDigit(int n) {
    if (n < 10) return n;
    int lastDigit = n % 10;
    int smallerSubProblem = n / 10;
    return lastDigit + sumOfDigit(smallerSubProblem);
  }

  static int factorial(int n) {
    if (n == 1) {
      return 1;
    } else {
      return n * factorial(n - 1);
    }
  }

  static Map<Long, Long> fibonacciMap = new HashMap<>();

  static long fibonacciRecursive(long n) {
    if (n <= 1) return n;
    if (fibonacciMap.containsKey(n)) return n;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
  }
}
