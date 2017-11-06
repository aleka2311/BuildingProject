abstract class Furniture {

   private String description;
   private int furnitureArea;

    public Furniture(String description, int furnitureArea) {
        this.description = description;
        this.furnitureArea = furnitureArea;
           }
    public int getFurnitureArea() {
        return furnitureArea;
    }
    public String getDescription() {
        return description;
    }
}
