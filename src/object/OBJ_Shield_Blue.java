package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Blue Shield.
 * This class inherits the Entity Class.
 * @author Sadiyah
 *
 */
public class OBJ_Shield_Blue extends Entity {
	/**
	 * constructor for shield blue shield
	 * @param gp gamepanel object
	 */
	public OBJ_Shield_Blue(GamePanel gp) {
		super(gp);
		
		type = type_shield;
		name = "Blue Shield";
		down1 = setup("/objects/shield_blue",gp.tileSize,gp.tileSize);
		defenseValue = 2;
		description = "[" + name + "]\nShiny blue shield.";
		
	}

}
