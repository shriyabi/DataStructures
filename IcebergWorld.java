import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * You control Pengu and you have to jump up and down using the arrows and the space bar (to jump up) to eat all the food and score 100 points before the time runs out. 
 * DON"T TOUCH THE GRASS!
 * If you don't reach 100 points and your time has ran out, you are still a winner.
 * You also have 350 milliseconds to eat all the food. HAVE FUN!!!!
 * @author (Shriya Biddala) 
 * @version (a version number or a date)
 */
public class IcebergWorld extends World
{
    private int score;
    private int time;
    /**
     * Constructor for objects of class IcebergWorld.
     * 
     */
    public IcebergWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        score=0;
        time=351;
        showScore();
        showTime();
        countTime();
    }

    /**
     * Create new floating objects at irregular intervals.
     */
    public void act()
    {
        countTime();
    }   

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Iceberg iceberg = new Iceberg();
        addObject(iceberg,137,160);
        Iceberg iceberg2 = new Iceberg();
        addObject(iceberg2,368,280);
        Pengu pengu = new Pengu();
        addObject(pengu,143,79);
        iceberg2.setLocation(319,277);
        Food food = new Food();
        addObject(food,324,239);
        Iceberg iceberg3 = new Iceberg();
        addObject(iceberg3,433,67);
        Iceberg iceberg4 = new Iceberg();
        addObject(iceberg4,141,346);
        Iceberg iceberg5 = new Iceberg();
        addObject(iceberg5,497,214);
        Food food2 = new Food();
        addObject(food2,438,37);
        Food food3 = new Food();
        addObject(food3,142,319);
        Grass grass = new Grass();
        addObject(grass,33,390);
        Grass grass2 = new Grass();
        addObject(grass2,199,390);
        Grass grass3 = new Grass();
        addObject(grass3,394,395);
        Grass grass4 = new Grass();
        addObject(grass4,324,398);
        Grass grass5 = new Grass();
        addObject(grass5,520,396);
        Grass grass6 = new Grass();
        addObject(grass6,589,395);
        Grass grass7 = new Grass();
        addObject(grass7,450,399);
        Grass grass8 = new Grass();
        addObject(grass8,490,397);
        Grass grass9 = new Grass();
        addObject(grass9,563,394);
        Grass grass10 = new Grass();
        addObject(grass10,366,389);
        Grass grass11 = new Grass();
        addObject(grass11,247,396);
        Grass grass12 = new Grass();
        addObject(grass12,293,397);
        Grass grass13 = new Grass();
        addObject(grass13,73,393);
        Grass grass14 = new Grass();
        addObject(grass14,133,395);
        Grass grass15 = new Grass();
        addObject(grass15,164,395);

        Grass grass16 = new Grass();
        Grass grass17 = new Grass();
        addObject(grass17,4,397);
        Grass grass18 = new Grass();
        addObject(grass18,102,393);
        Grass grass19 = new Grass();
        addObject(grass19,243,389);
        Grass grass20 = new Grass();
        addObject(grass20,431,399);
        iceberg3.setLocation(506,63);
        food2.setLocation(510,31);
        Iceberg iceberg6 = new Iceberg();
        addObject(iceberg6,326,95);
        iceberg3.setLocation(503,133);
        food2.setLocation(504,83);
        iceberg5.setLocation(452,210);
        Food food4 = new Food();
        addObject(food4,449,189);
        removeObject(food2);
        Food food5 = new Food();
        addObject(food5,324,56);
        iceberg3.setLocation(524,299);
        removeObject(iceberg5);
        food4.setLocation(528,276);
        removeObject(food);
        iceberg2.setLocation(474,227);
        iceberg3.setLocation(290,275);
        food4.setLocation(298,226);
        iceberg2.setLocation(500,167);
        iceberg3.setLocation(421,321);
        food4.setLocation(409,290);
        iceberg2.setLocation(397,207);
        iceberg2.setLocation(246,240);
        iceberg2.setLocation(274,232);
        iceberg3.setLocation(503,200);
        iceberg2.setLocation(292,266);
        food4.setLocation(503,164);
        iceberg2.setLocation(276,239);
        iceberg2.setLocation(269,255);
        Iceberg iceberg7 = new Iceberg();
        addObject(iceberg7,162,53);
        Food food6 = new Food();
        addObject(food6,154,15);
        iceberg6.setLocation(447,109);
        food5.setLocation(446,57);
        iceberg2.setLocation(312,251);
        iceberg3.setLocation(505,288);
        food4.setLocation(503,249);
        iceberg3.setLocation(490,206);
        food4.setLocation(500,166);
        iceberg2.setLocation(284,266);
        iceberg7.setLocation(279,67);
        iceberg6.setLocation(461,128);
        removeObject(iceberg2);
        iceberg3.setLocation(352,259);
        food4.setLocation(359,233);
        iceberg6.setLocation(508,196);
        food5.setLocation(519,161);
        iceberg3.setLocation(314,283);
        food4.setLocation(326,249);
        iceberg7.setLocation(404,63);
        food6.setLocation(439,28);
        iceberg7.setLocation(441,76);
        food6.setLocation(444,30);
    }

    private void countTime()
    {
        time--;
        showTime();
        if (time ==0)
        {
            showEndMessage();
            Greenfoot.stop();
        }    

    }

    private void showEndMessage()
    { 
        showText("Time is up! Your a winner! You final score is:" +score, 300, 200);
        Greenfoot.playSound("yea.wav");
    }

     private void showEndMessage2()
    { 
        showText("You ate all the food! You're a winner! You final score is:" +score, 300, 200);
         Greenfoot.playSound("yea.wav");
    }

    public void showScore()
    {
        showText("Score:" +score, 80, 25);
    }

    private void showTime()
    {
        showText("Time:" +time, 360, 15);
    }

    public void addScore(int points)
    {
        if (score >=0)
        {
            score = score + points;
            showScore();
            endGame();
        }
       
        else
        {
            Greenfoot.playSound("game-over.wav");
            Greenfoot.stop();
        }
    }
    
    public void endGame()
    {
        if (score==100)
        {
            
            Greenfoot.stop();
            showEndMessage2();
            
        }
    }
  
}

