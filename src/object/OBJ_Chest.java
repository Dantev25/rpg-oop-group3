package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Chest.
 * This class inherits the Entity Class.
 * @author Sadiyah
 * @author mrish
 *
 */
public class OBJ_Chest extends Entity{
	
	GamePanel gp;
	Entity loot;
	boolean opened = false;
	/**
	 * constructor for chest
	 * @param gp - gamepanel
	 * @param loot - contained loot inside the chest
	 */
	public OBJ_Chest(GamePanel gp, Entity loot) {
		super(gp);
		this.gp = gp;
		this.loot = loot;
		
		type = type_obstacle;
		name = "Chest";
		image = setup("/objects/chest", gp.tileSize, gp.tileSize);
		image2 = setup("/objects/chest_opened", gp.tileSize, gp.tileSize);
		down1 = image;
		collision = true;
		
		solidArea.x = 4;
		solidArea.y = 16;
		solidArea.width = 40;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}
	/**
	 * method to allow interaction with a chest
	 */
	public void interact() {
		gp.gameState = gp.dialogueState;
		if(opened == false) {
			gp.playSE(3);
			
			StringBuilder sb = new StringBuilder();
			sb.append("You open the chest and find a " + loot.name + "!");
			
			if(gp.player.inventory.size() == gp.player.maxInventorySize) {
				sb.append("\n...But you cannot carry any more!");
			}
			else {
				sb.append("\nYou obtain the " + loot.name + "!");
				gp.player.inventory.add(loot);
				down1 = image2;
				opened = true;
			}
			gp.ui.currentDialogue = sb.toString();
		}
		else {
			gp.ui.currentDialogue = "It is empty!";
		}
	}
}
