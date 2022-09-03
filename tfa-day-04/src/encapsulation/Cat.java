package encapsulation;

public class Cat {
  private String furColor;
  private int numOfLeg;

  public int getNumOfLeg() {
    return numOfLeg;
  }

  public void setNumOfLeg(int numOfLeg) {
    this.numOfLeg = numOfLeg;
  }

  public String getFurColor() {
    return furColor;
  }

  public void setFurColor(String furColor) {
    this.furColor = furColor;
  }

  Cat(String catFurColor, int catNumOfLeg) {
    this.setFurColor(catFurColor);
    this.setNumOfLeg(catNumOfLeg);
  }

  public void showIdentity() {
    System.out.println("Saya Kucing dengan detail, Warna bulu: " + this.getFurColor() + " dengan jumlah kaki : " + this.getNumOfLeg());
  }
}
