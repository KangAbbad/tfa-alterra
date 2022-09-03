package inheritance.polymorphism.animals;

public enum TeethTypes {
  SHARP("tajam"),
  BLUNT("tumpul"),
  BLUNTSHARP("tajam dan tumpul");

  private String description;

  TeethTypes(String teethTypeDescription) {
    this.setDescription(teethTypeDescription);
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
