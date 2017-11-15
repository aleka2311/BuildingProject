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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        if (getTotalIllumination() > 4000) {
            try {
                throw new IlluminanceTooMuchException();
            } catch (IlluminanceTooMuchException e) {
                sb.append("\n Освещенность должна быть меньше 4000 лк");
            }
            return String.valueOf(sb);
        }
        if (getTotalIllumination() < 300) {
            try {
                throw new IlluminanceNotEnoughException();
            } catch (IlluminanceNotEnoughException e) {
                sb.append("\n Освещенность должна быть больше 300 лк");
            }
            return String.valueOf(sb);
        }
        if (getFreeAreaPercent() < 30) {
            try {
                throw new SpaceUsageTooMuchException();
            } catch (SpaceUsageTooMuchException e) {
                sb.append("\n Комната не должна быть заполнена более чем на 70%");
            }
            return String.valueOf(sb);
        }
        sb.append('\n' + "Освещенность= " + getTotalIllumination() + " лк (");
        if (getWindowNumber() > 0) {
            sb.append(getWindowNumber() + " окна по 700 лк");
            if (getBulbsList().size() != 0) {
                    sb.append(" , лампочки ");
                    for (int i = 0; i < getBulbsList().size(); i++) {
                        String a = " лк, ";
                        if (i == getBulbsList().size() - 1) {
                            a = " лк)";
                        }
                        sb.append(getBulbsList().get(i).getIllumination() + a);
                    }
                sb.append('\n');
            } else {
                sb.append(")");
            }
        } else{
            if (getBulbsList().size() != 0) {
                sb.append("Лампочки ");
                for (int i = 0; i < getBulbsList().size(); i++) {
                    String a = " лк, ";
                    if (i == getBulbsList().size() - 1) {
                        a = " лк)";
                    }
                    sb.append(getBulbsList().get(i).getIllumination() + a);
                }
                sb.append('\n');
            }
        }
sb.append("Площадь = " + getRoomArea() + " м^2 (занято " +
        getTotalFurnitureArea() + " м^2, гарантированно свободно " +
        (getRoomArea() - getTotalFurnitureArea())
        + " м^2 или " + getFreeAreaPercent() + "% площади)");
        if (getFurnitureList().size()==0){
            sb.append('\n'+"Мебели нет");
        } else {
            sb.append('\n' +"Мебель:");
            for (int i = 0; i < getFurnitureList().size(); i++) {
                sb.append('\n'+getFurnitureList().get(i).getDescription() +
                        " (площадь " + getFurnitureList().get(i).getFurnitureArea() + " м^2)");
            }

        }
            return String.valueOf(sb);
    }
    }










