package inheritance.polymorphism.animals;

public class Animal {
  private String name;
  private FoodTypes foodType;
  private TeethTypes teethType;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FoodTypes getFoodType() {
    return foodType;
  }

  public void setFoodType(FoodTypes foodType) {
    this.foodType = foodType;
  }

  public TeethTypes getTeethType() {
    return teethType;
  }

  public void setTeethType(TeethTypes teethType) {
    this.teethType = teethType;
  }

  Animal(String animalName) {
    this.setName(animalName);
  }

  Animal(String animalName, FoodTypes animalFoodType, TeethTypes animalTeethType) {
    this.setName(animalName);
    this.setFoodType(animalFoodType);
    this.setTeethType(animalTeethType);
  }

  public void identifyMySelf() {
    System.out.println("Hi I'm Parent of All Animal, My Name is " + this.getName());
  }
}

