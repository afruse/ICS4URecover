import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Racers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Racers extends Actor
{
    protected int MAX_SPEED;
    protected int speed;
    protected LaneChange changerRight = new LaneChange(88);
    protected LaneChange changerLeft = new LaneChange(88);
    protected boolean changeLanesNowRight = false;
    protected boolean changeLanesNowLeft = false;
    protected boolean spawnedLeft = false;
    protected boolean spawnedRight = false;
    protected int nextLane;
    protected boolean alreadyChanging = false;
    protected GreenfootImage image;
    protected void changeLane(){
        if(!spawnedRight){
            getWorld().addObject(changerRight, getX() + 97, getY() + 80);
            spawnedRight = true;
            changerRight.setSpawned();
        }
        if(!spawnedLeft){
            getWorld().addObject(changerLeft, getX() + 97, getY() - 80);
            spawnedLeft = true;
            changerLeft.setSpawned();
        }
        spawnedLeft = changerLeft.spawned;
        spawnedRight = changerRight.spawned;
        if(!alreadyChanging){
            if(spawnedRight && !changerRight.touching() && getY() < 275 + 79*3){
                alreadyChanging = true;
                changeLanesNowRight = true;
                nextLane = getY() + 79;
            }
            else if(spawnedLeft && !changerLeft.touching() && getY() > 275){
                alreadyChanging = true;
                changeLanesNowLeft = true;
                nextLane = getY() - 79;
            }
            else{
                alreadyChanging = false;
            }
        }
    }
    public int getMaxSpeed(){
        return MAX_SPEED;
    }
    public void setMaxSpeed(int maxSpeed){
        MAX_SPEED = maxSpeed;
    }
    public int getSpeed(){
        return speed;
    }
}
