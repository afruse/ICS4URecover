import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class gifIntroWorldBackground extends Actor {
    
    private List<GreenfootImage> images;
    private int currentImageIndex;
    private int actCount;
    
    public gifIntroWorldBackground() {
        images = new ArrayList<GreenfootImage>();
        // Load all images from the "introworldbackground.gif" animation
        GifImage gif = new GifImage("images/backgroundintroworld.gif");
        images = gif.getImages();
        currentImageIndex = 0;
        actCount = 0;
    }
    public GreenfootImage getImage(){
        return images.get(0);
    }
    
    public void act() {
        if (actCount % 7 == 0) {
            // Change image every 7 acts
            getWorld().setBackground(images.get(currentImageIndex));
            currentImageIndex++;
            if (currentImageIndex >= images.size()) {
                currentImageIndex = 0;
            }
        }
        actCount++;
    }
}
