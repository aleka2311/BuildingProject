import Entity.Building;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuildingTest {
    @Test
    public void addRoomTest (){
        Building building=new Building();
        int before=building.getRoomsCount();
        building.addRoom("r",5,4);
        int after=building.getRoomsCount();
        Assert.assertEquals(after-before, 1);
    }
    @Test
    public void addRoomNegativeTest(){
        Building building = new Building();
        building.addRoom("r",5,4);
        int before=building.getRoomsCount();
        building.addRoom("r",5,4);
        int after=building.getRoomsCount();
        Assert.assertEquals(before-after,0);
    }

}
