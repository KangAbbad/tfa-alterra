package encapsulation;

public class Fish {
  private String type;
  private String feed;

  Fish(String fishType, String fishFood) {
    this.type = fishType;
    this.feed = fishFood;
  }

  public void showIdentity() {
    System.out.println("saya Ikan dengan detail, Jenis: " + type + ", makanan: " + feed);
  }
}
