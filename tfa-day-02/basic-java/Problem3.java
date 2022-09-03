import java.util.Scanner;

public class Problem3 {
  public static void main(String[] args) {
    System.out.print("Input: ");
    Scanner input = new Scanner(System.in);
    int value = input.nextInt();
    System.out.println("Output:");
    for (int i = 1; i <= value; i++) {
      if (value % i == 0) {
        System.out.println(i);
      }
    }
  }
}
