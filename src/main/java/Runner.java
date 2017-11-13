import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner  {
   static Logger logger= LogManager.getLogger(Runner.class);
    public static void main(String[] args) {
      Building building1=new Building();

building1.addRoom("Room #1", 30, 0);
      building1.getRoom("Room #1").add(new Bulbs(420));
        building1.getRoom("Room #1").add(new Bulbs(270));
        building1.getRoom("Room #1").add(new Bulbs(300));
        building1.getRoom("Room #1").add(new Bulbs(320));
        building1.getRoom("Room #1").add(new Cupboard("Шкаф-стенка", 7));
        building1.getRoom("Room #1").add(new Bed("Кровать двуспальная", 6));
        building1.getRoom("Room #1").add(new Table("Стол письменный", 3));
        building1.getRoom("Room #1").add(new Chair("Стул офисный", 1));
        building1.addRoom("Room #2", 25, 2);
        building1.getRoom("Room #2").add(new Bulbs(260));
        building1.getRoom("Room #2").add(new Bulbs(380));
        building1.getRoom("Room #2").add(new Bulbs(220));
        building1.getRoom("Room #2").add(new Armchair("Кресло мягкое и пушистое", 2));
        building1.getRoom("Room #2").add(new Sofa("Диван трехместный", 6));
        building1.getRoom("Room #2").add(new Chair("Стул деревянный", 1));
        building1.getRoom("Room #2").add(new Cupboard("Шкаф-стенка", 7));
        building1.addRoom("Room #3", 20, 6);
        try {
            building1.describe();
        }
        catch (IlluminanceTooMuchException e){
                     logger.error("Освещенность должна быть больше 300 лк или меньше 4000 лк");
        }
        catch (SpaceUsageTooMuchException e){
            logger.error( "Комната не должна быть заполнена более чем на 70%");
        }


    }
}
