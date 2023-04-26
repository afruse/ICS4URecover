import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Freeze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Freeze extends Powerup
{
    /**
     * Act - do whatever the Freeze wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage x;
    
    public Freeze()
    {
        super();
        x = new GreenfootImage("xyx.png");
        x.scale(40,40);
        setImage(x);
    }
    public void act()
    {
        move(-7);
        freezeObject();
    }
    
    public boolean freezeObject()
    {
    
        Vehicle g = (Vehicle)getOneIntersectingObject(Vehicle.class);
        
        
        if(g!=null)
        {
            
            getWorld().removeObject(this);
            
            return true;
            
        }
        
        return false;
    
        
    
    }
}
