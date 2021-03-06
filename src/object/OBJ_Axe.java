package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Axe.
 * This class inherits the Entity Class.
 * @author Sadiyah
 *
 */
public class OBJ_Axe extends Entity{
	/**
	 * constructor for weapon axe
	 * @param gp gamepanel
	 */
	public OBJ_Axe(GamePanel gp) {
		super(gp);
		
		type = type_axe;
		name = "Woodcutter's Axe";
		down1 = setup("/objects/axe",gp.tileSize,gp.tileSize);
		attackValue = 0;
		attackArea.width = 30;
		attackArea.height = 30;
		description = "[Woodcutter's Axe]\nA bit rusty but still \ncan cut some trees.";
	}

}
