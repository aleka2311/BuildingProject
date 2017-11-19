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
public class Building {


    private String name;
    private List<Room> rooms = new ArrayList<Room>();
    static Logger logger = LogManager.getLogger(Building.class);


    public Room getRoom(String name) {
        for (Room room : rooms) {
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

    public void addRoom(String name, int area, int windowNumber) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomName() == name) {
                logger.error("Комната с именем " + name + " уже существует");
                return;
            }
        }
        Room room = new Room();
        room.setRoomName(name);
        room.setRoomArea(area);
        room.setWindowNumber(windowNumber);
        logger.debug("Пришли параметры комнаты: имя " + room.getRoomName() + ", площадь " + room.getRoomArea() + "м^2, c " + room.getWindowNumber() + " окнами");

        rooms.add(room);
        logger.debug("Добавилась комната под названием " + room.getRoomName());
    }

    public int getRoomsCount() {
        return rooms.size();
    }

    public void describe()  {
        System.out.println(this);
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
    @Override
    public String toString() {
        return getName();
    }

}












