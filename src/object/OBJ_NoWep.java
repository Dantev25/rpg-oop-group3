package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object No Weapon.
 * This class inherits the Entity Class.
 * @author Oomar
 *
 */
public class OBJ_NoWep extends Entity{
	/**
	 * constructor for no weapon
	 * @param gp - gamepanel
	 */
	public OBJ_NoWep(GamePanel gp){
		super(gp);
		
		type = type_nowep;
		name = "No Weapon";
		down1 = setup("/objects/nowep",gp.tileSize,gp.tileSize);
		attackValue = 0;
		attackArea.width = 0;
		attackArea.height = 0;
		description = "No weapon equipped";
	}
}
