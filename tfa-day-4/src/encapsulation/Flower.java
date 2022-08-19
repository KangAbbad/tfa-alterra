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
    this.setName(flowerName);
    this.setColor(flowerColor);
    this.setNumOfPetal(flowerNumOfPetal);
  }

  public void showIdentity() {
    System.out.println("saya Bunga dengan detail, Jenis: " + this.getName() + ", color: " + this.getColor() + ", num of petal: " + this.getNumOfPetal());
  }
}
