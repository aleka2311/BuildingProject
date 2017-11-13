
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Арай on 28.10.2017.
 */
public class Building {
    private String name;
    private List<Room> rooms = new ArrayList<Room>();
    static Logger logger= LogManager.getLogger(Building.class);


    public Room getRoom(String name) {
        for (Room aBuilding : rooms) {
            if (name == aBuilding.getRoomName()) {
                return aBuilding;
            }
        }
        return null;
    }

    public void addRoom(String name, int area, int windowNumber) {
        Room room = new Room();

        room.setRoomName(name);
        room.setRoomArea(area);
        room.setWindowNumber(windowNumber);
        rooms.add(room);
        logger.debug("Пришли параметры комнаты: имя "+room.getRoomName()+ ", площадь " + room.getRoomArea()+"м^2, c "+room.getWindowNumber()+" окнами");
      logger.info("Добавилась комната с именем" +room.getRoomName());

    }

    public void describe() throws IlluminanceTooMuchException, SpaceUsageTooMuchException {
        System.out.println( "Здание 1");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println("Комната " + (i + 1));
            if ((rooms.get(i).getTotalIllumination() > 4000) || (rooms.get(i).getTotalIllumination() < 300)) {
                throw new IlluminanceTooMuchException();
            }
            System.out.print("Освещенность= " + rooms.get(i).getTotalIllumination() + " лк (");
            if (rooms.get(i).getWindowNumber() > 0) {
                System.out.print(rooms.get(i).getWindowNumber() + " окна по 700 лк");
                if (rooms.get(i).getBulbsList().size() != 0) {
                    System.out.print(" , лампочки ");
                    for (int j = 0; j < rooms.get(i).getBulbsList().size(); j++) {
                        String a = " лк, ";
                        if (j == rooms.get(i).getBulbsList().size() - 1) {
                            a = " лк)";
                        }
                        System.out.print(rooms.get(i).getBulbsList().get(j).getIllumination() + a);
                    }
                    System.out.println();
                } else {
                    System.out.println(")");
                }
            } else {
                if (rooms.get(i).getBulbsList().size() != 0) {
                    System.out.print("Лампочки ");
                    for (int j = 0; j < rooms.get(i).getBulbsList().size(); j++) {
                        String a = " лк, ";
                        if (j == rooms.get(i).getBulbsList().size() - 1) {
                            a = " лк)";
                        }
                        System.out.print(rooms.get(i).getBulbsList().get(j).getIllumination() + a);
                    }
                    System.out.println();
                }
            }
            if (rooms.get(i).getFreeAreaPercent() < 30) {
                throw new SpaceUsageTooMuchException();
            }
            System.out.println("Площадь = " + rooms.get(i).getRoomArea() + " м^2 (занято " +
                    rooms.get(i).getTotalFurnitureArea() + " м^2, гарантированно свободно " +
                    (rooms.get(i).getRoomArea() - rooms.get(i).getTotalFurnitureArea())
                    + " м^2 или " + rooms.get(i).getFreeAreaPercent() + "% площади)");
            if (rooms.get(i).getFurnitureList().size() == 0) {
                System.out.println("Мебели нет");
            } else {
                System.out.println("Мебель:");
                for (int k = 0; k < rooms.get(i).getFurnitureList().size(); k++) {
                    System.out.println(rooms.get(i).getFurnitureList().get(k).getDescription() +
                            " (площадь " + rooms.get(i).getFurnitureList().get(k).getFurnitureArea() + " м^2)");
                }
            }

        }
    }


/*
    @Override
    public String toString() {
        return "Здание ";
    }

    public void describe2() throws IlluminanceTooMuchException, SpaceUsageTooMuchException {
        System.out.println(this + "1");
        for (int i = 0; i < building.size(); i++) {
            System.out.println("Комната " + (i + 1));
            if ((building.get(i).getTotalIllumination() > 4000) || (building.get(i).getTotalIllumination() < 300)) {
                throw new IlluminanceTooMuchException();
            }
            if (building.get(i).getFreeAreaPercent() < 30) {
                throw new SpaceUsageTooMuchException();
            }
        }
    }
    */
}












