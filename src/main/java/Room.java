import java.util.ArrayList;
import java.util.List;


/**
 * Created by Арай on 28.10.2017.
 */
public class Room {
    private   int area;
   private  String name;
    private  int windowNumber;
    private List<Bulbs> bulbsList=new ArrayList<Bulbs>();
  private List<Furniture> furnitureList=new ArrayList<Furniture>();
  public List<Bulbs> getBulbsList() {
        return bulbsList;
    }
   public List<Furniture> getFurnitureList() {
        return furnitureList;
    }
  public int getWindowNumber() {
        return windowNumber;
    }
   public void setWindowNumber(int windowNumber) {
        this.windowNumber = windowNumber;
    }
   public int getRoomArea() {
        return area;
    }
    public void setRoomArea(int area) {
        this.area=area;
    }
    public String getRoomName() {
        return name;
    }
    public void setRoomName(String name) {
        this.name=name;
    }
    public void add(Bulbs bulb) {
    bulb.getIllumination();
        bulbsList.add(bulb);
    }
    public int getTotalIllumination() {
     int x=0;
        for (Bulbs aBulbsList : bulbsList) {
            x = aBulbsList.getIllumination() + x;
        }
        return x+(this.getWindowNumber()*700);

    }
       public void add(Table table) {
          table.getDescription();
           table.getFurnitureArea();
           furnitureList.add(table);
    }
    public void add(Armchair armchair) {
        armchair.getDescription();
        armchair.getFurnitureArea();
        furnitureList.add(armchair);
    }
    public void add(Sofa sofa) {
        sofa.getDescription();
       sofa.getFurnitureArea();
        furnitureList.add(sofa);
    }
    public void add(Chair chair) {
        chair.getDescription();
        chair.getFurnitureArea();
        furnitureList.add(chair);
    }
    public void add(Cupboard cupboard) {
        cupboard.getDescription();
        cupboard.getFurnitureArea();
        furnitureList.add(cupboard);
    }
    public void add(Bed bed) {
        bed.getDescription();
        bed.getFurnitureArea();
        furnitureList.add(bed);
    }
    public int getTotalFurnitureArea() {

        int x = 0;

        for (int i = 0; i < getFurnitureList().size(); i++) {

            x = getFurnitureList().get(i).getFurnitureArea() + x;
        }
        return x;
    }

    public double getFreeAreaPercent() {

        double x;
        x = ((getRoomArea() - getTotalFurnitureArea()) * 100) / getRoomArea();
        return x;
    }

    /*
    @Override
    public String toString() {
        String s1="";
        return "Освещенность= " + getTotalIllumination() + " лк ("+s1;

        if (getWindowNumber()>0) {
                System.out.print(getWindowNumber() + " окна по 700 лк");
                if (getBulbsList().size() != 0) {
                    System.out.print(" , лампочки ");
                    for (int j = 0; j < getBulbsList().size(); j++) {
                        String a = " лк, ";
                        if (j == getBulbsList().size() - 1) {
                            a = " лк)";
                        }
                        System.out.print(getBulbsList().get(j).getIllumination() + a);
                    }
                    System.out.println();
                } else {
                    System.out.println(")");
                }
            } else {
                if (getBulbsList().size() != 0) {
                    System.out.print("Лампочки ");
                    for (int j = 0; j < getBulbsList().size(); j++) {
                        String a = " лк, ";
                        if (j == getBulbsList().size() - 1) {
                            a = " лк)";
                        }
                        System.out.print(getBulbsList().get(j).getIllumination() + a);
                    }
                    System.out.println();
                }
            }

            System.out.println("Площадь = "+getRoomArea()+" м^2 (занято "+
                    getTotalFurnitureArea()+" м^2, гарантированно свободно "+
                    (getRoomArea()- getTotalFurnitureArea())
                    +" м^2 или "+getFreeAreaPercent()+"% площади)");
            if (getFurnitureList().size()==0){
                System.out.println("Мебели нет");
            }
            else {
                System.out.println("Мебель:");
                for (int k = 0; k < getFurnitureList().size(); k++) {
                    System.out.println(getFurnitureList().get(k).getDescription() +
                            " (площадь " + getFurnitureList().get(k).getFurnitureArea() + " м^2)");
                }
            }
return name;
        }
          @Override
    public String toString() {
        return "Room{" +
                "area=" + area +
                ", name='" + name + '\'' +
                ", windowNumber=" + windowNumber +
                ", bulbsList=" + bulbsList +
                ", furnitureList=" + furnitureList +
                '}';
    }
*/
}








