package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;
/**
 * class entity defines all monsters, player characters and npc's characteristics, behaviors, actions and attributes
 * @author mrish
 * @author Oomar
 * @author Sadiyah
 */
public class Entity {
	
	GamePanel gp;
	/**
	 * Images of entity during movement
	 */
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	/**
	 * Images of entity during attack
	 */
	public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
	/**
	 * token Images of entity 
	 */
	public BufferedImage image, image2, image3;
	/**
	 * collision area 
	 */
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	/**
	 * attack area 
	 */
	public Rectangle attackArea = new Rectangle(0, 0, 0,0);
	/**
	 * default solid areas
	 */
	public int solidAreaDefaultX, solidAreaDefaultY;
	/**
	 * collision variable
	 */
	public boolean collision = false;
	/**
	 * string array containing dialogues
	 */
	String dialogues[] = new String[20];
	
	// STATE
	/**
	 * x and y locations
	 */
	public int worldX, worldY;
	/**
	 * initial direction of entity
	 */
	public String direction = "down";
	/**
	 * variable to count between image1 and 2 of entities actions
	 */
	public int spriteNum = 1;
	/**
	 * index counting dialogue
	 */
	int dialogueIndex = 0;
	/**
	 * variable to see if collision is happening
	 */
	public boolean collisionOn = false;
	/**
	 * variable to see if an entity is invisible
	 */
	public boolean invincible = false;
	/**
	 * variable to see if an entity is attacking
	 */
	boolean attacking = false;
	/**
	 * variable to see if an entity is alive
	 */
	public boolean alive = true;
	/**
	 * variable to see if an entity is dying
	 */
	public boolean dying = false;
	/**
	 * variable to see if an entity has his hp bar on
	 */
	public boolean hpBarOn = false;
	
	// COUNTER
	/**
	 * counter for sprites
	 */
	public int spriteCounter = 0;
	/**
	 * counter for action lock
	 */
	public int actionLockCounter = 0;
	/**
	 * counter for invincibility frames
	 */
	public int invincibleCounter = 0;
	/**
	 * counter for projectile shots available
	 */
	public int shotAvailableCounter = 0;
	/**
	 * counter for dying
	 */
	int dyingCounter = 0;
	/**
	 * counter for hp bar
	 */
	int hpBarCounter = 0;
	
	//CHARACTER ATTRIBUTES
	/**
	 * Entity name
	 */
	public String name;
	/**
	 * Entity maximum life
	 */
	public int maxLife;
	/**
	 * Entity current life
	 */
	public int life;
	/**
	 * Entity max mana
	 */
	public int maxMana;
	/**
	 * Entity current mana
	 */
	public int mana;
	/**
	 * Entity ammo
	 */
	public int ammo;
	/**
	 * Entity speed
	 */
	public int speed;
	/**
	 * Entity level
	 */
	public int level;
	/**
	 * Entity strength
	 */
	public int strength;
	/**
	 * Entity dexterity
	 */
	public int dexterity;
	/**
	 * Entity attack
	 */
	public int attack;
	/**
	 * Entity defense
	 */
	public int defense;
	/**
	 * Entity experience
	 */
	public int exp;
	/**
	 * Entity exp to reach next level
	 */
	public int nextLevelExp;
	/**
	 * Entity number of coins collected 
	 */
	public int coin;
	/**
	 * Entity's current weapon 
	 */
	public Entity currentWeapon;
	/**
	 * Entity's current shield
	 */
	public Entity currentShield;
	/**
	 * Entity's projectile 
	 */
	public Projectile projectile;
	
	// ITEM ATTRIBUTES
	public int value;
	public int attackValue;
	public int defenseValue;
	public String description = "";
	public int useCost;
	
	// TYPE
	public int type; //0 = player; 1 = npc; 2 = monster;
	public final int type_player = 0;
	public final int type_npc = 1;
	public final int type_monster = 2;
	public final int type_sword = 3;
	public final int type_axe = 4;
	public final int type_shield = 5;
	public final int type_consumable = 6;
	public final int type_pickupOnly = 7;
	public final int type_nowep = 8;
	public final int type_obstacle = 9;
	private int length;
	
	/**
	 * constructor for entity
	 * @param gp is the GamePanel used to run the game
	 */
 	public Entity (GamePanel gp) {
		this.gp = gp;
	}
 	/**
 	 * method to get location of left solid area of entity
 	 * @return location of edge of solid area
 	 */
 	public int getLeftX() {
 		return worldX + solidArea.x;
 	}
 	/**
 	 * method to get location of right solid area of entity
 	 * @return location of edge of solid area
 	 */
 	public int getRightX() {
 		return worldX +solidArea.x + solidArea.width;
 	}
 	/**
 	 * method to get location of top solid area of entity
 	 * @return location of edge of solid area
 	 */
 	public int getTopY() {
 		return worldY +solidArea.y;
 	}
 	/**
 	 * method to get location of bottom solid area of entity
 	 * @return location of edge of solid area
 	 */
 	public int getBottomY() {
 		return worldY +solidArea.y + solidArea.height;
 	}
 	/**
 	 * method to get X location of solid area of entity
 	 * @return location of edge of solid area
 	 */
 	public int getCol() {
 		return (worldX + solidArea.x)/gp.tileSize;
 	}
 	/**
 	 * method to get Y location of solid area of entity
 	 * @return location of edge of solid area
 	 */
 	public int getRow() {
 		return (worldY + solidArea.y)/gp.tileSize;
 	}
 	/**
 	 * superclass entity method to define actions of entities
 	 */
	public void setAction() {}
	/**
 	 * superclass entity method to define damage reactions of entities
 	 */
	public void damageReaction() {}
	/**
	 * handles speech with npc's
	 */
	public void speak() {
		
		if(dialogues[dialogueIndex] == null) {
			dialogueIndex = 0;
		}
		gp.ui.currentDialogue = dialogues[dialogueIndex];
		dialogueIndex++;
		
		switch (gp.player.direction) {
		case "up":
			direction = "down";
			
			break;
		case "right":
			direction = "left";
		case "down":
			direction = "up";
		case "left":
			direction = "right";
			
		default:
			break;
		}
	}
	
	public void interact() {
		
	}
	
	public boolean use(Entity entity) {
		return false;
	}
	
	public void checkDrop() {
		
	}
	/**
	 * method dropItem places an item in the place of a dead monster's body
	 * @param droppedItem is the dropped item
	 */
	public void dropItem(Entity droppedItem) {
		for (int i = 0;i<gp.obj.length;i++) {
			if(gp.obj[i] == null) {
				gp.obj[i] = droppedItem;
				gp.obj[i].worldX = worldX; // the dead monster's worldX
				gp.obj[i].worldY = worldY;
				break;
			}
		}
		
	}
	
	public Color getParticleColor() {
		Color color = null;
		return color;
	}
	
	/**
	 * This returns the particle size.
	 * @return this particle size.
	 */
	
	public int getParticleSize() {
		int size = 0; // 6 pixels
		return size;
	}
	
	/**
	 * This returns the particle speed.
	 * @return this particle speed.
	 */
	
	public int getParticleSpeed() {
		int speed = 0;
		return speed;
	}
	
	/**
	 * This returns the particle maximum life.
	 * @return this particle maximum life.
	 */
	
	public int getParticleMaxLife() {
		int maxLife = 0;
		return maxLife;
	}
	/**
	 * This method generates particles when attacking or receiving attacks.
	 * uses the class particle to instantiate objects particle, and  method add to add them to the gamepanel
	 */
	public void generateParticle(Entity generator, Entity target) {
		
		Color color = generator.getParticleColor();
		int size = generator.getParticleSize();
		int speed = generator.getParticleSpeed();
		int maxLife = generator.getParticleMaxLife();
		
		Particle p1 = new Particle(gp, target, color, size, speed, maxLife, -2, -1);
		Particle p2 = new Particle(gp, target, color, size, speed, maxLife, 2, -1);
		Particle p3 = new Particle(gp, target, color, size, speed, maxLife, -2, 1);
		Particle p4 = new Particle(gp, target, color, size, speed, maxLife, 2, 1);
		gp.particleList.add(p1);
		gp.particleList.add(p2);
		gp.particleList.add(p3);
		gp.particleList.add(p4);
	}
	/**
	 * This method uses collision checker, to check whether an entity is making contact with another
	 * no collision allows movement
	 */
	public void update() {
		
		setAction();
		
		collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this,false);
		gp.cChecker.checkEntity(this,gp.npc);
		gp.cChecker.checkEntity(this,gp.monster);
		gp.cChecker.checkEntity(this,gp.iTile);
		boolean contactPlayer = gp.cChecker.checkPlayer(this);
		
		
		if(this.type == type_monster && contactPlayer == true) {
			damagePlayer(attack);
		}
		// IF COLLISION IS FALSE PLAYER CAN MOVE
		if(collisionOn == false) {
						
			switch (direction) {
			case "up": worldY -= speed; break;
			case "down": worldY += speed; break;
			case "left": worldX -= speed; break;
			case "right": worldX += speed; break;
			}

		}
					
		spriteCounter++;
		if(spriteCounter > 15) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if (spriteNum == 2) {
				spriteNum = 1;	
			}
			spriteCounter = 0;
		}
		
		if (invincible == true) {
			invincibleCounter++;
			if(invincibleCounter>40) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
		
		if(shotAvailableCounter < 30) {
			shotAvailableCounter++;
		}
	}
	/**
	 * This method calculated damage given to a player
	 * @param attack is the attack of the entity attacking the player
	 */
	public void damagePlayer(int attack) {
		
		if (gp.player.invincible == false) {
			// We can give damage
			gp.playSE(6);
			int damage = attack -gp.player.defense;
			if(damage < 0) {
				damage = 0;
			}
			
			gp.player.life -= damage;
			gp.player.invincible = true;
			
		}
		
	}
	/**
	 * This uses the package Graphics2D to draw entity graphics onto the map
	 * @param g2 is the graphics object from class Graphics2D used to display graphics
	 */
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if (	worldX + gp.tileSize> gp.player.worldX - gp.player.screenX &&
				worldX - gp.tileSize< gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize> gp.player.worldY - gp.player.screenY && 
				worldY - gp.tileSize< gp.player.worldY + gp.player.screenY) {
					
			
			switch(direction) {
			case "up":
				if (spriteNum == 1) {image = up1;}
				if (spriteNum == 2) {image = up2;}
				break;
			case "down":
				if (spriteNum == 1) {image = down1;}
				if (spriteNum == 2) {image = down2;}
				break;
			case "left":
				if (spriteNum == 1) {	image = left1;}
				if (spriteNum == 2) {image = left2;}
				break;
			case "right":
				if (spriteNum == 1) {image = right1;}
				if (spriteNum == 2) {image = right2;}
				break;
			}
			
			// Monster HP bar
			if (type == 2 && hpBarOn == true) {
				
				double oneScale = (double)gp.tileSize/maxLife;
				double hpBarValue = oneScale*life;
				
				
				
				g2.setColor(new Color(35,35,35));
				g2.fillRect(screenX - 1, screenY - 11, gp.tileSize + 2, 12);
				g2.setColor(new Color(255,0,30));
				g2.fillRect(screenX, screenY - 10, (int) hpBarValue, 10);
				
				hpBarCounter++;
				
				if(hpBarCounter > 600) {
					hpBarCounter = 0;
					hpBarOn = false;					
				}
			}
			
			
			
			if(invincible == true) {
				hpBarOn = true;
				hpBarCounter = 0;
				changeAlpha(g2, 0.4F);
			}
			
			if(dying == true) {
				dyingAnimation(g2);	
			}
			g2.drawImage(image,screenX,screenY, null);
			changeAlpha(g2, 1F);
		}
		
		
	}
	
	/**
	 * This uses the package Graphics2D to draw dying animation graphics onto the screen
	 * @param g2 is the graphics object from class Graphics2D used to display graphics
	 */
	void dyingAnimation(Graphics2D g2) {
		
		dyingCounter++;
		
		int i = 5;
		if(dyingCounter <= i) {changeAlpha(g2, 0f);}
		if(dyingCounter > i && dyingCounter <= i*2) {changeAlpha(g2, 1f);}
		if(dyingCounter > i*2 && dyingCounter <= i*3) {changeAlpha(g2, 0f);}
		if(dyingCounter > i*3 && dyingCounter <= i*4) {changeAlpha(g2, 1f);}
		if(dyingCounter > i*4 && dyingCounter <= i*5) {changeAlpha(g2, 0f);}
		if(dyingCounter > i*5 && dyingCounter <= i*6) {changeAlpha(g2, 1f);}
		if(dyingCounter > i*6 && dyingCounter <= i*7) {changeAlpha(g2, 0f);}
		if(dyingCounter > i*7 && dyingCounter <= i*8) {changeAlpha(g2, 1f);}
		if(dyingCounter > i*8) {
			alive = false;
		}
	}
	/**
	 * This uses the package Graphics2D to make a graphic object on the screen appear transparent depending on alphaValue
	 * @param g2 is the graphics object from class Graphics2D used to display graphics
	 * @param alphaValue is the alpha value from 0-255 of the graphics 
	 */
	public void changeAlpha(Graphics2D g2, float alphaValue) {
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
	}
	/**
	 * This method reads an image from an entity subclass and loads it
	 * @param imagePath is the skeletal path of the image to be loaded
	 * @param width, height are the size parameters of the picture
	 */
	public BufferedImage setup(String imagePath, int width, int height) {
		
		UtilityTool uTool = new UtilityTool();	
		
		BufferedImage image = null;
		
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
			image = uTool.scaleImage(image,width,height);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return image;
	}

    public int getDetected(Entity user, Entity target[], String targetName) {
	
    	int index = 999;
    	
    	// check the surrounding objects
    	int nextWorldX = user.getLeftX();
    	int nextWorldY = user.getTopY();
    	
    	switch(user.direction) {
    	case "up": nextWorldY = user.getTopY()-1; break;
    	case "down": nextWorldY = user.getBottomY()+1; break;
    	case"left": nextWorldX = user.getLeftX()-1; break;
    	case"right": nextWorldX = user.getRightX()+1; break;
    	}
    	int col = nextWorldX/gp.tileSize;
    	int row = nextWorldY/gp.tileSize;
    	
    	for(int i=0;i<target.length;i++) {
    		if(target[i] != null) {
    			if(target[i].getCol() == col && target[i].getRow() == row &&
    					target[i].name.equals(targetName)) {
    				
    				index = i;
    				break;
    			}
    		}
    	}
    	return index;
    }

}
