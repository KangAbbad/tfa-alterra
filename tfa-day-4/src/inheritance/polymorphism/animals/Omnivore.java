package inheritance.polymorphism.animals;

public class Omnivore extends Animal {
  Omnivore(String omniName, FoodTypes omniFoodType, TeethTypes omniTeethType) {
    super(omniName, omniFoodType, omniTeethType);
  }

  public void identifyMySelf() {
    System.out.println("Hi I'm Omnivore, My Name is " + this.getName() + ", My Food is '" + this.getFoodType().getDescription() + "', I have " + this.getTeethType().getDescription() + " teeth");
  }
}
