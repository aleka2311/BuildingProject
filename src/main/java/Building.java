
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
        for (Room room: rooms) {
            if (name == room.getRoomName()) {
                return room;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addRoom(String name, int area, int windowNumber)  {
        for (int i = 0; i <rooms.size() ; i++) {
            if (rooms.get(i).getRoomName()==name){
                logger.error("Комната с именем "+name+" уже существует");
                return;
            }
        }
        Room room = new Room();
        room.setRoomName(name);
        room.setRoomArea(area);
        room.setWindowNumber(windowNumber);
        logger.debug("Пришли параметры комнаты: имя " + room.getRoomName() + ", площадь " + room.getRoomArea() + "м^2, c " + room.getWindowNumber() + " окнами");

        rooms.add(room);
       logger.debug("Добавилась комната под названием "+ room.getRoomName());
    }
     public int getRoomsCount(){
        return rooms.size();
         }
/*
    public void describe(){
        System.out.println(this);
        for (Room room : rooms) {
            System.out.println(room);
        }
    }*/

    public void describe() throws IlluminanceTooMuchException, SpaceUsageTooMuchException,IlluminanceNotEnoughException {
        System.out.println( "Здание 1");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i).getRoomName());
            if (rooms.get(i).getTotalIllumination() > 4000) {
                throw new IlluminanceTooMuchException();
            }
            if (rooms.get(i).getTotalIllumination() < 300){
            throw new IlluminanceNotEnoughException();
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
   public String toString()  {
       return getName();
   }
   */
}












