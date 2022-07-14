package entity;

import main.GamePanel;

/**
 * This class implements the projectile.
 * This class inherits the Entity class.
 * @author Sadiyah
 *
 */

public class Projectile extends Entity{
	
	Entity user;
	/**
	 * This constructs the class Projectile
	 * @param gp this game panel
	 */
	public Projectile(GamePanel gp) {
		super(gp);
		
	}
	/**
	 * setter for projectile object
	 * @param worldX x location
	 * @param worldY y location
	 * @param direction direction of movement of projectile
	 * @param alive if the projectile is still alive
	 * @param user the entity that sent the projectile
	 */
	public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
		
		this.worldX = worldX;
		this.worldY = worldY;
		this.direction = direction;
		this.alive = alive;
		this.user = user;
		this.life = this.maxLife;
	}
	/**
	 * this method updates the damage given to either monster or player, and 
	 * also takes care of the image to be displayed for projectile
	 */
	public void update() {
		
		if(user == gp.player) {
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			if(monsterIndex != 999) {
				gp.player.damageMonster(monsterIndex, attack);
				generateParticle(user.projectile, gp.monster[monsterIndex]);
				alive =  false;
			}
		}
		
		if(user != gp.player) {
			boolean contactPlayer = gp.cChecker.checkPlayer(this);
			if(gp.player.invincible == false && contactPlayer == true) {
				damagePlayer(attack);
				generateParticle(user.projectile, gp.player);
				alive = false;
			}
		}
		
		switch (direction) {
		case "up": worldY -= speed;break;
		case "down": worldY += speed;break;
		case "left": worldX -= speed;break;
		case "right": worldX += speed;break;
		}
		
		life--;
		if(life <= 0) {
			alive = false;
		}
		
		spriteCounter++;
		if(spriteCounter > 12) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	/**
	 * method to initialise user resource as false
	 * @param user entity using the projectile
	 * @return returns the user as having no resources
	 */
    public boolean haveResource(Entity user) {
		
		boolean haveResource = false;
		return haveResource;
	}
    /**
     * method to subtract resources from user's stack
     * @param user entity having the resource
     */
    public void subtractResource(Entity user) {
    	
	}

}
