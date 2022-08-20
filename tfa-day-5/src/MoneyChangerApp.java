import java.util.*;

public class MoneyChangerApp {
  public static void main(String[] args) {
    System.out.print("Input: ");
    Scanner input = new Scanner(System.in);
    int value = input.nextInt();
    MoneyChangerApp.generateMoney(value);
  }

  static void generateMoney(int n) {
    List<Integer> moneyUnitList = Arrays.asList(1, 10, 20 ,50, 100, 200, 500, 1000, 2000, 5000, 10000);
    Collections.sort(moneyUnitList);
    Collections.reverse(moneyUnitList);

    HashMap<Integer, Integer> moneyUnitMaps = new LinkedHashMap<>();
    for (int moneyUnit : moneyUnitList) {
      moneyUnitMaps.put(moneyUnit, 0);
    }

    int subtraction = n;

    for (int moneyUnit : moneyUnitList) {
      int numOfShowUnit = subtraction / moneyUnit;
      subtraction -= numOfShowUnit * moneyUnit;
      if (numOfShowUnit > 0) {
        moneyUnitMaps.put(moneyUnit, numOfShowUnit);
      }
    }

    List<Integer> selectedUnit = new ArrayList<>();

    for (Map.Entry<Integer, Integer> moneyUnitMap : moneyUnitMaps.entrySet()) {
      if (moneyUnitMap.getValue() > 0) {
        for (int i = 0; i < moneyUnitMap.getValue(); i++) {
          selectedUnit.add(moneyUnitMap.getKey());
        }
      }
    }

    System.out.println("Output: " + selectedUnit);
  }
}
