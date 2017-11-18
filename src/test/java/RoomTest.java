import Entity.Bed;
import Entity.Bulbs;
import Entity.Cupboard;
import Entity.Room;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoomTest {
    @Test
    public void getTotalFurnitureAreaTest(){
        Room room=new Room();
        Bed bed=new Bed("Bed", 6);
        room.add(bed);
        room.add(bed);
        int before=room.getTotalFurnitureArea();
        Cupboard cupboard=new Cupboard("Cupboard", 3);
        room.add(cupboard);
        int after=room.getTotalFurnitureArea();
        Assert.assertEquals(after-before, 3);
    }
    @Test
    public void getTotalIlluminationTest(){
        Room room=new Room();
        room.setWindowNumber(2);
        int before=room.getTotalIllumination();
        room.add(new Bulbs(200));
        int after=room.getTotalIllumination();
        Assert.assertEquals(after-before, 200);
    }

}
