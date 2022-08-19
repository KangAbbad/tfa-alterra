package inheritance.polymorphism.vehicles;

public class Cars extends Vehicles {
  private int wheelCount;
  private String engineType;

  public int getWheelCount() {
    return wheelCount;
  }

  public void setWheelCount(int wheelCount) {
    this.wheelCount = wheelCount;
  }

  public String getEngineType() {
    return engineType;
  }

  public void setEngineType(String engineType) {
    this.engineType = engineType;
  }

  Cars(String carName, EngineStatus carEngine, int carWheelCount, String carEngineType) {
    super(carName, carEngine);
    this.setWheelCount(carWheelCount);
    this.setEngineType(carEngineType);
  }

  public void identityMySelf() {
    System.out.println("Hi I'm Car, My Name is " + this.getName() + ", My Engine Status is " + this.getWithEngine() + ", I have " + this.getWheelCount() + " Wheel(s), " + "My Engine Type = " + this.getEngineType());
  }
}
