package encapsulation;

public class Car {
  private String type;
  private String color;

  private int numOfTire;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getNumOfTire() {
    return numOfTire;
  }

  public void setNumOfTire(int numOfTire) {
    this.numOfTire = numOfTire;
  }

  Car(String carType, String carColor, int carNumOfTire) {
    this.type = carType;
    this.color = carColor;
    this.numOfTire = carNumOfTire;
  }

  public void showIdentity() {
    System.out.println("saya mobil dengan detail, Type: " + type + ", color: " + color + ", num of tire: " + numOfTire);
  }
}
