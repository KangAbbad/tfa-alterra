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
    this.setType(carType);
    this.setColor(carColor);
    this.setNumOfTire(carNumOfTire);
  }

  public void showIdentity() {
    System.out.println("saya Mobil dengan detail, Type: " + this.getType() + ", color: " + this.getColor() + ", num of tire: " + this.getNumOfTire());
  }
}
