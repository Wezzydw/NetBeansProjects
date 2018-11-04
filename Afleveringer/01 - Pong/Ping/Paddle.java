import greenfoot.*;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 * 
 * @author The teachers 
 * @version 1
 */
public class Paddle extends Actor
{
    private int width;
    private int height;
    private int dx;
    private boolean delete = false;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Paddle(int width, int height)
    {
        this.width = width;
        this.height = height;
        dx = 1;
        createImage();
    }

    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        spawnDelete();
        if (delete == false)
        setLocation(getX() + dx, getY());
        
        if (delete == true)
            getWorld().removeObject(this);
    }    

    /**
     * Will rotate the paddle 180 degrees if the paddle is at worlds edge.
     */
    private void spawnDelete()
    {
        if(getX() + width/2 >= getWorld().getWidth() || getX() - width/2 <= 0)
        {
            int randomx = 50 + (Greenfoot.getRandomNumber(500) - 50);
            int randomy = 25 + (Greenfoot.getRandomNumber(350) - 25);
            getWorld().addObject(new Paddle(100,20), randomx, randomy );
            delete = true;
        }
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
