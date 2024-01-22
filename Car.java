import java.awt.*;
import java.math.*;

//hej

public abstract class Car implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double xpos;
    protected double ypos;
    protected double direction;

    //eventuellt skapa Konstruktor??
    public Car() {
        this.xpos = 0;
        this.ypos = 0;
        this.direction = 0;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();

    }

    protected int getNrDoors() {

        return nrDoors;
    }

    protected double getEnginePower() {
        return enginePower;
    }


    protected double getCurrentSpeed() {
        return currentSpeed;
    }

    protected Color getColor() {
        return color;
    }

    protected void setColor(Color clr) {
        color = clr;
    }

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }

    @Override
    public void move() {
        xpos += Math.cos(Math.toRadians(direction)) * currentSpeed;
        ypos += Math.sin(Math.toRadians(direction)) * currentSpeed;
    }
    @Override
    public void turnLeft() {
        direction += 90;
    }

    @Override
    public void turnRight() {
        direction -= 90;
    }
    //ska speedfactor, inctement/decrement speed? vara med i och med att båda klasserna har det?



}