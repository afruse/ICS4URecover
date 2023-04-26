import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OptionsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OptionsWorld extends World
{

    /**
     * Constructor for objects of class Options.
     * 
     */
    private ARacer racerA = new ARacer();
    private BRacer racerB = new BRacer();
    private HigherSpeed higherA = new HigherSpeed();
    private LowerSpeed lowerA = new LowerSpeed();
    private HigherSpeed higherB = new HigherSpeed();
    private LowerSpeed lowerB = new LowerSpeed();
    private BMWForOptions bmw = new BMWForOptions();
    private NissanForOptions nissan = new NissanForOptions();
    //switch worlds to spawn in cars, initialize the car objects
    private static RacerA racerThreeSeventy;
    private static RacerB racerBeeEmW;
    private GreenfootSound higherASound = new GreenfootSound("VQ35_HIGH_1.wav");
    private GreenfootSound lowerASound = new GreenfootSound("VQ35_LOW_4.5.wav");
    private GreenfootSound higherBSound = new GreenfootSound("Ouch_8.wav");
    private GreenfootSound lowerBSound = new GreenfootSound("Ouch_3.wav");
    private StartButton start = new StartButton();
    public OptionsWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false);
        racerThreeSeventy = new RacerA();
        racerBeeEmW = new RacerB();
        setBackground("optionsbackground.png");
        // add the buttons and racers
        addObject(racerA, 183, 78);
        addObject(higherA, 479, 52);
        addObject(lowerA, 479, 118);
        addObject(racerB, 183, 364);
        addObject(higherB, 479, 330);
        addObject(lowerB, 479, 400);
        addObject(bmw, 191,490);
        addObject(nissan, 198,192);
        addObject(start, 599,513);
    }
    public void act(){
        // change worlds to start race once A is pressed
        if(Greenfoot.isKeyDown("A")){
            RacingWorld w = new RacingWorld(racerThreeSeventy, racerBeeEmW);
            Greenfoot.setWorld(w);
        }
        if(Greenfoot.mouseClicked(higherA)){
            racerThreeSeventy.setMaxSpeed(racerThreeSeventy.getMaxSpeed() + 1);
            higherASound.play();
        }
        if(Greenfoot.mouseClicked(lowerA)){
            racerThreeSeventy.setMaxSpeed(racerThreeSeventy.getMaxSpeed() - 1);
            lowerASound.play();
        }
        if(Greenfoot.mouseClicked(higherB)){
            racerBeeEmW.setMaxSpeed(racerThreeSeventy.getMaxSpeed() + 1);
            higherBSound.play();
        }
        if(Greenfoot.mouseClicked(lowerB)){
            racerBeeEmW.setMaxSpeed(racerThreeSeventy.getMaxSpeed() - 1);
            lowerBSound.play();
        }
        
    }
}
