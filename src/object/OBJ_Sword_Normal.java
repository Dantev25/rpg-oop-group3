package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Normal Sword.
 * This class inherits the Entity Class.
 * @author mrish
 *
 */
public class OBJ_Sword_Normal extends Entity {
	/**
	 * constructor for weapon normal sword
	 * @param gp - gamepanel object
	 */
	public OBJ_Sword_Normal(GamePanel gp) {
		super(gp);
		
		type = type_sword;
		name = "Normal Sword";
		down1 = setup("/objects/sword_normal",gp.tileSize,gp.tileSize);
		attackValue = 3;
		attackArea.width = 36;
		attackArea.height = 36;
		description = "[" + name + "]\nAn old sword.";
		
	}

}
