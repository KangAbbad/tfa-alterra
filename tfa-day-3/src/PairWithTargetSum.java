import java.util.*;

public class PairWithTargetSum {
  public static void main(String[] args) {
    System.out.print("Input Numbers: ");
    Scanner inputArray1 = new Scanner(System.in);
    String array = inputArray1.nextLine();

    System.out.print("Input Target: ");
    Scanner inputTarget = new Scanner(System.in);
    int target = inputTarget.nextInt();

    List<String> numbers = Arrays.asList(array.split("\\s*,\\s*"));
    List<Integer> indexes = new ArrayList<>();

    for (int i = 0; i < numbers.size(); i++) {
      int numI = Integer.parseInt(numbers.get(i));
      for (int j = 0; j < numbers.size(); j++) {
        int numJ = Integer.parseInt(numbers.get(j));
        if (numI != numJ && numI + numJ == target) {
          indexes.add(i);
        }
      }
    }

    System.out.println("Output: " + indexes);
  }
}
