import java.util.*;

public class Exponentiation {
  public static void main(String[] args) {
    System.out.print("Input X: ");
    Scanner inputX = new Scanner(System.in);
    double x = inputX.nextDouble();

    System.out.print("Input N: ");
    Scanner inputN = new Scanner(System.in);
    double n = inputN.nextDouble();

    Map<String, Double> expMap = new HashMap<>();
    expMap.put("x", x);
    expMap.put("n", n);
    double exponent = Math.pow(expMap.get("x"), expMap.get("n"));
    int result = (int) exponent;

    System.out.println("Output: " + result);
  }
}
