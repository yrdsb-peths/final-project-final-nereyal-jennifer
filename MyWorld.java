import greenfoot.*;

public class MyWorld extends World {
    public int score =0;
    Label scoreLabel;
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
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);

    }
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
}
