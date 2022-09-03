package inheritance.polymorphism.vehicles;

public enum BusStatus {
  PUBLIC_BUS("Public Bus"),
  PRIVATE_BUS("Private Bus");

  private String description;

  BusStatus(String busStatusDescription) {
    this.setDescription(busStatusDescription);
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
