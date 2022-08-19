package encapsulation;

public class Flower {
  private String name;
  private String color;
  private int numOfPetal;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getNumOfPetal() {
    return numOfPetal;
  }

  public void setNumOfPetal(int numOfPetal) {
    this.numOfPetal = numOfPetal;
  }

  Flower(String flowerName, String flowerColor, int flowerNumOfPetal) {
    this.name = flowerName;
    this.color = flowerColor;
    this.numOfPetal = flowerNumOfPetal;
  }

  public void showIdentity() {
    System.out.println("saya Bunga dengan detail, Jenis: " + name + ", color: " + color + ", num of petal: " + numOfPetal);
  }
}
