import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
 *  By Anthony
 *  This is the city backdrop object, which works by scrolling across the screen to generate the effect of a city in the background
 */

public class Backdrop extends Actor {
    private int backDropSpeed = -1;
    public Backdrop() {
        setImage("backdrop.png");
    }
    
    public int getBackDropSpeed(){
        return backDropSpeed;
    }
    public void setBackDropSpeed(int a){
        backDropSpeed = a * -1;

    }
    /**
     * Act - do whatever the Backdrop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        move(backDropSpeed);

        // Check if the left edge of the backdrop is entirely outside the world
        if (getX() + getImage().getWidth() < 0) {
            // Remove the backdrop from the world
            getWorld().removeObject(this);
        }
    }
}
