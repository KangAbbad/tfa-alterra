package inheritance.polymorphism.animals;

public class Herbivore extends Animal {
  Herbivore(String herbName, FoodTypes herbFoodType, TeethTypes herbTeethType) {
    super(herbName, herbFoodType, herbTeethType);
  }

  public void identifyMySelf() {
    System.out.println("Hi I'm Herbivore, My Name is " + this.getName() + ", My Food is '" + this.getFoodType().getDescription() + "', I have " + this.getTeethType().getDescription() + " teeth");
  }
}
