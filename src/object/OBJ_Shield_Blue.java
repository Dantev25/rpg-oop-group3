package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Blue Shield.
 * @author mrish
 *
 */
public class OBJ_Shield_Blue extends Entity {
	
	public OBJ_Shield_Blue(GamePanel gp) {
		super(gp);
		
		type = type_shield;
		name = "Blue Shield";
		down1 = setup("/objects/shield_blue",gp.tileSize,gp.tileSize);
		defenseValue = 2;
		description = "[" + name + "]\nShiny blue shield.";
		
	}

}
