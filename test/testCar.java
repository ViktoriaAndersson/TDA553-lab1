import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class testCar {

    @Test
    public void testNrDoors(){
        Car car = new Saab95();
        car.nrDoors = 4;
        assertEquals(4,car.getNrDoors());
    }

    @Test
    public void testenginepwr(){
        Car car = new Saab95();
        car.enginePower = 40;
        assertEquals(40,car.getEnginePower(),0.0001);
    }
    @Test
    public void setcolor(){
      Car volvo = new Volvo240();
      volvo.setColor(Color.CYAN);
      assertEquals(Color.CYAN,volvo.getColor());
    }
    @Test
    public void speedfactorVolvo(){
        Volvo240 volvo = new Volvo240();
        volvo.enginePower = 100;
        assertEquals( 1.25,volvo.speedFactor(),0);
    }
    @Test
    public void turboSaabOn(){
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        saab.enginePower = 100;
        assertEquals(1.3,saab.speedFactor(),0);
    }

    @Test
    public void turboSaabOff(){
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        saab.enginePower = 100;
        assertEquals(1,saab.speedFactor(),0);
    }

    @Test
    public void testgas(){
        Car car = new Volvo240();
        car.enginePower = 100;
        car.startEngine(); //0.1 currentspeed
        car.gas(1);
        assertEquals(1.35,car.getCurrentSpeed(),0);
    }

    @Test
    public void testbrake(){
        Car car = new Volvo240();
        car.enginePower = 100;
        car.startEngine(); //0.1 currentspeed
        car.gas(1);
        car.brake(0.5);
        assertEquals(0.725,car.getCurrentSpeed(),0.001);
    }

    @Test
    public void testmove(){
        Car car = new Volvo240();
        car.xpos = 1;
        car.ypos = 0;
        car.direction = 90;
        car.startEngine();
        car.currentSpeed = 10;
        car.move();
        assertEquals(1,car.xpos,0.0001);
        assertEquals(10,car.ypos,0.0001);
    }

    @Test
    public void testLeft(){
        Car car = new Volvo240();
        car.direction = 360;
        car.turnLeft();
        assertEquals(90,car.direction,0.0001);
    }

    @Test
    public void testRight(){
        Car car = new Volvo240();
        car.direction = 450;
        car.turnRight();
        assertEquals(0,car.direction,0.0001);
    }

}
