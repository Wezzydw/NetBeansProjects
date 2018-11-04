import greenfoot.*;

public class IntroWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;

    /**
     * Constructor for objects of class IntroWorld.
     */
    public IntroWorld()
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 
        GreenfootImage background = getBackground();
        background.setColor(Color.WHITE);
        allText();
    }
    
    public void allText()
    {
        showText("PONG GAME", getWidth()/2, getHeight()/2-250);
        showText("Hit 'enter' to start the game", getWidth()/2, getHeight()/2-200);
        showText("Controls", getWidth()/2, getHeight()/2+50);
        showText("LEFT - Moves the paddle left", getWidth()/2, getHeight()/2+75);
        showText("RIGHT - Moves the paddle right", getWidth()/2, getHeight()/2+100);
        showText("Instructions", getWidth()/2, getHeight()/2-100);
        showText("Hit the ball before it", getWidth()/2, getHeight()/2-75);
        showText("touches the floor", getWidth()/2, getHeight()/2-50);
    }
    
    public void act()
    {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            Greenfoot.setWorld(new PingWorld(true));
        }
    }
    
}
