package guessCage;

import java.util.*;

import static guessCage.AnsiColor.*;

public class Board {
  static int selectedMenu;
  static int cageCount;
  static int selectedCageNumber;
  static String selectedCageName;

  void start() {
    selectedMenu = showMenu();
    switch (selectedMenu) {
      case 1 -> generateCages();
      case 99 -> System.out.println("----------------- EXIT -----------------");
      default -> {
        System.out.println("------------ PILIHAN INVALID -----------");
        System.out.println();
        selectedMenu = showMenu();
        generateCages();
      }
    }
  }

  int showMenu() {
    System.out.println("----------------------------------------");
    System.out.println(ANSI_BLUE.getColor() + "             Tebak Kandang           " + ANSI_RESET.getColor());
    System.out.println("----------------------------------------");
    System.out.println("1. Jumlah Kandang");
    System.out.println("99. Exit");
    System.out.println("----------------------------------------");
    System.out.print("Pilih Menu: ");
    Scanner selectMenu = new Scanner(System.in);
    return selectMenu.nextInt();
  }

  void generateCages() {
    System.out.println("----------------------------------------");
    System.out.print("Masukkan Jumlah Kandang: ");
    Scanner inputCageCount = new Scanner(System.in);
    cageCount = inputCageCount.nextInt();

    HashMap<Integer, Cage> cages = new HashMap<>();
    HashMap<Integer, String> hints = new HashMap<>(){{
      put(0, "K");
      put(1, "Z");
      put(2, "B");
    }};

    for (int i = 0; i < cageCount; i++) {
      int randomHintIndex = new Random().nextInt(hints.size());

      Cage buildCage = new Cage(i + 1, hints.get(randomHintIndex), "Animal", ANSI_BLUE.getColor());
      cages.put(i + 1, buildCage);
      buildCage.showMe();
    }

    System.out.print("{ ");
    for (Map.Entry<Integer, Cage> cageItem : cages.entrySet()) {
      System.out.print(cageItem.getKey() + "=" + cageItem.getValue().getName() + " ");
    }
    System.out.print("}");
    System.out.println();
    System.out.println();

    selectCage();
  }

  void selectCage() {
    System.out.print("Pilih kandang yang ingin dibuka: ");
    Scanner inputSelectCage = new Scanner(System.in);
    selectedCageNumber = inputSelectCage.nextInt();
    System.out.println("--------------- PILIHAN ----------------");
    System.out.println(ANSI_BLUE.getColor() + "K" + ANSI_RESET.getColor() + ": Kambing");
    System.out.println(ANSI_RED.getColor() + "Z" + ANSI_RESET.getColor() + ": Zebra");
    System.out.println(ANSI_YELLOW.getColor() + "B" + ANSI_RESET.getColor() + ": Bebek");
    System.out.println("----------------------------------------");
    System.out.print("Masukkan tebakan: ");
    Scanner inputGuessCage = new Scanner(System.in);
    selectedCageName = inputGuessCage.next();
  }
}
