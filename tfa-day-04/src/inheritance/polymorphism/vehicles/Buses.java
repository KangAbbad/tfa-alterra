package inheritance.polymorphism.vehicles;

public class Buses extends Vehicles {
  private int wheelCount;
  private BusStatus privateBus;

  public int getWheelCount() {
    return wheelCount;
  }

  public void setWheelCount(int wheelCount) {
    this.wheelCount = wheelCount;
  }

  public BusStatus getPrivateBus() {
    return privateBus;
  }

  public void setPrivateBus(BusStatus privateBus) {
    this.privateBus = privateBus;
  }

  Buses(String busName, EngineStatus busEngine, int busWheelCount, BusStatus busStatus) {
    super(busName, busEngine);
    this.setWheelCount(busWheelCount);
    this.setPrivateBus(busStatus);
  }

  public void identityMySelf() {
    System.out.println("Hi I'm Bus " + "[" + this.getPrivateBus().getDescription() + "]" + ", My Name is " + this.getName() + ", My Engine Status is " + this.getWithEngine() + ", I have " + this.getWheelCount() + " Wheel(s)");
  }
}
