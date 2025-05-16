import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        Person person = new Person();
        addObject(person, 150, 250);
    }
}
