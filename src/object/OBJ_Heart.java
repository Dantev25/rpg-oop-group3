package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Heart.
 * This class inherits the Entity Class.
 * @author Sadiyah
 *
 */
public class OBJ_Heart extends Entity{
	
	GamePanel gp;
	/**
	 * constructor for item heart
	 * @param gp gamepanel
	 */
	public OBJ_Heart(GamePanel gp) {
		super(gp);
		this.gp = gp;
	
		type = type_pickupOnly;
		name = "Heart";
		value = 2;
		down1 = setup("/objects/heart_full", gp.tileSize/2, gp.tileSize/2);
		image = setup("/objects/heart_full", gp.tileSize/2, gp.tileSize/2);
		image2 = setup("/objects/heart_half", gp.tileSize/2, gp.tileSize/2);
		image3 = setup("/objects/heart_blank", gp.tileSize/2, gp.tileSize/2);
		
	}
	/**
	 * method to increment playerlife when picking up a heart
	 */
	public boolean use(Entity entity) {
		
		gp.playSE(2);
		gp.ui.addMessage("Life +" + value);
		entity.life += value;
		return true;
	}
}
