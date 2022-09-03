package inheritance.polymorphism.vehicles;

public class Bikes extends Vehicles {
  private int wheelCount;

  public int getWheelCount() {
    return wheelCount;
  }

  public void setWheelCount(int wheelCount) {
    this.wheelCount = wheelCount;
  }

  Bikes(String bikesName, EngineStatus bikesEngine, int bikesWheelCount) {
    super(bikesName, bikesEngine);
    this.setWheelCount(bikesWheelCount);
  }

  public void identityMySelf() {
    System.out.println("Hi I'm Bike, My Name is " + this.getName() + ", My Engine Status is " + this.getWithEngine() + ", I have " + this.getWheelCount() + " Wheel(s)");
  }
}
