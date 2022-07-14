package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Key.
 * This class inherits the Entity Class.
 * @author mrish
 * @author Sadiyah
 */
public class OBJ_Key extends Entity{
	
	GamePanel gp;
	/**
	 * constructor for item key
	 * @param gp
	 */
	public OBJ_Key(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_consumable;
		name = "Key";
		down1 = setup("/objects/key", gp.tileSize, gp.tileSize);
		description = "[" + name + "]\nIt opens the door.";
		
	}
	/**
	 * method allowing player to use the key on a door
	 * @param entity player using the key
	 */
	public boolean use(Entity entity) {
		gp.gameState = gp.dialogueState;
		
		int objIndex = getDetected(entity, gp.obj, "Door");
		
		if(objIndex != 999) {
			gp.ui.currentDialogue = "You use the " + name + " and open the door.";
			gp.playSE(3);
			gp.obj[objIndex] = null;
			return true;
		}
		else {
			gp.ui.currentDialogue = "What are you doing?";
			return false;
		}
	}
}
