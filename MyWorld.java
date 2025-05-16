import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);

        GreenfootImage bg = new GreenfootImage("images/background.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);

        Person person = new Person();
        addObject(person, 150, 250);
        Haystack haystack = new Haystack();
        addObject(haystack, 500, 267);

    }
}
