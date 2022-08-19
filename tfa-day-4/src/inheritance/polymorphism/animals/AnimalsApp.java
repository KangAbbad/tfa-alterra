package inheritance.polymorphism.animals;

public class AnimalsApp {
  public static void main(String[] args) {
    Animal animal = new Animal("Binatang");
    animal.identifyMySelf();

    System.out.println();

    Herbivore goat = new Herbivore("Kambing", FoodTypes.HERBIVORE, TeethTypes.BLUNT);
    goat.identifyMySelf();
    Carnivore lion = new Carnivore("Singa", FoodTypes.CARNIVORE, TeethTypes.SHARP);
    lion.identifyMySelf();

    System.out.println();

    Omnivore chicken = new Omnivore("Ayam", FoodTypes.OMNIVORE, TeethTypes.BLUNTSHARP);
    chicken.identifyMySelf();
  }
}
