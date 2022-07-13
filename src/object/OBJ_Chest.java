package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Chest.
 * This class inherits the Entity Class.
 * @author mrish
 *
 */
public class OBJ_Chest extends Entity{
	
	public OBJ_Chest(GamePanel gp) {
		super(gp);
		
		name = "Chest";
		down1 = setup("/objects/chest", gp.tileSize, gp.tileSize);
	}
}
