import java.util.Scanner;

public class Problem4 {
  public static void main(String[] args) {
    System.out.print("Input: ");
    Scanner input = new Scanner(System.in);
    int value = input.nextInt();
    int primes = 0;
    for (int i = 2; i <= value; i++){
      if (value % i == 0){
        primes++;
      }
    }
    if (primes == 1) {
      System.out.println("Output: Bilangan Prima");
    } else {
      System.out.println("Output: Bukan Bilangan Prima");
    }
  }
}
