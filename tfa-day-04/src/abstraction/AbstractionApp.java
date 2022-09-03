package abstraction;

import java.util.Scanner;

public class AbstractionApp {
  public static void main(String[] args) {
    System.out.println("+++++++++++++++ CALCULATOR +++++++++++++++");
    System.out.println("1: Open Calculator");
    System.out.println("99: Exit");
    System.out.print("Masukkan pilihan Anda: ");
    Scanner inputChoice = new Scanner(System.in);
    int choiceValue = inputChoice.nextInt();
    for (int i = 0; i < 50; ++i) System.out.println();

    if (choiceValue == 1) {
      System.out.println();
      System.out.println("+++++++++++++++ CALCULATOR +++++++++++++++");
      System.out.print("Masukkan Value 1: ");
      Scanner input1 = new Scanner(System.in);
      int value1 = input1.nextInt();

      System.out.print("Masukkan Value 2: ");
      Scanner input2 = new Scanner(System.in);
      int value2 = input2.nextInt();

      for (int i = 0; i < 50; ++i) System.out.println();

      System.out.println("+++++++++++++++ CALCULATOR +++++++++++++++");
      System.out.println("Please Enter Calculation Operation:");
      System.out.println("1. Add Value");
      System.out.println("2. Sub Value");
      System.out.println("3. Multiply Value");
      System.out.println("4. Divide Value");
      System.out.println("+++++++++++++++ CALCULATOR +++++++++++++++");
      System.out.print("Pilihan Anda: ");
      Scanner input3 = new Scanner(System.in);
      int value3 = input3.nextInt();
      switch (value3) {
        case 1 -> {
          int addValue = value1 + value2;
          System.out.println("Hasil: " + addValue);
          System.out.println("++++++++++++++++++ EXIT ++++++++++++++++++");
        }
        case 2 -> {
          int subValue = value1 - value2;
          System.out.println("Hasil: " + subValue);
          System.out.println("++++++++++++++++++ EXIT ++++++++++++++++++");
        }
        case 3 -> {
          int multiplyValue = value1 * value2;
          System.out.println("Hasil: " + multiplyValue);
          System.out.println("++++++++++++++++++ EXIT ++++++++++++++++++");
        }
        case 4 -> {
          int divideValue = value1 / value2;
          System.out.println("Hasil: " + divideValue);
          System.out.println("++++++++++++++++++ EXIT ++++++++++++++++++");
        }
        default -> System.out.println("++++++++++++++++++ EXIT ++++++++++++++++++");
      }
    } else {
      System.out.println("++++++++++++++++++ EXIT ++++++++++++++++++");
    }
  }
}
