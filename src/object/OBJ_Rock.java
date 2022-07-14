package object;

import java.awt.Color;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;
/**
 * This class implements the object Rock.
 * This class inherits the Entity Class.
 * @author Sadiyah
 *
 */
public class OBJ_Rock extends Projectile{
	
	GamePanel gp;

	/**
	 * constructor for projectile rock
	 * @param gp - gamepanel
	 */
	public OBJ_Rock(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = "Rock";
		speed = 8;
		maxLife = 30;
		life = maxLife;
		attack = 6;
		useCost = 1;
		alive = false;
		getImage();
	}
	
	/**
	 * method to get image of rock
	 */
	public void getImage() {
		up1 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
		up2 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
	    down1 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
		left1 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
		left2 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
		right1 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
		right2 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
	}
	/**
	 * method to check if entity has enough resource to use rock attack
	 * @param user monster using rock
	 * @return true if user has enough resources
	 */
    public boolean haveResource(Entity user) {
		
		boolean haveResource = false;
		if(user.ammo >= useCost) {
			haveResource = true;
		}
		return haveResource;
	}
    /**
	 * method to decrease ammo when using rock attack
	 * @param user monster using rock
	 */
	public void subtractResource(Entity user) {
		user.ammo -= useCost;
	}
	/**
	 * method to get particle color of rock
	 */
	public Color getParticleColor() {
		Color color = new Color(40,50,0);
		return color;
	}
	/**
	 * method to get particle size of rock
	 */
	public int getParticleSize() {
		int size = 10; // 6 pixels
		return size;
	}
	/**
	 * method to get particle speed of rock
	 */
	public int getParticleSpeed() {
		int speed = 1;
		return speed;
	}
	/**
	 * method to get particle maxLife of rock
	 */
	public int getParticleMaxLife() {
		int maxLife = 20;
		return maxLife;
	}


}
