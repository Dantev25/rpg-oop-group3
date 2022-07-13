package object;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the object Mana Crystal.
 * @author mrish
 *
 */
public class OBJ_ManaCrystal extends Entity{
	
	GamePanel gp;
	
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
	
    public void use(Entity entity) {
		
		gp.playSE(2);
		gp.ui.addMessage("Mana +" + value);
		entity.mana += value;
	}

}
