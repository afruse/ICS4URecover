import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VehicleGhost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VehicleRight extends Vehicle
{
    /**
     * Act - do whatever the VehicleGhost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(speed - RacingWorld.getSpeedRight());
    }
}
