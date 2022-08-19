package inheritance.polymorphism.vehicles;

public class VehiclesApp {
  public static void main(String[] args) {
    Vehicles cart = new Vehicles("Gerobak", EngineStatus.NO_ENGINE);
    cart.identityMySelf();

    System.out.println();

    Bikes pedalBikes = new Bikes("Pedal Bikes", EngineStatus.NO_ENGINE, 2);
    pedalBikes.identityMySelf();
    Bikes motorBikes = new Bikes("Motor Bikes", EngineStatus.NO_ENGINE, 2);
    motorBikes.identityMySelf();

    System.out.println();

    Cars sportCars = new Cars("Sport Cars", EngineStatus.WITH_ENGINE, 4, "V8");
    sportCars.identityMySelf();
    Cars pickupCars = new Cars("Pickup Cars", EngineStatus.WITH_ENGINE, 4, "Solar");
    pickupCars.identityMySelf();

    System.out.println();

    Buses transJakarta = new Buses("Trans Jakarta", EngineStatus.WITH_ENGINE, 4, BusStatus.PUBLIC_BUS);
    transJakarta.identityMySelf();
    Buses schoolBus = new Buses("School Bus", EngineStatus.WITH_ENGINE, 4, BusStatus.PRIVATE_BUS);
    schoolBus.identityMySelf();
  }
}
