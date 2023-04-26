
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWorld extends World
{

    /**
     * Constructor for objects of class EndWorld.
     * 
     */
    private GreenfootSound music;
    private GreenfootImage g;
    private int spawnImage;
    private boolean imageExists;
    private SimpleTimer timer = new SimpleTimer();
    private gifIntroWorldBackground backGroundAni;
    public EndWorld(boolean winner)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        imageExists = false;
        backGroundAni = new gifIntroWorldBackground();
        spawnImage = Greenfoot.getRandomNumber (1);
        addObject(new StartButton(),380,450);
        addObject(new Title(),400,100);
        addObject(backGroundAni, -400, -300);
        setBackground(backGroundAni.getImage());
        if(winner){
            addObject(new AWin(), 400, 175);
        }else{
            addObject(new BWin(), 400 ,175);
        }
        timer.mark();
    }
    
    public void act()
    {
       if(Greenfoot.isKeyDown("A")){
           OptionsWorld w = new OptionsWorld();
           Greenfoot.setWorld(w);
       }
       
    }
}



