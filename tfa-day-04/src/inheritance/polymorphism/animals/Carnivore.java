package inheritance.polymorphism.animals;

public class Carnivore extends Animal {
  Carnivore(String carniName, FoodTypes carniFoodType, TeethTypes carniTeethType) {
    super(carniName, carniFoodType, carniTeethType);
  }

  public void identifyMySelf() {
    System.out.println("Hi I'm Carnivore, My Name is " + this.getName() + ", My Food is '" + this.getFoodType().getDescription() + "', I have " + this.getTeethType().getDescription() + " teeth");
  }
}
