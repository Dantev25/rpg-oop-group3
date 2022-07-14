package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Mana Crystal.
 * This class inherits the Entity Class.
 * @author Sadiyah
 *
 */
public class OBJ_ManaCrystal extends Entity{
	
	GamePanel gp;
	/**
	 * constructor for mana crystal item
	 * @param gp gamepanel
	 */
	public OBJ_ManaCrystal(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickupOnly;
		name = "Mana Crystal";
		value = 1;
		down1 = setup("/objects/manacrystal_full",32,32);
		image = setup("/objects/manacrystal_full",32,32);
		image2 = setup("/objects/manacrystal_blank",32,32);
		
	}
	/**
	 * method to increment mana when pickup mana crystal
	 */
    public boolean use(Entity entity) {
		
		gp.playSE(2);
		gp.ui.addMessage("Mana +" + value);
		entity.mana += value;
		return true;
	}

}
