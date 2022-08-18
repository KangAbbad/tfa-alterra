import java.util.Scanner;

public class Problem7 {
  public static void main(String[] args) {
    System.out.print("Input: ");
    Scanner input = new Scanner(System.in);
    int value = input.nextInt();

    System.out.println("Output:");

    for (int i = 1; i <= value; i++) {
      for(int j = i; j <= value - 1; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= 2 * i - 1; k++){
        System.out.print("*");
      }
      System.out.println("");
    }
  }
}
