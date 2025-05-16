import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
<<<<<<< HEAD
        GreenfootImage bg = new GreenfootImage("images/background.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
=======
        Person person = new Person();
        addObject(person, 150, 250);
>>>>>>> 0963e10865510179ffaad7956475c65e7db70afa
    }
}
