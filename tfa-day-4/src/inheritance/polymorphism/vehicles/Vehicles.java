package inheritance.polymorphism.vehicles;

public class Vehicles {
  private String name;
  private EngineStatus withEngine;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWithEngine() {
    return "'" + withEngine.getDescription() + "'";
  }

  public void setWithEngine(EngineStatus withEngine) {
    this.withEngine = withEngine;
  }

  Vehicles(String vehiclesName, EngineStatus vehiclesEngine) {
    this.setName(vehiclesName);
    this.setWithEngine(vehiclesEngine);
  }

  public void identityMySelf() {
    System.out.println("Hi I'm Parent of All Vehicles, My Name is " + this.getName() + ", My Engine Status is " + this.getWithEngine());
  }
}

