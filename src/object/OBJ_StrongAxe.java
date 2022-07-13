package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Strong Axe.
 * This class inherits the Entity Class.
 * @author mrish
 *
 */
public class OBJ_StrongAxe extends Entity{
	
	public OBJ_StrongAxe(GamePanel gp) {
		super(gp);
		
		type = type_axe;
		name = "Fighter's Axe";
		down1 = setup("/objects/strongaxe",gp.tileSize,gp.tileSize);
		attackValue = 4;
		attackArea.width = 30;
		attackArea.height = 30;
		description = "Fighter's axe\nSharp and strong\ncan definitely kill";
	}

}
