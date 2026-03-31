import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pengu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pengu extends Actor
{
    private int speed = 7;
    private int vSpeed = 0;
    private int acceleration = 2;
    private int jumpstrength = 12;
    private int score;
    private int time;
    /**
     *  Act - do whatever the Iceberg wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * Check keyboard input and act accordingly
     */
    public void act() 
    {
        checkKeys();
        checkFall();
        fall();
        CheckCollision();
    }  

    public void checkFall()
    {
        if(onIceberg()) {
            vSpeed = 0;
        }
        if(onGrass()){
            Greenfoot.playSound("opps.wav");
            Greenfoot.playSound("game-over.wav");
            
        }
    }

    public boolean onIceberg()
    {
        Actor under = getOneObjectAtOffset ( 0,getImage(). getHeight() / 2, Iceberg.class);
        return under !=null;
    }
    

     public boolean onGrass()
    {
        Actor under = getOneObjectAtOffset ( 0,getImage(). getHeight() / 2, Grass.class);
        return under !=null;
    }
    
    public void fall()
    {
        setLocation ( getX(), getY() + vSpeed);   
        vSpeed = vSpeed + acceleration;
    }

    public void checkKeys()
    {
        if (Greenfoot.isKeyDown("left") )
        {
            move(-5);
        }
        if (Greenfoot.isKeyDown("right") )
        {
            move(5);
        }
        if (Greenfoot.isKeyDown("space") )
        {
            jump();
        }
    }

    public void jump()
    {
        vSpeed = -jumpstrength;
        fall();
    }

    public void moveRight()
    {
        setLocation (getX() + speed, getY() );
    }

    public void moveLeft()
    {
        setLocation (getX() + speed, getY() );
    }

    /**
     * Check whether Food was eaten
     */
    public void CheckCollision()
    {
        if ( isTouching(Food.class) )
        {
           
            Greenfoot.playSound("slurp.wav");
            IcebergWorld icebergWorld = (IcebergWorld)getWorld();
            icebergWorld.addScore(+25);
             removeTouching(Food.class);
        }
    }
}  
