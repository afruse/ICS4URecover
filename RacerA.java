import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RacerA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RacerA extends Racers
{
    public RacerA() {
        MAX_SPEED = 25;
    }
    public void drive() 
    {
        // Ahead is a generic vehicle - we don't know what type BUT
        // since every Vehicle "promises" to have a getSpeed() method,
        // we can call that on any vehicle to find out it's speed
        Vehicle ahead = (Vehicle) getOneObjectAtOffset ((int)(speed + getImage().getWidth()/2 + 40), 0, Vehicle.class);
        Racers racersAhead = (RacerBGhost) getOneObjectAtOffset ((int)(speed + getImage().getWidth()/2 + 110), 0, RacerBGhost.class);
        if(ahead == null && racersAhead == null){
            if(speed < MAX_SPEED){
                speed++;
            }
        }
        // added extra if statement and conditions to make sure cars don't go backwards
        else {
            if(!(ahead == null)){
                if(speed > ahead.getSpeed()){
                    speed--;
                }else if(speed == ahead.getSpeed()){
                }
            }
            if(!(racersAhead == null)){
                if(speed > racersAhead.getSpeed()){
                    speed--;
                }
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
}
