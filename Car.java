import java.awt.*;

public abstract class Car implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double xpos; // x-pos of car
    protected double ypos; // y-pos of car
    protected double direction; // direction of car

    public Car(int nrDoors, Color color, double enginePower, String modelName) {
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
        return this.nrDoors;
    }
    protected double getEnginePower() {
        return this.enginePower;
    }

    protected double getCurrentSpeed() {
        return this.currentSpeed;
    }

    protected Color getColor() {
        return this.color;
    }

    protected void setColor(Color clr) {
        this.color = clr;
    }

    protected void startEngine(){
        this.currentSpeed = 0.1;
    }

    protected void stopEngine(){
        this.currentSpeed = 0;
    }


    //ska speedfactor, inctement/decrement speed? vara med i och med att båda klasserna har det?

    //fixade med hjälp av att göra abstract och protected och override i de andra klasserna.
    //Abstract för att denna metod måste implementeras i subklassen.
    protected abstract double speedFactor();

    // Detta minimeraar kodduplicering och säkerställer att currentSpeed alltid ligger i intervallet
    // [0, enginePower] enl. uppg4. Void pga superklassen kan ge en generell implementation
    // som passar alla subklasser
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // tog bort ifrån saab och volvo pga båda skall ha det. Pga vilkoret att det endast skall acceptera
    //värden mellan 0 och 1 så la jag in if-satsen.
    public void gas(double amount) {
        try {if (amount >= 0 && amount <= 1) {
                incrementSpeed(amount);
            }
            else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Choose a number between 0 and 1");
        }
    }
    public void brake(double amount) {
        try {
            if (amount >= 0 && amount <= 1) {
                decrementSpeed(amount);
            }
            else {
                throw new Exception();}
        } catch (Exception e) {
            System.out.println("Choose a number between 0 and 1");
        }
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

}