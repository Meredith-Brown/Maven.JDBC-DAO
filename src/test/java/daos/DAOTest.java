package daos;

import junit.framework.Assert;
import junit.framework.TestCase;
import models.Car;

import java.sql.SQLException;
import java.util.List;

public class DAOTest extends TestCase {
    DAO dao = new DAO();

    public void testFindByID() throws SQLException {
        // given
        String expectedMake = "Toyota";
        String expectedModel = "Batmobile";
        // when
        Car car = dao.findByID(2);
        // then
        Assert.assertTrue(car.getMake().equals(expectedMake) && car.getModel().equals(expectedModel));
    }

    public void testFindAll() throws SQLException {
        // given
        Car expectedCar1 = dao.findByID(2);
        Car expectedCar2 = dao.findByID(4);
        // when
        List<Car> arrayList= dao.findAll();
        Car actualCar1 = arrayList.get(1);
        Car actualCar2 = arrayList.get(3);
        // then
        Assert.assertTrue(expectedCar1.getVIN().equals(actualCar1.getVIN()));
        Assert.assertTrue(expectedCar2.getVIN().equals(actualCar2.getVIN()));
    }

    public void testUpdate1() throws SQLException {
        // given
        Integer id = 2;
        String newVIN = "123FGHJK";
        // when
        dao.update(id, "ViN", newVIN);
        String actualVIN = dao.findByID(id).getVIN();
        // then
        Assert.assertEquals(newVIN, actualVIN);
    }

    public void testUpdate2() throws SQLException {
        // given
        Integer id = 3;
        String newColor = "Purple";
        // when
        dao.update(id, "cOlOR", newColor);
        String actualColor = dao.findByID(id).getColor();
        // then
        Assert.assertEquals(newColor, actualColor);
    }

    public void testUpdate3() throws SQLException { // year
        // given
        Integer id = 4;
        Integer newYear = 2021;
        // when
        dao.update(id, "YEAR", newYear);
        Integer actualYear = dao.findByID(id).getYear();
        // then
        Assert.assertEquals(newYear, actualYear);
    }

    public void testUpdate4() throws SQLException {
        // given
        Integer id = 5;
        String newMake = "Ford";
        // when
        dao.update(id, "make", newMake);
        String actualMake = dao.findByID(id).getMake();
        // then
        Assert.assertEquals(newMake, actualMake);
    }

    public void testUpdate5() throws SQLException {
        // given
        Integer id = 6;
        String newModel = "F150";
        // when
        dao.update(id, "MODel", newModel);
        String actualModel = dao.findByID(id).getModel();
        // then
        Assert.assertEquals(newModel, actualModel);
    }

    public void testCreate() throws SQLException {
        // given
        Car car = new Car(null, "Hyundai", "Genesis", 2015, "blue",
                "AW45678");
        // when
        dao.create(car);
        List<Car> arrayList= dao.findAll();
        int index = arrayList.size()-1;
        // then
        Assert.assertEquals(car.getVIN(), arrayList.get(index).getVIN());
    }

    public void testDelete() throws SQLException {
        // given
        Car car = new Car(null, "Hyundai", "Genesis", 2015, "blue",
                "AW45679");
        dao.create(car);
        List<Car> arrayListBeforeDelete= dao.findAll();
        int sizeBeforeDelete = arrayListBeforeDelete.size();
        Integer ID = arrayListBeforeDelete.get(arrayListBeforeDelete.size()-1).getID();
        System.out.println(ID);
        // when
        dao.delete(ID);
        List<Car> arrayListAfterDelete= dao.findAll();
        int sizeAfterDelete = arrayListAfterDelete.size();
        // then
        Assert.assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
    }
}