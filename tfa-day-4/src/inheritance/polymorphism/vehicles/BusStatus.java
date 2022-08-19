package inheritance.polymorphism.vehicles;

public enum BusStatus {
  PUBLIC_BUS("Public Bus"),
  PRIVATE_BUS("Private Bus");

  private String description;

  BusStatus(String busStatusDescription) {
    this.description = busStatusDescription;
  }

  public String getDescription() {
    return description;
  }
}
