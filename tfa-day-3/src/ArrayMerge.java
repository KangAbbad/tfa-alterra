import java.util.*;

public class ArrayMerge {
  public static void main(String[] args) {
    System.out.print("Input Array 1: ");
    Scanner inputArray1 = new Scanner(System.in);
    String array1 = inputArray1.nextLine();

    System.out.print("Input Array 2: ");
    Scanner inputArray2 = new Scanner(System.in);
    String array2 = inputArray2.nextLine();

    List<String> splitArray1 = Arrays.asList(array1.split("\\s*,\\s*"));
    List<String> splitArray2 = Arrays.asList(array2.split("\\s*,\\s*"));

    Set<String> sortedArray = new LinkedHashSet();
    sortedArray.addAll(splitArray1);
    sortedArray.addAll(splitArray2);

    System.out.println("Output: " + sortedArray);
  }
}
