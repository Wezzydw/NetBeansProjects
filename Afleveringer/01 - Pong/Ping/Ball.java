import greenfoot.*;


/**
 * A Ball is a thing that bounces of walls and paddles (or at least i should).
 * 
 * @author The teachers 
 * @version 1
 */
public class Ball extends Actor
{
    private static final int BALL_SIZE = 25;
    private static final int BOUNCE_DEVIANCE_MAX = 5;
    private static final int STARTING_ANGLE_WIDTH = 90;
    private static final int DELAY_TIME = 100;

    private int speed = 2;
    private boolean hasBouncedHorizontally;
    private boolean hasBouncedVertically;
    private int delay;
    private Score scoreActor;
    private int paddleCounter;
    private boolean movingDownwards = true;
    private boolean tællerOver10 = false;

    /**
     * Contructs the ball and sets it in motion!
     */
    public Ball(Score scoreActor)
    {
        createImage();
        init();
        this.scoreActor = scoreActor;
    }

    /**
     * Creates and sets an image of a black ball to this actor.
     */
    private void createImage()
    {
        GreenfootImage ballImage = new GreenfootImage(BALL_SIZE,BALL_SIZE);
        ballImage.setColor(Color.WHITE);
        ballImage.fillOval(0, 0, BALL_SIZE, BALL_SIZE);
        setImage(ballImage);
    }

    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (delay > 0)
        {
            delay--;
        }
        else
        {
            move(speed);
            checkBounceOffWalls();
            checkBounceOffCeiling();
            checkPaddle();
            checkPlayer();
            checkRestart();
            updateSpeed();  
        }
    }    
    
    /**
     * Updates speed of ball and update level in Score
     */
    private void updateSpeed()
    {
        if(tællerOver10 == false)
        {
            if(paddleCounter % 10 == 0 && paddleCounter != 0)
            {
                speed = 2 + (paddleCounter / 10); 
                scoreActor.updateLevel();
                tællerOver10 = true;
            }
            if(paddleCounter %10 != 0)
            tællerOver10 = false;
        }
    }
    
    /**
     * Checks if Ball has hit Paddle and forces a direction change.
     */
    public void checkPaddle()
    {
        Actor paddle = getOneObjectAtOffset(0,0,Paddle.class);
        if(paddle != null)
        {
            if(movingDownwards != true)
            {
                revertVertically();
                paddleCounter++;
                Greenfoot.playSound("pingpaddlesound.wav");
                movingDownwards = true; 
            }
        }
    }
    
    /**
     * Checks if Ball has hit Player and forces a direction change.
     */
    public void checkPlayer(){
        Actor player = getOneObjectAtOffset(0,0,Player.class);
        if (player != null)
        {
            if (movingDownwards != false)
            {
                revertVertically();
                Greenfoot.playSound("pingpaddlesound.wav");
                movingDownwards = false;
            }
        }
    }

    /**
     * Returns true if the ball is touching one of the side walls.
     */
    private boolean isTouchingSides()
    {
        return (getX() <= BALL_SIZE/2 || getX() >= getWorld().getWidth() - BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the ceiling.
     */
    private boolean isTouchingCeiling()
    {
        return (getY() <= BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the floor.
     */
    private boolean isTouchingFloor()
    { 
        return (getY() >= getWorld().getHeight() - BALL_SIZE/2);
    }

    /**
     * Check to see if the ball should bounce off one of the walls.
     * If touching one of the walls, the ball is bouncing off.
     */
    private void checkBounceOffWalls()
    {
        if(isTouchingSides())
        {
            if(! hasBouncedHorizontally)
            {
                revertHorizontally();
                Greenfoot.playSound("pingwallsound.wav");
            }
        }
        else
        {
            hasBouncedHorizontally = false;
        }
    }

    /**
     * Check to see if the ball should bounce off the ceiling.
     * If touching the ceiling the ball is bouncing off.
     */
    private void checkBounceOffCeiling()
    {
        if(isTouchingCeiling())
        {
            init();
            scoreActor.updateScorePlayer(1);
            setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.playSound("pingscoresound.wav");
        }
    }

    /**
     * Check to see if the ball should be restarted.
     * If touching the floor the ball is restarted in initial position and speed.
     */
    private void checkRestart()
    {
        if (isTouchingFloor())
        {
            scoreActor.updateScorePaddle(1);
            init();
            setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.playSound("pingscoresound.wav");
        }
    }

    /**
     * Bounces the ball back from a vertical surface.
     */
    private void revertHorizontally()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((180 - getRotation()+ randomness + 360) % 360);
        hasBouncedHorizontally = true;
    }

    /**
     * Bounces the bal back from a horizontal surface.
     */
    private void revertVertically()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((360 - getRotation()+ randomness + 360) % 360);
        hasBouncedVertically = true;
    }

    /**
     * Initialize the ball settings.
     */
    private void init()
    {
        delay = DELAY_TIME;
        hasBouncedHorizontally = false;
        hasBouncedVertically = false;
        movingDownwards = true;
        setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH)+STARTING_ANGLE_WIDTH/2);
    }
}
