package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Strong Axe.
 * This class inherits the Entity Class.
 * @author Oomar
 *
 */
public class OBJ_StrongAxe extends Entity{
	/**
	 * constructor for weapon strong axe
	 * @param gp
	 */
	public OBJ_StrongAxe(GamePanel gp) {
		super(gp);
		
		type = type_axe;
		name = "Strong Axe";
		down1 = setup("/objects/strongaxe",gp.tileSize,gp.tileSize);
		attackValue = 2;
		attackArea.width = 30;
		attackArea.height = 30;
		description = "Fighter's axe\nSharp and strong\ncan definitely kill";
	}

}
