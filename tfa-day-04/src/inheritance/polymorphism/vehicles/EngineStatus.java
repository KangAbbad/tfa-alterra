package inheritance.polymorphism.vehicles;

public enum EngineStatus {
  NO_ENGINE("no engine"),
  WITH_ENGINE("with engine");

  private String description;

  EngineStatus(String engineStatusDescription) {
    this.setDescription(engineStatusDescription);
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
