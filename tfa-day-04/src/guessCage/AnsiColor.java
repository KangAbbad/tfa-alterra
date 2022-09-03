package guessCage;

public enum AnsiColor {
  ANSI_RESET("\u001B[0m"),
  ANSI_BLUE("\u001B[34m"),
  ANSI_YELLOW("\u001B[33m"),
  ANSI_RED("\u001B[31m"),
  ANSI_BLACK("\u001B[30m"),
  ANSI_GREEN("\u001B[32m"),
  ANSI_PURPLE("\u001B[35m"),
  ANSI_CYAN("\u001B[36m"),
  ANSI_WHITE("\u001B[37m");

  String color;

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  AnsiColor(String color) {
    this.setColor(color);
  }
}
