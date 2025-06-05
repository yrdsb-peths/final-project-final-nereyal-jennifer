import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    public String text;
    public GreenfootImage image;
    public int width = 150;
    public int height = 80;
    
    public TextBox(String text){
        this.text = text;
        
    }
    private void createImage() {
        
        image = new GreenfootImage(width, height);
        image.setColor(new Color(255, 253, 208)); 
        image.fill();
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, width-1, height-1); 
        
        
        image.setFont(new Font("Monaco", false, false, 14));
        image.setColor(Color.BLACK);
        
        // 绘制文字 (自动换行)
        String[] words = text.split("");
        int yPos = 25;
        String line = "";
        
        for (String word : words) {
            if (image.getFont().getSize() * (line.length() + word.length()) < width - 20) {
                line += word;
            } else {
                image.drawString(line, 15, yPos);
                yPos += 20;
                line = word;
            }
        }
        image.drawString(line, 15, yPos);
        
        setImage(image);
    }
    
    public void updateText(String newText) {
        this.text = newText;
        createImage(); 
    }
    public void act()
    {
        // Add your action code here.
    }
}
