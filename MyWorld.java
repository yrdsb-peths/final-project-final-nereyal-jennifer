import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);

        GreenfootImage bg = new GreenfootImage("images/background.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);

        Person person = new Person();
        addObject(person, 150, 300);
        
        Reward reward = new Reward();
        addObject(reward, 500, 150);
        Wall1 wall = new Wall1();
        addObject(wall, 567, 225);
        
        Tree tree = new Tree();
        addObject(tree, 500, 300);

    }
}
