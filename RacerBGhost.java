import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RacerBGhost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RacerBGhost extends Racers
{
    private int changeY;
    private RacerB parent;
    /**
     * Act - do whatever the RacerAGhost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public RacerBGhost(RacerB parent){
        this.parent = parent;
        image = new GreenfootImage("bmw_resize.png");
    }
    public void act()
    {
        if(getX() > 600){
            image.setTransparency(0);
            setImage(image);
        }
        if(parent.changeLanesNowRight && getY() < parent.nextLane){
            setLocation(getX(), getY() + 3);
        }
        else if(parent.changeLanesNowLeft && getY() > parent.nextLane){
            setLocation(getX(), getY() - 3);
        }
        move(RacingWorld.getSpeedRight() - RacingWorld.getSpeedLeft());
    }
}
