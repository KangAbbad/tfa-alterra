import java.util.Scanner;

public class Problem1 {
  public static void main(String[] args) {
    System.out.print("Input: ");
    Scanner input = new Scanner(System.in);
    String str = input.next();
    String strTrim = str.replace(" ", "");

    int vowelCount = 0;
    int consonantCount = 0;

    for (int i = 0; i < strTrim.length(); i++) {
      char strChar = strTrim.toLowerCase().charAt(i);
      if (strChar == 'a' || strChar == 'i' || strChar == 'u' || strChar == 'e' || strChar == 'o') {
        vowelCount += 1;
      } else {
        consonantCount += 1;
      }
    }

    System.out.println("Jumlah Vokal: " + vowelCount);
    System.out.println("Jumlah Konsonan: " + consonantCount);
    System.out.println("Total Karakter: " + strTrim.length());
  }
}
