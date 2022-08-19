package encapsulation;

public class EncapsulationApp {
  public static void main(String[] args) {
    Cat[] listOfCats = new Cat[5];
    listOfCats[0] = new Cat("Hitam", 4);
    listOfCats[1] = new Cat("Putih", 3);
    listOfCats[2] = new Cat("Hitam Putih", 4);
    listOfCats[3] = new Cat("Poleng poleng", 3);
    listOfCats[4] = new Cat("bintik bintik", 4);

    for (Cat catItem : listOfCats) {
      catItem.showIdentity();
    }

    System.out.println();

    Fish[] listOfFishes = new Fish[4];
    listOfFishes[0] = new Fish("paus", "plankton");
    listOfFishes[1] = new Fish("cupang", "cacing");
    listOfFishes[2] = new Fish("arwana", "jangkrik");
    listOfFishes[3] = new Fish("sapu-sapu", "pelet");

    for (Fish fishItem : listOfFishes) {
      fishItem.showIdentity();
    }

    System.out.println();

    Flower[] listOfFlowers = new Flower[4];
    listOfFlowers[0] = new Flower("bangkai", "merah", 12);
    listOfFlowers[1] = new Flower("anggrek", "putih", 8);
    listOfFlowers[2] = new Flower("mawar", "merah", 3);
    listOfFlowers[3] = new Flower("melati", "kuning", 5);

    for (Flower flowerItem : listOfFlowers) {
      flowerItem.showIdentity();
    }

    System.out.println();

    Car[] listOfCars = new Car[4];
    listOfCars[0] = new Car("sedan", "merah", 4);
    listOfCars[1] = new Car("truk", "hijau", 6);
    listOfCars[2] = new Car("tronton", "coklat", 12);
    listOfCars[3] = new Car("angkot", "kuning", 4);

    for (Car carItem : listOfCars) {
      carItem.showIdentity();
    }

//    System.out.println(System.lineSeparator().repeat(100));
//    clearScreen();
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
