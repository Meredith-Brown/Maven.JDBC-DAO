package models;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CarTest extends TestCase {

    public void testGetID() {
        // given
        Car car = new Car(null, "Jeep", "Wrangler", 2015, "red", "AB3940");
        Integer expected = 12;
        // when
        car.setID(expected);
        // then
        Assert.assertEquals(expected, car.getID());
    }

    public void testSetID() {
        // given
        Car car = new Car(null, "Jeep", "Liberty", 2015, "red", "AM3940");
        Integer expected = 10;
        // when
        car.setID(expected);
        // then
        Assert.assertEquals(expected, car.getID());
    }

    public void testGetMake() {
        // given
        Car car = new Car(null, "Jeep", "Wrangler", 2015, "red", "AB3940");
        String expected = "JEEP";
        // when
        car.setMake(expected);
        // then
        Assert.assertEquals(expected, car.getMake());
    }

    public void testSetMake() {
        // given
        Car car = new Car(null, "Jeep", "Liberty", 2015, "red", "AM3940");
        String expected = "JEEP";
        // when
        car.setMake(expected);
        // then
        Assert.assertEquals(expected, car.getMake());
    }

    public void testGetModel() {
        // given
        Car car = new Car(null, "Jeep", "Wrangler", 2015, "red", "AB3940");
        String expected = "Grand Cherokee";
        // when
        car.setModel(expected);
        // then
        Assert.assertEquals(expected, car.getModel());
    }

    public void testSetModel() {
        // given
        Car car = new Car(null, "Jeep", "Wrangler", 2015, "red", "AM3940");
        String expected = "Compass";
        // when
        car.setModel(expected);
        // then
        Assert.assertEquals(expected, car.getModel());
    }

    public void testGetYear() {
        // given
        Car car = new Car(null, "Jeep", "Wrangler", 2015, "red", "AB3940");
        Integer expected = 2013;
        // when
        car.setYear(expected);
        // then
        Assert.assertEquals(expected, car.getYear());
    }

    public void testSetYear() {
        // given
        Car car = new Car(null, "Jeep", "Wrangler", 2015, "red", "AM3940");
        Integer expected = 1999;
        // when
        car.setYear(expected);
        // then
        Assert.assertEquals(expected, car.getYear());
    }

    public void testGetColor() {
        // given
        Car car = new Car(null, "Jeep", "Wrangler", 2015, "red", "AB3940");
        String expected = "blue";
        // when
        car.setColor(expected);
        // then
        Assert.assertEquals(expected, car.getColor());
    }

    public void testSetColor() {
        // given
        Car car = new Car(null, "Jeep", "Wrangler", 2015, "red", "AM3940");
        String expected = "green";
        // when
        car.setColor(expected);
        // then
        Assert.assertEquals(expected, car.getColor());
    }

    public void testGetVIN() {
        // given
        Car car = new Car(null, "Jeep", "Wrangler", 2015, "red", "AB3940");
        String expected = "AFDYTFY6";
        // when
        car.setVIN(expected);
        // then
        Assert.assertEquals(expected, car.getVIN());
    }

    public void testSetVIN() {
        // given
        Car car = new Car(null, "Jeep", "Wrangler", 2015, "red", "AM3940");
        String expected = "AGYUDHBE2";
        // when
        car.setVIN(expected);
        // then
        Assert.assertEquals(expected, car.getVIN());
    }
}