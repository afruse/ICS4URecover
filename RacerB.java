import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RacerB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RacerB extends Racers
{
    /**
     * Act - do whatever the RacerB wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public RacerB(){
        MAX_SPEED= 25;
    }
    public void drive() 
    {
        // Ahead is a generic vehicle - we don't know what type BUT
        // since every Vehicle "promises" to have a getSpeed() method,
        // we can call that on any vehicle to find out it's speed
        Vehicle ahead = (Vehicle) getOneObjectAtOffset ((int)(speed + getImage().getWidth()/2 + 40), 0, Vehicle.class);
        Racers racersAhead = (RacerAGhost) getOneObjectAtOffset ((int)(speed + getImage().getWidth()/2 + 110), 0, RacerAGhost.class);
        if(ahead == null && racersAhead == null){
            if(speed < MAX_SPEED){
                speed++;
            }
        }
        // added extra if statement and conditions to make sure cars don't go backwards
        else {
            if(!(ahead == null)){
                speed = ahead.getSpeed();
            }
            if(!(racersAhead == null)){
                speed = racersAhead.getSpeed();
            }
            if(!alreadyChanging){
                changeLane();
                alreadyChanging = true;
            }
        }
    }
    public void act()
    {
        if(changeLanesNowRight && getY() < nextLane){
            setLocation(getX(), getY() + 3);
        }
        else if(changeLanesNowLeft && getY() > nextLane){
            setLocation(getX(), getY() - 3);
        }
        else{
            changeLanesNowRight = false;
            changeLanesNowLeft = false;
            alreadyChanging = false;
        }
        drive();
    }
    public int getSpeed(){
        return speed;
    }
}
