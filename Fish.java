import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish extends Actor
{
    /**
     * Act - do whatever the Fish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound FishSound = new GreenfootSound("fisheat.mp3");
    GreenfootImage[] idle = new GreenfootImage[10];
    
    public Fish(){
        for(int i = 0; i < idle.length; i++){
            idle[i] = new GreenfootImage("images/fish_idle/idle" + i + ".png");
        }
        setImage(idle[0]);
    }
    
    int imageIndex = 0;
    public void animateFish(){
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("d")){
            move(2);
        }
        if(Greenfoot.isKeyDown("a")){
            move(-2);
        }
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - 2);
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 2);
        }
        if(Greenfoot.isKeyDown("left")){
            move(-2);
        }
        if(Greenfoot.isKeyDown("right")){
            move(2);
        }
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY() - 2);
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY() + 2);
        }
        
        eat();
        
        animateFish();
    }
    public void eat(){
        if(isTouching(Fries.class)){
            removeTouching(Fries.class);
            MyWorld world = (MyWorld) getWorld();
            world.createFries();
            world.increaseScore();
            FishSound.play();
        }
        
    }
}
