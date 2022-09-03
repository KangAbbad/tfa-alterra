package encapsulation;

public class Fish {
  private String type;
  private String feed;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getFeed() {
    return feed;
  }

  public void setFeed(String feed) {
    this.feed = feed;
  }

  Fish(String fishType, String fishFood) {
    this.setType(fishType);
    this.setFeed(fishFood);
  }

  public void showIdentity() {
    System.out.println("saya Ikan dengan detail, Jenis: " + this.getType() + ", makanan: " + this.getFeed());
  }
}
