import java.util.ArrayList;
import java.util.List;

/**
 * Created by Арай on 28.10.2017.
 */
public class Building extends Exception{
   private String name;
    private List<Room> building = new ArrayList<Room>();

    public Room getRoom(String name) {
        for (Room aBuilding : building) {
            if (name==aBuilding.getRoomName()) {
                return aBuilding;
            }
        }
       return null;
   }
public void addRoom(String name, int area, int windowNumber) {
        Room room = new Room();
        room.setRoomName(name);
        building.add(room);
        room.setRoomArea(area);
        room.setWindowNumber(windowNumber);
    }
    public int getTotalFurnitureArea(Room room) {

        int x=0;

        for (int i = 0; i < room.getFurnitureList().size(); i++) {

           x=room.getFurnitureList().get(i).getFurnitureArea()+x;
        }
    return x;
    }
  public double getFreeAreaPercent(Room room){

        double x;
       x=((room.getRoomArea()- getTotalFurnitureArea(room))*100)/room.getRoomArea();
        return x;
    }
  public void describe() throws IlluminanceTooMuchException,SpaceUsageTooMuchException{

        System.out.println("Здание 1");
        for (int i = 0; i < building.size(); i++) {
            System.out.println("Комната " + (i + 1));
           if ((building.get(i).getTotalIllumination()>4000)||(building.get(i).getTotalIllumination()<300)){
               throw new IlluminanceTooMuchException();
           }
            System.out.print("Освещенность= " + building.get(i).getTotalIllumination() + " (" + building.get(i).getWindowNumber() + " окна по 700 лк, лампочки ");
            for (int j = 0; j < building.get(i).getBulbsList().size(); j++) {
            String a=", ";
                if (j==building.get(i).getBulbsList().size()-1){
                a=")";
            }
                System.out.print(building.get(i).getBulbsList().get(j).getIllumination() + a);

            }
            System.out.println();
            if(getFreeAreaPercent(building.get(i))<30){
                throw new SpaceUsageTooMuchException();
            }
            System.out.println("Площадь = "+building.get(i).getRoomArea()+" м^2 (занято "+
                    getTotalFurnitureArea(building.get(i))+" м^2, гарантированно свободно "+
                    (building.get(i).getRoomArea()- getTotalFurnitureArea(building.get(i)))
            +" м^2 или "+getFreeAreaPercent(building.get(i))+"% площади)");
           if (building.get(i).getFurnitureList().size()==0){
               System.out.println("Мебели нет");
           }
            else {
               System.out.println("Мебель:");
               for (int k = 0; k < building.get(i).getFurnitureList().size(); k++) {
                   System.out.println(building.get(i).getFurnitureList().get(k).getDescription() +
                           " (площадь " + building.get(i).getFurnitureList().get(k).getFurnitureArea() + " м^2)");
               }
           }

        }



    }

}












