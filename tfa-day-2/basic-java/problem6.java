import java.util.Scanner;

public class problem6 {
  public static void main(String[] args) {
    System.out.print("Input X: ");
    Scanner inputX = new Scanner(System.in);
    double x = inputX.nextDouble();
    System.out.print("Input N: ");
    Scanner inputN = new Scanner(System.in);
    double n = inputN.nextDouble();
    double exponent = Math.pow(x, n);
    int result = (int) exponent;
    System.out.println("Output: " + result);
  }
}
