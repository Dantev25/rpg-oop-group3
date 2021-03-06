package monster;

import java.util.Random;
import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Fireball;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
/**
 * This class implements the monster mage.
 * This class inherits the Entity class.
 * @author Oomar
 *
 */
public class MON_Mage extends Entity{
	GamePanel gp;
	/**
	 * constructor for mage
	 * @param gp gamepanel
	 */
	public MON_Mage(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_monster;
		name = "Mage";
		speed = 2;
		maxLife = 12;
		life = maxLife;
		attack = 8;
		defense = 1;
		exp = 15;
		projectile = new OBJ_Fireball(gp);
		projectile.attack = 10;
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 28;
		solidArea.height = 28;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
}
	/**
	 * This sets monster mage image.
	 */
	public void getImage() {
		
		up1 = setup("/monster/mage_up_1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/mage_up_2", gp.tileSize, gp.tileSize);
		down1 = setup("/monster/mage_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/mage_down_2", gp.tileSize, gp.tileSize);
		right1 = setup("/monster/mage_right_1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/mage_right_2", gp.tileSize, gp.tileSize);
		left1 = setup("/monster/mage_left_1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/mage_left_2", gp.tileSize, gp.tileSize);

		
	}
	/**
	 * This sets monster mage random movements.
	 */
	public void setAction() {
		actionLockCounter++;	
		
		
		if(actionLockCounter == 120) {
			Random random =  new Random();
			int i = random.nextInt(100) + 1; //RANDOM NUMBER FROM 1-100
			
			if (i <= 25) {
				direction = "up";
			}
			if (i > 25 && i <= 50) {
				direction = "down";
			}
			if (i > 50 && i <= 75) {
				direction = "left";
			}
			if (i > 75 && i <= 100) {
				direction = "right";
			}
			actionLockCounter = 0;
			
		}
		
		int i = new Random().nextInt(100) +1;
		if(i > 99 && projectile.alive == false && shotAvailableCounter == 30) {
			
			projectile.set(worldX, worldY, direction, true, this);
			gp.projectileList.add(projectile);
			shotAvailableCounter = 0;
		}
		
	}
	/**
	 * This sets monster mage damage reaction
	 */
	public void damageReaction () {
		
		actionLockCounter = 0;
		direction = gp.player.direction;
	}
	/**
	 * This generates monster mage random item drop when killed.
	 */
	public void checkDrop() {
		
		// CAST A DIE
		int i = new Random().nextInt(100)+1;
		
		// SET THE MONSTER DROP
		if(i<25) {
			dropItem(new OBJ_Coin_Bronze(gp));
		}
		
		if(i >= 25 && i < 60) {
			dropItem(new OBJ_Heart(gp));
		}
		
		if(i >= 60 && i < 100) {
			dropItem(new OBJ_ManaCrystal(gp));
		}
	}
	
}






