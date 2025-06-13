import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * OldLady is a guide character who gives instructions and feedback
 * as the grandma
 * using dialogue boxes in 3 separate world states
 * She interacts with the player when nearby and progresses dialogue
 * with the ENTER key
 * 
 * Used in:
 * TitleScreen
 * BetweenTwoWorld1
 * BetweenTwoWorld2
 * 
 * Dialogue changes depending on the current world
 * 
 * @author Jennifer
 * @version June 2025
 */
public class OldLady extends Actor
{
    //Dialogue arrays for different worlds
    private String[] dialogues1 = {"Hello my dear.", "Thank you for getting here quickly.", "I am not feeling well.", "But you can help me!",
                                    "We're going to make my famous bowl.", 
                                    "It'll use mushrooms and basil.", "Collect 10 mushrooms \njumping over rocks (up key) \n and attacking eagles (space bar).", "Then, run right & left for falling basil.", "I'll guide you my dear.", "Click space to start!"};
    
    private String[] dialogues2 = {"Great job, most people die there.", "Now, just collect 10 basils from the sky!", "Use the arrow keys to move.", "Click space to start!"};
    
    private String[] dialogues3 = {"You did it!", "I knew you could.", "Now, it's time to eat!"};
    
    //keeps track of current dialogue line
    private int currentDialogueIndex = -1;
    
    // true if player is near the old lady
    private boolean isNearPerson = false;
    
    //used to prevent multiple ENTER reads
    private boolean enterPressed = false;
    
    //the current dialogue box o screen
    private int dialogueIndex = 0;
    private DialogueBox dialogueBox;
    
    /**
     * Constructor sets teh old lady's image and scales it
     */
    public OldLady()
    {
        setImage("old lady.png");
        getImage().scale(40, 80);
    }

    /**
     * Act checks the proximity to player, handles dialogue, 
     * keeps dialogue box positioned
     */
    public void act() {
        checkProximity();
        handleDialogueInput();
        updateDialogueBoxPosition();
    }
    
    /**
     * Checks if the player is close enough to trigger dialogue
     * starts dialogue whne distance <120 pixels
     */

    private void checkProximity() {
        //gets person's location
        Person person = (Person) getWorld().getObjects(Person.class).get(0);
        
        //checks if person is there and is near the position
        if (person != null && !isNearPerson) {
            //Math.hypot and distance variable concept from Greenfoot guide page
            int distance = (int)Math.hypot(getX() - person.getX(), getY() - person.getY());
            if (distance < 120) {
                isNearPerson = true;
                currentDialogueIndex = 0;
                showDialogue();
            }
        }
    }
    
    /**
     * Handles dialogue box progression when ENTER key is pressed
     * It checks the current world ot select the right dialogue array
     */
    private void handleDialogueInput() {
        World currentWorld = getWorld();
        if (currentWorld instanceof TitleScreen){
            if (isNearPerson && Greenfoot.isKeyDown("enter")) {
                if (!enterPressed) {
                    currentDialogueIndex++;
                    
                    //choose correct dialogue array based on world 
                    if (currentDialogueIndex < dialogues1.length) {
                        showDialogue();
                    } 
                    else {
                        removeDialogue();
                        isNearPerson = false;
                        currentDialogueIndex = -1;
                    }
                    //prevent repeated advancing when enter pressed
                    enterPressed = true;
                }   
            } 
            //reset when enter is released
            else if (!Greenfoot.isKeyDown("enter")) {
                enterPressed = false;
            }   
        }
        
        else if (currentWorld instanceof BetweenTwoWorld1){
            if (isNearPerson && Greenfoot.isKeyDown("enter")) {
                if (!enterPressed) {
                    currentDialogueIndex++;
                    if (currentDialogueIndex < dialogues2.length) {
                        showDialogue();
                    } 
                    else {
                        removeDialogue();
                        isNearPerson = false;
                        currentDialogueIndex = -1;
                    }
                    enterPressed = true;
                }
            } 
            else if (!Greenfoot.isKeyDown("enter")) {
                enterPressed = false;
            }
        }
        else if (currentWorld instanceof BetweenTwoWorld2){
            if (isNearPerson && Greenfoot.isKeyDown("enter")) {
                if (!enterPressed) {
                    currentDialogueIndex++;
                    if (currentDialogueIndex < dialogues3.length) {
                        showDialogue();
                    } 
                    else {
                        removeDialogue();
                        isNearPerson = false;
                        currentDialogueIndex = -1;
                    }
                    enterPressed = true;
                }
            } 
            else if (!Greenfoot.isKeyDown("enter")) {
                enterPressed = false;
            }
        }
        
    }
    
    /**
     * Displays or updates the dialogue box depending on the world and 
     * current line
     */
    private void showDialogue() {
        World currentWorld = getWorld();
        
        //determine which line based on current world
        if (currentWorld instanceof TitleScreen){
            if (dialogueBox == null) {
            dialogueBox = new DialogueBox(dialogues1[currentDialogueIndex]);
            getWorld().addObject(dialogueBox, getX() + 100, getY() - 60);
            } 
            else {
                dialogueBox.setText(dialogues1[currentDialogueIndex]);
            }
        }
        
        else if (currentWorld instanceof BetweenTwoWorld1){
            if (dialogueBox == null) {
                //create new dialogue box if one doesn't exist yet
                dialogueBox = new DialogueBox(dialogues2[currentDialogueIndex]);
                getWorld().addObject(dialogueBox, getX() + 100, getY() - 60);
            } 
            else {
                //update existing dialogue box text
                dialogueBox.setText(dialogues2[currentDialogueIndex]);
            }
        }
        else if (currentWorld instanceof BetweenTwoWorld2){
            if (dialogueBox == null) {
                dialogueBox = new DialogueBox(dialogues3[currentDialogueIndex]);
                getWorld().addObject(dialogueBox, getX() + 100, getY() - 60);
            } 
            else {
                dialogueBox.setText(dialogues3[currentDialogueIndex]);
            }
        }
        
    }      
    
    /**
     * removes the dialogue box from the world and resets reference
     */
    private void removeDialogue() {
        if (dialogueBox != null) {
            getWorld().removeObject(dialogueBox);
            dialogueBox = null;
        }
    }

    /**
     * keeps dialogue box positioned near old lady
     */
    private void updateDialogueBoxPosition() {
        if (dialogueBox != null) {
            dialogueBox.setLocation(getX() + 100, getY() - 60);
        }
    }
}
