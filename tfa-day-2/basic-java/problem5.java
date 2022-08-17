import java.util.Scanner;

public class problem5 {
  public static void main(String[] args) {
    System.out.print("Input: ");
    Scanner input = new Scanner(System.in);
    String str = input.next();
    String reverseStr = "";
    int strLength = str.length();

    for (int i = strLength - 1; i >= 0; i--) {
      reverseStr = reverseStr + str.charAt(i);
    }

    if (str.equals(reverseStr)) {
      System.out.println("Output: Palindrome");
    } else {
      System.out.println("Output: Bukan Palindrome");
    }
  }
}
