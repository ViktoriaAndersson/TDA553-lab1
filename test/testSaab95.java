import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class testSaab95 {

    @Test
    public void testNrDoors(){
        Car car = new Saab95();
        assertEquals(2,car.getNrDoors());
    }

    @Test
    public void testenginepwr(){
        Car car = new Saab95();
        assertEquals(125,car.getEnginePower(),0.0001);
    }
    @Test
    public void setcolor(){
        Car car = new Saab95();
        car.setColor(Color.CYAN);
        assertEquals(Color.CYAN,car.getColor());
    }

    @Test
    public void turboSaabOn(){
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        assertEquals(1.625,saab.speedFactor(),0);
    }

    @Test
    public void turboSaabOff(){
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        assertEquals(1.25,saab.speedFactor(),0);
    }

    @Test
    public void testgas(){
        Car car = new Saab95();
        car.startEngine();
        car.gas(1);
        assertEquals(1.35,car.getCurrentSpeed(),0);
    }

    @Test
    public void testbrake(){
        Car car = new Saab95();
        car.startEngine();
        car.gas(1);
        car.brake(0.5);
        assertEquals(0.725,car.getCurrentSpeed(),0.001);
    }

    @Test
    public void testmove(){
        Car car = new Saab95();
        car.startEngine();
        car.move();
        assertEquals(0,car.getXpos(),0.0001);
        assertEquals(1.1,car.getYpos(),0.0001);
    }

    @Test
    public void testLeft(){
        Car car = new Saab95();
        car.turnLeft();
        assertEquals(180,car.getDirection(),0.0001);
    }

    @Test
    public void testRight(){
        Car car = new Saab95();
        car.turnRight();
        assertEquals(0,car.getDirection(),0.0001);
    }
}
