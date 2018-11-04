import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int width;
    private int height;

    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("RIGHT"))
        {
            move(2);
        }
        
        if(Greenfoot.isKeyDown("LEFT"))
        {
            move(-2);
        }
    }
    
    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Player(int width, int height)
    {
        this.width = width;
        this.height = height;
        createImage();
    }

    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.WHITE);
        image.fill();
        setImage(image);
    }

}
