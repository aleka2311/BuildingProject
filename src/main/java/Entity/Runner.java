package Entity;

import Entity.*;
import RoomExceptions.IlluminanceNotEnoughException;
import RoomExceptions.IlluminanceTooMuchException;
import RoomExceptions.SpaceUsageTooMuchException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

    public static void main(String[] args) {
        Building building1 = new Building();
        building1.setName("Здание 1");
        building1.addRoom("Комната 1", 30, 0);
        building1.getRoom("Комната 1").add(new Bulbs(420));
        building1.getRoom("Комната 1").add(new Bulbs(270));
        building1.getRoom("Комната 1").add(new Bulbs(300));
        building1.getRoom("Комната 1").add(new Bulbs(320));
        building1.getRoom("Комната 1").add(new Cupboard("Шкаф-стенка", 7));
        building1.getRoom("Комната 1").add(new Bed("Кровать двуспальная", 6));
        building1.getRoom("Комната 1").add(new Table("Стол письменный", 3));
        building1.getRoom("Комната 1").add(new Chair("Стул офисный", 1));
        building1.addRoom("Комната 2", 25, 2);
        building1.getRoom("Комната 2").add(new Bulbs(260));
        building1.getRoom("Комната 2").add(new Bulbs(380));
        building1.getRoom("Комната 2").add(new Bulbs(220));
        building1.getRoom("Комната 2").add(new Armchair("Кресло мягкое и пушистое", 2));
        building1.getRoom("Комната 2").add(new Sofa("Диван трехместный", 6));
        building1.getRoom("Комната 2").add(new Chair("Стул деревянный", 1));
        building1.getRoom("Комната 2").add(new Cupboard("Шкаф-стенка", 7));
        building1.addRoom("Комната 3", 20, 6);
        building1.addRoom("Комната 1", 30, 0);
        building1.describe();
        //this is second commit
        //this is second commit to develop branch
    }
}
