import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LaneChange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LaneChange extends Actor
{
    private static GreenfootImage image;
    private static boolean visible;
    public int height;
    public int width;
    public boolean spawned = false;
    public LaneChange (int laneHeight)
    {
        this.height = (int)(laneHeight * 0.75);
        width = 450;
        // set this to true to see the Spawners - might help with understanding of how this works:
        visible = false;
        image = new GreenfootImage (width, height);
        if(visible){
            image.setColor(new Color (70,70, 0, 155));
            image.fillRect(0, 0, width - 1, height - 1);
        }
        setImage(image);
        
    }
    public boolean touching(){
        return this.isTouching (Racers.class) || this.isTouching (Vehicle.class);
    }
    public void setSpawned(){
        spawned = true;
    }
    public void act()
    {
        Actor actor = getOneIntersectingObject(Vehicle.class);
        Actor actor2 = getOneIntersectingObject(Racers.class);
        if (actor != null || actor2 != null) {
            spawned = false;
            getWorld().removeObject(this);
            //if you want to remove an object from an actor class you have to use getWorld().removeObject;
        }
    }
}
