package entity;

import java.util.Random;

import main.GamePanel;
/**
 * This class implements the non-player character old man.
 * This class inherits the Entity class.
 * @author Oomar
 *
 */
public class NPC_Oldman extends Entity{

	public NPC_Oldman(GamePanel gp) {
		super(gp);
		direction = "down";
		speed = 1;
		
		getImage();
		setDialogue();
	}
	/**
	 * This loads non-player character old man image.
	 */
	public void getImage() {
		
		up1 = setup("/npc/oldman_up_1", gp.tileSize, gp.tileSize); 
		up2 = setup("/npc/oldman_up_2", gp.tileSize, gp.tileSize);
		down1 = setup("/npc/oldman_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/npc/oldman_down_2", gp.tileSize, gp.tileSize);
		right1 = setup("/npc/oldman_right_1", gp.tileSize, gp.tileSize);
		right2 = setup("/npc/oldman_right_2", gp.tileSize, gp.tileSize);
		left1 = setup("/npc/oldman_left_1", gp.tileSize, gp.tileSize);
		left2 = setup("/npc/oldman_left_2", gp.tileSize, gp.tileSize);
	}
	/**
	 * This sets non-player character old man dialogues.
	 */
	public void setDialogue() {
		
		dialogues[0] = "Hello boy. ";
		dialogues[1] = "So, You've come to this island \nto find treasure?";
		dialogues[2] = "I used to be a great wizard \nbut now...\nI'm a bit too old for adventuring";
		dialogues[3] = "Well then, goodluck to you!";
		
		
	}
	
	/**
	 * This generates non-player character old man random movements.
	 */
	public void setAction() {
		
		actionLockCounter++;
		
		
		if(actionLockCounter == 120) {
			Random random =  new Random();
			int i = random.nextInt(100) + 1; //RANDOM NUMBER FROM 1-100
			
			if (i <= 25) {
				direction = "up";
			}
			if (i > 25 && i <= 50) {
				direction = "down";
			}
			if (i > 50 && i <= 75) {
				direction = "left";
			}
			if (i > 75 && i <= 100) {
				direction = "right";
			}
			actionLockCounter = 0;
		}
		
	}
	/**
	 * This method allows non-player character old man to speak to player.
	 */
	public void speak() {
		
		super.speak();
	}
	
}










