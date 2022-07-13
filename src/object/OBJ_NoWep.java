package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_NoWep extends Entity{
	public OBJ_NoWep(GamePanel gp){
		super(gp);
		
		type = type_nowep;
		name = "No Weapon";
		down1 = setup("/objects/nowep",gp.tileSize,gp.tileSize);
		attackValue = 0;
		attackArea.width = 0;
		attackArea.height = 0;
		description = "No weapon equipped";
	}
}