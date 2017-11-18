package Entity;

import RoomExceptions.IlluminanceNotEnoughException;
import RoomExceptions.IlluminanceTooMuchException;
import RoomExceptions.SpaceUsageTooMuchException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Арай on 28.10.2017.
 */
public class Room {
    private int area;
    private String name;
    private int windowNumber;
    private List<Bulbs> bulbsList = new ArrayList<Bulbs>();
    private List<Furniture> furnitureList = new ArrayList<Furniture>();

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
        this.area = area;
    }

    public String getRoomName() {
        return name;
    }

    public void setRoomName(String name) {
        this.name = name;
    }

    public void add(Bulbs bulb) {
        bulb.getIllumination();
        bulbsList.add(bulb);
    }

    public int getTotalIllumination() {
        int x = 0;
        for (Bulbs aBulbsList : bulbsList) {
            x = aBulbsList.getIllumination() + x;
        }
        return x + (this.getWindowNumber() * 700);

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

    public void getIlluminationInformation() {
        System.out.print("Освещенность= " + getTotalIllumination() + " лк (");
        if (getWindowNumber() > 0) {
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
    }

    public void getFurnitureInformation() {
        System.out.println("Площадь = " + getRoomArea() + " м^2 (занято " + getTotalFurnitureArea() + " м^2, гарантированно свободно "
                + (getRoomArea() - getTotalFurnitureArea()) + " м^2 или " + getFreeAreaPercent() + "% площади)");
        if (getFurnitureList().size() == 0) {
            System.out.println("Мебели нет");
        } else {
            System.out.println("Мебель:");
            for (int k = 0; k < getFurnitureList().size(); k++) {
                System.out.println(getFurnitureList().get(k).getDescription() +
                        " (площадь " + getFurnitureList().get(k).getFurnitureArea() + " м^2)");
            }
        }

    }

    public void checkAndThrowRoomExceptions() {
        Logger logger = LogManager.getLogger(Room.class);
        if (getTotalIllumination() > 4000) {
            try {
                throw new IlluminanceTooMuchException();
            } catch (IlluminanceTooMuchException e) {
                logger.error("Освещенность должна быть меньше 4000 лк");
            }
        }
        if (getTotalIllumination() < 300) {
            try {
                throw new IlluminanceNotEnoughException();
            } catch (IlluminanceNotEnoughException e) {
                logger.error("Освещенность должна быть больше 300 лк");
            }
        }
        if (getFreeAreaPercent() < 30) {
            try {
                throw new SpaceUsageTooMuchException();
            } catch (SpaceUsageTooMuchException e) {
                logger.error("Комната не должна быть заполнена более чем на 70%");
            }
        }

    }

    public String getIlluminationInformation(StringBuilder sb) {
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
        } else {
            if (getBulbsList().size() != 0) {
                sb.append("Лампочки ");
                for (int i = 0; i < getBulbsList().size(); i++) {
                    String a = " лк, ";
                    if (i == getBulbsList().size() - 1) {
                        a = " лк)";
                    }
                    sb.append(getBulbsList().get(i).getIllumination() + a);
                }

            }
        }
        sb.append('\n');
        return String.valueOf(sb);
    }

    public String getFurnitureInformation(StringBuilder sb) {
        sb.append("Площадь = " + getRoomArea() + " м^2 (занято " +
                getTotalFurnitureArea() + " м^2, гарантированно свободно " +
                (getRoomArea() - getTotalFurnitureArea())
                + " м^2 или " + getFreeAreaPercent() + "% площади)");
        if (getFurnitureList().size() == 0) {
            sb.append('\n' + "Мебели нет");
        } else {
            sb.append('\n' + "Мебель:");
            for (int i = 0; i < getFurnitureList().size(); i++) {
                sb.append('\n' + getFurnitureList().get(i).getDescription() +
                        " (площадь " + getFurnitureList().get(i).getFurnitureArea() + " м^2)");
            }

        }
        return String.valueOf(sb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        checkAndThrowRoomExceptions();
        getIlluminationInformation(sb);
        getFurnitureInformation(sb);
        return String.valueOf(sb);
    }
}










