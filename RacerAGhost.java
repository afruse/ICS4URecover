import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RacerAGhost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RacerAGhost extends Racers
{
    private int changeY;
    private RacerA parent;
    /**
     * Act - do whatever the RacerAGhost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public RacerAGhost(RacerA parent){
        this.parent = parent;
        image = new GreenfootImage("370z_resize.png");
    }
    public void act()
    {
        if(getX() < 600){
            image.setTransparency(0);
            setImage(image);
        }
        if(parent.changeLanesNowRight && getY() < parent.nextLane){
            setLocation(getX(), getY() + 3);
        }
        else if(parent.changeLanesNowLeft && getY() > parent.nextLane){
            setLocation(getX(), getY() - 3);
        }
        move(RacingWorld.getSpeedLeft() - RacingWorld.getSpeedRight());
    }
}
