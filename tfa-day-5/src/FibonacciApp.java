import java.util.Scanner;

public class FibonacciApp {
  public static void main(String[] args) {
    System.out.print("Input: ");
    Scanner input = new Scanner(System.in);
    int value = input.nextInt();

    System.out.println("Output (top-down)  : " + fibonacciTopDown(value));
    System.out.println("Output (bottom-up) : " + fibonacciBottomUp(value));
  }

  static int fibonacciTopDown(int n) {
    if (n <= 1) return n;

    return fibonacciTopDown(n - 1) + fibonacciTopDown(n - 2);
  }

  static int fibonacciBottomUp(int n) {
    if (n <= 1) return n;

    int fibA = 0;
    int fibB = 1;

    for (int i = 2; i <= n; i++) {
      int tempCalc = fibA + fibB;
      fibA = fibB;
      fibB = tempCalc;
    }

    return fibB;
  }
}
