import greenfoot.*;


/**
 * The Ping World is where Balls and Paddles meet to play pong.
 * 
 * @author The teachers 
 * @version 1
 */
public class PingWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    private Score scoreActor;

    public PingWorld()
    { 
        // calling the other constructor with gameStarted = false.
        this(false);       
    }
    
    
    /**
     * Constructor for objects of class PingWorld.
     */
    public PingWorld(boolean gameStarted)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 
        if (gameStarted)
        {
            GreenfootImage background = getBackground();
            background.setColor(Color.WHITE);
            scoreActor = new Score();
            // a new world with WORLD_WIDTHxWORLD_HEIGHT cells with a cell size of 1x1 pixels.
            addObject(scoreActor, WORLD_WIDTH/2, WORLD_HEIGHT/2);
            addObject(new Ball(scoreActor), WORLD_WIDTH/2, WORLD_HEIGHT/2);
            addObject(new Paddle(100,20), 60, WORLD_HEIGHT - 650);
            addObject(new Player(100,20), 60, WORLD_HEIGHT - 50);
            
         
        }
        else
        {
            Greenfoot.setWorld(new IntroWorld());
        }
    }

}
