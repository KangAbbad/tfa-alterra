import java.util.HashSet;
import java.util.Scanner;

public class Primes {
  public static void main(String[] args) {
    System.out.print("Input: ");
    Scanner input = new Scanner(System.in);
    int value = input.nextInt();

    HashSet<Integer> divisor = new HashSet<>();
    for (int i = 1; i <= value; i++) {
      if (value % i == 0) {
        divisor.add(i);
      }
    }

    // System.out.println("divisor: " + divisor);

    if (divisor.size() == 2) {
      System.out.println("Output: Bilangan Prima");
    } else {
      System.out.println("Output: Bukan Bilangan Prima");
    }
  }
}
