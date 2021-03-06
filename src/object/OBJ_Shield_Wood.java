package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Wooden Shield.
 * This class inherits the Entity Class.
 * @author mrish
 *
 */
public class OBJ_Shield_Wood extends Entity{
	/**
	 * constructor for shield wood shield
	 * @param gp gamepanel
	 */
	public OBJ_Shield_Wood(GamePanel gp) {
		super(gp);
		
		type = type_shield;
		name = "Wood Shield";
		down1 = setup("/objects/shield_wood",gp.tileSize,gp.tileSize);
		defenseValue = 1;
		description = "[" + name + "]\nMade by wood.";
		
	}

}
