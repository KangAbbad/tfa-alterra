import java.util.*;

public class ShowUpOnce {
  public static void main(String[] args) {
    System.out.print("Input: ");
    Scanner input = new Scanner(System.in);
    String value = input.nextLine();

    List<String> findCharArray = new ArrayList<>();

    for (char i : value.toCharArray()) {
      if (value.indexOf(i) == value.lastIndexOf(i)) {
        findCharArray.add(String.valueOf(i));
      }
    }

    System.out.println("Output: " + findCharArray);
  }
}
