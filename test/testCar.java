import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class testCar {
    @Test
    public void setcolor(){
      Car volvo = new Volvo240();
      volvo.setColor(Color.CYAN);
      assertEquals(volvo.getColor(), Color.CYAN);
    }
    @Test
    public void speedfactorvolvo(){
        Volvo240 volvo = new Volvo240();
        volvo.enginePower = 100;
        assertEquals(volvo.speedFactor(), 1.25,0);
    }
    @Test
    public void speedfactorsaabon(){
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        saab.enginePower = 100;
        assertEquals(saab.speedFactor(),1.3,0);
    }

    @Test
    public void speedfactorsaaboff(){
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        saab.enginePower = 100;
        assertEquals(saab.speedFactor(),1,0);
    }

    @Test
    public void testgas(){
        Car car = new Volvo240();
        car.enginePower = 100;
        car.startEngine(); //0.1 currentspeed
        car.gas(1);
        assertEquals(car.getCurrentSpeed(),1.35,0);
    }

    @Test
    public void testbrake(){
        Car car = new Volvo240();
        car.enginePower = 100;
        car.startEngine(); //0.1 currentspeed
        car.gas(1);
        car.brake(0.5);
        assertEquals(car.getCurrentSpeed(),0.725,0.001);
    }



}
