import java.util.Scanner;

public class Problem8 {
  public static void main(String[] args) {
    System.out.print("Input: ");
    Scanner input = new Scanner(System.in);
    int value = input.nextInt();

    System.out.println("Output:");
    for (int i = 1; i <= value; i++) {
      for(int j = 1; j <= value; j++){
        System.out.print(i * j + "\t");
      }
      System.out.println("");
    }
  }
}
