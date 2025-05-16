import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
<<<<<<< HEAD

        GreenfootImage bg = new GreenfootImage("images/background.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);

        Person person = new Person();
        addObject(person, 150, 250);
        Haystack haystack = new Haystack();
        addObject(haystack, 500, 267);

=======
        GreenfootImage bg = new GreenfootImage("images/background.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        Person person = new Person();
        addObject(person, 150, 300);
        
        Reward reward = new Reward();
        addObject(reward, 500, 200);
>>>>>>> 1256018e988aaa429c0dacad4f0de9c6fe959d06
    }
}
