import java.util.Scanner;

public class Problem2 {
  public static void main(String[] args) {
    System.out.print("Input: ");
    Scanner input = new Scanner(System.in);
    String str = input.next();
    String strTrim = str.replace(" ", "");

    int xCount = 0;
    int oCount = 0;

    for (int i = 0; i < strTrim.length(); i++) {
      char strChar = strTrim.toLowerCase().charAt(i);
      if (strChar == 'x') {
        xCount += 1;
      } else if (strChar == 'o') {
        oCount += 1;
      }
    }

    if (xCount == oCount) {
      System.out.println("Output: " + true);
    } else {
      System.out.println("Output: " + false);
    }
  }
}
