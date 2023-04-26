import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Filler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Filler extends Actor
{
    private GreenfootImage image;
    public Filler( int width, int height){
        image = new GreenfootImage (width, height);
        image.setColor(new Color (70,50, 75, 255));
        image.fillRect(0, 0, width-1, height - 1);
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
    }
}
