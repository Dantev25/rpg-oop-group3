package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Key.
 * @author mrish
 *
 */
public class OBJ_Key extends Entity{
	
	public OBJ_Key(GamePanel gp) {
		super(gp);
		
		name = "Key";
		down1 = setup("/objects/key", gp.tileSize, gp.tileSize);
		description = "[" + name + "]\nIt opens the door.";
		
		
	}
}
