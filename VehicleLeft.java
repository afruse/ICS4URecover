import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VehicleLeft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VehicleLeft extends Vehicle
{
    /**
     * Act - do whatever the VehicleLeft wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(speed - RacingWorld.getSpeedLeft());
    }
}
