package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Boots.
 * This class inherits the Entity Class.
 * @author mrish
 *
 */
public class OBJ_Boots extends Entity{
	
	public OBJ_Boots(GamePanel gp) {
		super(gp);
		
		name = "Boots";
		down1 = setup("/objects/boots", gp.tileSize, gp.tileSize);
				
	}
}
