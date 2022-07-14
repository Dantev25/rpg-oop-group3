package object;

import java.awt.Color;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;
/**
 * This class implements the object Fireball.
 * This class inherits the Entity Class.
 * @author Sadiyah
 *
 */
public class OBJ_Fireball extends Projectile{
	
	GamePanel gp;

	/**
	 * constructor for projectile fireball
	 * @param gp - gamepanel
	 */
	public OBJ_Fireball(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = "Fireball";
		speed = 5;
		maxLife = 80;
		life = maxLife;
		attack = 3;
		useCost = 1;
		alive = false;
		getImage();
	}
	/**
	 * sets the image of fireball
	 */
	public void getImage() {
		up1 = setup("/projectile/fireball_up_1", gp.tileSize, gp.tileSize);
		up2 = setup("/projectile/fireball_up_2", gp.tileSize, gp.tileSize);
	    down1 = setup("/projectile/fireball_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/projectile/fireball_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/projectile/fireball_left_1", gp.tileSize, gp.tileSize);
		left2 = setup("/projectile/fireball_left_2", gp.tileSize, gp.tileSize);
		right1 = setup("/projectile/fireball_right_1", gp.tileSize, gp.tileSize);
		right2 = setup("/projectile/fireball_right_2", gp.tileSize, gp.tileSize);
	}
	/**
	 * check if user has resources necessary to use fireball
	 * @param user entity using fireball
	 * @return true if they have enough resources
	 */
	public boolean haveResource(Entity user) {
		
		boolean haveResource = false;
		if(user.mana >= useCost) {
			haveResource = true;
		}
		return haveResource;
	}
	/**
	 * subtracts mana from the user mana pool
	 */
	public void subtractResource(Entity user) {
		user.mana -= useCost;
	}
	/**
	 * gets the particle color of fireballs
	 */
	public Color getParticleColor() {
		Color color = new Color(240,50,0);
		return color;
	}
	/**
	 * gets the particle size of fireballs
	 */
	public int getParticleSize() {
		int size = 10; // 6 pixels
		return size;
	}
	/**
	 * gets the particle speed of fireballs
	 */
	public int getParticleSpeed() {
		int speed = 1;
		return speed;
	}
	/**
	 * gets the particle maxLife of fireballs
	 */
	public int getParticleMaxLife() {
		int maxLife = 20;
		return maxLife;
	}

}
