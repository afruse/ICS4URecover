import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RacingWorld extends World
{
    private static int X_RESOLUTION = 1200;
    private static int Y_RESOLUTION = 600;
    private LaneMarker lastLane;
    private int imagesOne;
    private int imagesTwo;
    private LaneMarker[] laneMarkersOneArray = new LaneMarker[6];
    private LaneMarker[] laneMarkersTwoArray = new LaneMarker[6];
    private MouseInfo m;
    private SuperWindow left;
    private SuperWindow right;
    private boolean[] flags = new boolean[5];
    private GreenfootImage background;
    public static RacerA racerThreeSeventy;
    private static RacerBGhost racerCloneLeft;
    public static RacerB racerBeeEmW;
    private static RacerAGhost racerCloneRight;
    private GreenfootSound threeSeventy = new GreenfootSound("VQ35_HIGH_5.wav");
    private GreenfootSound beeEmW = new GreenfootSound("Ouch_6.wav");
    private Label timeText;
    private SimpleTimer timer;
    private GreenfootSound music = new GreenfootSound("Initial D  Adrenaline  Ace.mp3");
    private boolean winner;
    /**
     * Constructor for objects of class MyWorld.
     * e
     */
    
    public RacingWorld(RacerA racerA, RacerB racerB)
    {    
        super(X_RESOLUTION, Y_RESOLUTION, 1, false);//might double later to add split screen to display each racer
        racerThreeSeventy = racerA;
        racerBeeEmW = racerB;
        racerCloneLeft = new RacerBGhost(racerBeeEmW);
        racerCloneRight = new RacerAGhost(racerThreeSeventy);
        imagesOne = 0;
        imagesTwo = 0;
        background = new GreenfootImage("background01.png");
        for(int i = 0; i < 6; i++){
            laneMarkersOneArray[i] = new LaneMarker();
            laneMarkersTwoArray[i] = new LaneMarker();
        }
        flags[0] = false;
        flags[1] = true;
        flags[2] = false;
        flags[3] = false;
        flags[4] = false;
        left = new SuperWindow(background, 0, 0, "leftScreen", flags);
        right = new SuperWindow(background, 0, 0, "rightScreen", flags);
        addObject(left, 300, 300);
        addObject(right, 900, 300);
        for(int i = 0; i < laneMarkersOneArray.length; i++){
            left.addObject(laneMarkersOneArray[i], ((laneMarkersOneArray[i].getImage().getWidth()/2 + imagesOne) - 170), Y_RESOLUTION - 203);
            imagesOne += laneMarkersOneArray[i].getImage().getWidth();
            right.addObject(laneMarkersTwoArray[i], ((laneMarkersTwoArray[i].getImage().getWidth()/2 + imagesTwo) + 20), Y_RESOLUTION - 203);
            imagesTwo += laneMarkersTwoArray[i].getImage().getWidth();
        }
        addObject(new Filler(275, Y_RESOLUTION), X_RESOLUTION/2, Y_RESOLUTION/2);
        left.addObject(racerThreeSeventy, 170, 275 + 79);
        left.addObject(racerCloneLeft, 170, 275);
        right.addObject(racerBeeEmW, 170 + 100, 275);
        right.addObject(racerCloneRight, 170 + 100, 275 + 79);
        threeSeventy.setVolume(70);
        beeEmW.setVolume(67);
        music.setVolume(100);
        setPaintOrder(Filler.class, Racers.class, Vehicle.class);
        timer = new SimpleTimer();
        timeText = new Label(0,150);
        addObject(timeText, 1100,100);
    }
    /**
     * method to scroll lane
     * check how it works after background added
     */
    public static int getSpeedLeft(){
        return racerThreeSeventy.getSpeed();
    }
    public static int getSpeedRight(){
        return racerBeeEmW.getSpeed();
    }
    private void scrollLaneOne(){
        for(int i = 0; i < laneMarkersOneArray.length; i++){
            if(laneMarkersOneArray[i].getX() <= -laneMarkersOneArray[i].getImage().getWidth()){
                laneMarkersOneArray[i].setLocation((5*laneMarkersOneArray[i].getImage().getWidth() - 2 - 110), laneMarkersOneArray[i].getY());
            }
            laneMarkersOneArray[i].move(-racerThreeSeventy.getSpeed());
        }
    }
    private void scrollLaneTwo(){
        for(int i = 0; i < laneMarkersTwoArray.length; i++){
            if(laneMarkersTwoArray[i].getX() <= X_RESOLUTION/2 - laneMarkersTwoArray[i].getImage().getWidth()/2 + 90){
                laneMarkersTwoArray[i].setLocation((5*laneMarkersTwoArray[i].getImage().getWidth() - 2 + 90 + X_RESOLUTION/2), laneMarkersTwoArray[i].getY());
            }
            laneMarkersTwoArray[i].move(-racerBeeEmW.getSpeed());
        }
    }
    private void spawnNPC(){
        if(Greenfoot.getRandomNumber(50) == 0){
            int lane = Greenfoot.getRandomNumber(4);
            left.addObject(new VehicleLeft(), 680, 275 + 79*(lane));
            right.addObject(new VehicleRight(), 680 + (racerThreeSeventy.getX() - racerCloneLeft.getX()), 275 + 79*(lane));
        }
    }
    private void removeNPC(){
        List<Vehicle> vehicle = new ArrayList<Vehicle>();
        for (Object obj : getObjects(Vehicle.class)) vehicle.add((Vehicle)obj);
        for(Vehicle v: vehicle){
            if(v.getClass() == VehicleLeft.class && v.getX() < -10){
                removeObject(v);
            }
            else if(v.getClass() == VehicleRight.class && v.getX() < 580){
                removeObject(v);
            }
        }
    }
    public void act(){
        music.playLoop();
        threeSeventy.playLoop();
        beeEmW.playLoop();
        spawnNPC();
        removeNPC();
        scrollLaneOne();
        scrollLaneTwo();
        timeText.setValue(60 - timer.millisElapsed()/1000);
        if(timer.millisElapsed() > 60*1000){
            if(racerThreeSeventy.getX() - racerCloneLeft.getX() > 0){
                winner = true;
            }
            else{
                winner = false;
            }
            //winner true means threeseventy won
            //winner false means BMW won
            EndWorld  w = new EndWorld(winner);
            Greenfoot.setWorld(w);
        }
    }
    public MouseInfo getMouseInfo() {
        if (m == null){
              m = Greenfoot.getMouseInfo();
        }
        return m;
    }
    public void stopped(){
        threeSeventy.stop();
        beeEmW.stop();
        music.stop();
    }
}
