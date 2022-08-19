package inheritance.polymorphism.animals;

public enum FoodTypes {
  HERBIVORE("tumbuhan"),
  CARNIVORE("daging"),
  OMNIVORE("semua");

  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  FoodTypes(String foodTypeDescription) {
    this.setDescription(foodTypeDescription);
  }
}
