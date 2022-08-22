package guessCage;

import static guessCage.AnsiColor.ANSI_RESET;

public class Cage {
  int number;
  String name;
  String description;
  String ansiColor;
  boolean isActive = false;

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAnsiColor() {
    return ansiColor;
  }

  public void setAnsiColor(String ansiColor) {
    this.ansiColor = ansiColor;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  Cage(int cageNumber, String cageName, String cageDescription, String cageAnsiColor) {
    this.setNumber(cageNumber);
    this.setName(cageName);
    this.setDescription(cageDescription);
    this.setAnsiColor(cageAnsiColor);
  }

  Cage(int cageNumber, String cageName, String cageDescription, String cageAnsiColor, boolean isCageActive) {
    this.setNumber(cageNumber);
    this.setName(cageName);
    this.setDescription(cageDescription);
    this.setAnsiColor(cageAnsiColor);
    this.setActive(isCageActive);
  }

  void showMe() {
    System.out.println("|||");
    if (isActive) {
      System.out.println("|" + this.getAnsiColor() + this.getName() + ANSI_RESET.getColor() + "|");
    } else {
      System.out.println("|" + this.getNumber() + "|");
    }
    System.out.println("|||");
    System.out.println();
  }
}
