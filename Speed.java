import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Speed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Speed extends Powerup
{
    /**
     * Act - do whatever the Speed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage x;
    
    public Speed()
    {
        super();
        x = new GreenfootImage("coin.jpg");
        x.scale(40,40);
        setImage(x);
    
    }
    public void act()
    {
        move(-7);
        accelerateObject();
    }
    
    public boolean accelerateObject()
    {
    
        Vehicle f = (Vehicle)getOneIntersectingObject(Vehicle.class);
        
        
        if(f!=null)
        {
            
            getWorld().removeObject(this);
            
            return true;
            
        }
        
        return false;
    
        
    
    }
}
