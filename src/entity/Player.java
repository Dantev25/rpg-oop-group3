package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.GamePanel;
import main.KeyHandler;
import monster.MON_GreenSlime;
import object.OBJ_Axe;
import object.OBJ_Fireball;
import object.OBJ_Key;
import object.OBJ_NoWep;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Wood;
import object.OBJ_StrongAxe;
import object.OBJ_Sword_Normal;
/**
 * defines Class player, a subclass of Entity, which takes care of all player initialisations and interactions
 * @author Oomar
 * @author Sadiyah
 * @author Mrish
 */
public class Player extends Entity{
	

	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	public boolean attackCanceled = false;
	public ArrayList<Entity> inventory = new ArrayList<>();
	public final int maxInventorySize = 20;
	public int ptype = 0;
	/**
	 * Setter for initial values of player character
	 * @param gp - gamepanel
	 * @param keyH - key listener for keyboard input
	 */
	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);
		

		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.height = 28;
		solidArea.width = 28;
		
		//ATTACK AREA
//		attackArea.width = 36;
//		attackArea.height = 36;
		
		setDefaultValues();
		getPlayerImage();
		getAttackImage();
		
	}
	/**
	 * setter for default values of player
	 */
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 30;
		worldY = gp.tileSize * 20;
		speed = 4;		
		direction = "down";
		
		//PLAYER STATUS
		level = 1;
		maxLife = 6;
		life = maxLife;
		maxMana = 4;
		mana = maxMana;
		ammo = 10;
		strength = 5;
		dexterity = 1;
		exp = 0;
		nextLevelExp = 10;
		coin =0;
		currentWeapon = new OBJ_NoWep(gp);
		currentShield = new OBJ_Shield_Wood(gp);


		attack = getAttack();
		defense = getDefense();
		

	}
	/**
	 * setter for player character after player chooses type
	 * @param i player type chosen in start menu
	 */
	public void updateDefaultValues(int i) {
		if (i == 0) {
			ptype = 0;
			level = 1;
			maxLife = 8;
			life = maxLife;
			maxMana = 1;
			mana = maxMana;
			ammo = 10;
			strength = 3;
			dexterity = 1;
			exp = 0;
			nextLevelExp = 10;
			coin =0;
			currentWeapon = new OBJ_Sword_Normal(gp);
			projectile = new OBJ_Fireball(gp);
			attack = getAttack();
			defense = getDefense();
			getPlayerImage();
			getAttackImage();
			setItems();
		}
		else if(i == 1) {
			ptype = 1;
			level = 1;
			maxLife = 10;
			life = maxLife;
			maxMana = 0;
			mana = maxMana;
			ammo = 10;
			strength = 1;
			dexterity = 3;
			exp = 0;
			nextLevelExp = 10;
			coin =0;
			currentWeapon = new OBJ_StrongAxe(gp);
			currentShield = new OBJ_Shield_Wood(gp);
			
			
			attack = getAttack();
			defense = getDefense();
			getPlayerImage();
			getAttackImage();
			setItems();
		}
		else if(i == 2) {
			ptype = 2;
			level = 1;
			maxLife = 6;
			life = maxLife;
			maxMana = 10;
			mana = maxMana;
			ammo = 100;
			strength = 0;
			dexterity = 2;
			exp = 0;
			nextLevelExp = 10;
			coin =0;
			currentShield = new OBJ_Shield_Wood(gp);
			projectile = new OBJ_Fireball(gp);
			attack = getAttack();
			defense = getDefense();
			getPlayerImage();
			getAttackImage();
			setItems();
		}
	}
	/**
	 * setter for default location of player character
	 */
	public void setDefaultPositions() {
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		direction = "down";
	}
	/**
	 * method to restore life and mana to the character
	 */
	public void restoreLifeAndMana() {
		life = maxLife;
		mana = maxMana;
		invincible = false;
	}
	/**
	 * setter for initial inventory of player
	 */
 	public void setItems() {
 		inventory.clear();
		inventory.add(currentWeapon);
		if(ptype!=2) {
			inventory.add(currentShield);
		}
		inventory.add(new OBJ_Key(gp));
		inventory.add(new OBJ_Potion_Red(gp));
	}
	
	/**
	 * This returns the attack value.
	 * The total attack value is decided by strength and weapon.
	 * @return this attack value.
	 */
	public int getAttack() {
		attackArea = currentWeapon.attackArea;
		return attack = strength + currentWeapon.attackValue;
	}
	
	/**
	 * This returns the defense value.
	 * The total defense value is decided by dexterity and shield.
	 * @return this defense value.
	 */
	
	public int getDefense() {
		return defense = dexterity + currentShield.defenseValue;
	}
	
	/**
	 * loads appropriate walking images based on type of character chosen
	 */
	public void getPlayerImage() {
		if(ptype == 0) {
			up1 = setup("/player/boy_up_1", gp.tileSize, gp.tileSize); 
			up2 = setup("/player/boy_up_2", gp.tileSize, gp.tileSize);
			down1 = setup("/player/boy_down_1", gp.tileSize, gp.tileSize);
			down2 = setup("/player/boy_down_2", gp.tileSize, gp.tileSize);
			right1 = setup("/player/boy_right_1", gp.tileSize, gp.tileSize);
			right2 = setup("/player/boy_right_2", gp.tileSize, gp.tileSize);
			left1 = setup("/player/boy_left_1", gp.tileSize, gp.tileSize);
			left2 = setup("/player/boy_left_2", gp.tileSize, gp.tileSize);
		}
		if(ptype == 1) {
			up1 = setup("/player/tank_up_1", gp.tileSize, gp.tileSize); 
			up2 = setup("/player/tank_up_2", gp.tileSize, gp.tileSize);
			down1 = setup("/player/tank_down_1", gp.tileSize, gp.tileSize);
			down2 = setup("/player/tank_down_2", gp.tileSize, gp.tileSize);
			right1 = setup("/player/tank_right_1", gp.tileSize, gp.tileSize);
			right2 = setup("/player/tank_right_2", gp.tileSize, gp.tileSize);
			left1 = setup("/player/tank_left_1", gp.tileSize, gp.tileSize);
			left2 = setup("/player/tank_left_2", gp.tileSize, gp.tileSize);
		}
		if(ptype == 2) {
			up1 = setup("/player/sorcerer_up_1", gp.tileSize, gp.tileSize); 
			up2 = setup("/player/sorcerer_up_2", gp.tileSize, gp.tileSize);
			down1 = setup("/player/sorcerer_down_1", gp.tileSize, gp.tileSize);
			down2 = setup("/player/sorcerer_down_2", gp.tileSize, gp.tileSize);
			right1 = setup("/player/sorcerer_right_1", gp.tileSize, gp.tileSize);
			right2 = setup("/player/sorcerer_right_2", gp.tileSize, gp.tileSize);
			left1 = setup("/player/sorcerer_left_1", gp.tileSize, gp.tileSize);
			left2 = setup("/player/sorcerer_left_2", gp.tileSize, gp.tileSize);
		}
	}
	/**
	 * loads appropriate attacking images based on type of character chosen
	 */
	public void getAttackImage() {
		if(ptype == 0) {
			if(currentWeapon.type == type_nowep){
				attackUp1 = setup("/player/boy_up_1", gp.tileSize, gp.tileSize); 
				attackUp2 = setup("/player/boy_up_2", gp.tileSize, gp.tileSize);
				attackDown1 = setup("/player/boy_down_1", gp.tileSize, gp.tileSize);
				attackDown2 = setup("/player/boy_down_2", gp.tileSize, gp.tileSize);
				attackRight1 = setup("/player/boy_right_1", gp.tileSize, gp.tileSize);
				attackRight2 = setup("/player/boy_right_2", gp.tileSize, gp.tileSize);
				attackLeft1 = setup("/player/boy_left_1", gp.tileSize, gp.tileSize);
				attackLeft2 = setup("/player/boy_left_2", gp.tileSize, gp.tileSize);
			}
			if(currentWeapon.type == type_sword) {
				attackUp1 = setup("/player/boy_attack_up_1", gp.tileSize, gp.tileSize*2); 
				attackUp2 = setup("/player/boy_attack_up_2", gp.tileSize, gp.tileSize*2);
				attackDown1 = setup("/player/boy_attack_down_1", gp.tileSize, gp.tileSize*2);
				attackDown2 = setup("/player/boy_attack_down_2", gp.tileSize, gp.tileSize*2);
				attackRight1 = setup("/player/boy_attack_right_1", gp.tileSize*2, gp.tileSize);
				attackRight2 = setup("/player/boy_attack_right_2", gp.tileSize*2, gp.tileSize);
				attackLeft1 = setup("/player/boy_attack_left_1", gp.tileSize*2, gp.tileSize);
				attackLeft2 = setup("/player/boy_attack_left_2", gp.tileSize*2, gp.tileSize);
			}
			
			if(currentWeapon.type == type_axe) {
				attackUp1 = setup("/player/boy_axe_up_1", gp.tileSize, gp.tileSize*2); 
				attackUp2 = setup("/player/boy_axe_up_2", gp.tileSize, gp.tileSize*2);
				attackDown1 = setup("/player/boy_axe_down_1", gp.tileSize, gp.tileSize*2);
				attackDown2 = setup("/player/boy_axe_down_2", gp.tileSize, gp.tileSize*2);
				attackRight1 = setup("/player/boy_axe_right_1", gp.tileSize*2, gp.tileSize);
				attackRight2 = setup("/player/boy_axe_right_2", gp.tileSize*2, gp.tileSize);
				attackLeft1 = setup("/player/boy_axe_left_1", gp.tileSize*2, gp.tileSize);
				attackLeft2 = setup("/player/boy_axe_left_2", gp.tileSize*2, gp.tileSize);
			}
			
		}
		if(ptype == 1) {
			if(currentWeapon.type == type_nowep){
				up1 = setup("/player/tank_up_1", gp.tileSize, gp.tileSize); 
				up2 = setup("/player/tank_up_2", gp.tileSize, gp.tileSize);
				down1 = setup("/player/tank_down_1", gp.tileSize, gp.tileSize);
				down2 = setup("/player/tank_down_2", gp.tileSize, gp.tileSize);
				right1 = setup("/player/tank_right_1", gp.tileSize, gp.tileSize);
				right2 = setup("/player/tank_right_2", gp.tileSize, gp.tileSize);
				left1 = setup("/player/tank_left_1", gp.tileSize, gp.tileSize);
				left2 = setup("/player/tank_left_2", gp.tileSize, gp.tileSize);
			}
			
			if(currentWeapon.type == type_axe) {
				attackUp1 = setup("/player/tank_axe_up_1", gp.tileSize, gp.tileSize*2); 
				attackUp2 = setup("/player/tank_axe_up_2", gp.tileSize, gp.tileSize*2);
				attackDown1 = setup("/player/tank_axe_down_1", gp.tileSize, gp.tileSize*2);
				attackDown2 = setup("/player/tank_axe_down_2", gp.tileSize, gp.tileSize*2);
				attackRight1 = setup("/player/tank_axe_right_1", gp.tileSize*2, gp.tileSize);
				attackRight2 = setup("/player/tank_axe_right_2", gp.tileSize*2, gp.tileSize);
				attackLeft1 = setup("/player/tank_axe_left_1", gp.tileSize*2, gp.tileSize);
				attackLeft2 = setup("/player/tank_axe_left_2", gp.tileSize*2, gp.tileSize);
			}
			
		}
		if(ptype == 2) {
			if(currentWeapon.type == type_nowep){
				attackUp1 = setup("/player/sorcerer_up_1", gp.tileSize, gp.tileSize); 
				attackUp2 = setup("/player/sorcerer_up_2", gp.tileSize, gp.tileSize);
				attackDown1 = setup("/player/sorcerer_down_1", gp.tileSize, gp.tileSize);
				attackDown2 = setup("/player/sorcerer_down_2", gp.tileSize, gp.tileSize);
				attackRight1 = setup("/player/sorcerer_right_1", gp.tileSize, gp.tileSize);
				attackRight2 = setup("/player/sorcerer_right_2", gp.tileSize, gp.tileSize);
				attackLeft1 = setup("/player/sorcerer_left_1", gp.tileSize, gp.tileSize);
				attackLeft2 = setup("/player/sorcerer_left_2", gp.tileSize, gp.tileSize);
			}
			
			if(currentWeapon.type == type_axe) {
				attackUp1 = setup("/player/sorcerer_axe_up_1", gp.tileSize, gp.tileSize*2); 
				attackUp2 = setup("/player/sorcerer_axe_up_2", gp.tileSize, gp.tileSize*2);
				attackDown1 = setup("/player/sorcerer_axe_down_1", gp.tileSize, gp.tileSize*2);
				attackDown2 = setup("/player/sorcerer_axe_down_2", gp.tileSize, gp.tileSize*2);
				attackRight1 = setup("/player/sorcerer_axe_right_1", gp.tileSize*2, gp.tileSize);
				attackRight2 = setup("/player/sorcerer_axe_right_2", gp.tileSize*2, gp.tileSize);
				attackLeft1 = setup("/player/sorcerer_axe_left_1", gp.tileSize*2, gp.tileSize);
				attackLeft2 = setup("/player/sorcerer_axe_left_2", gp.tileSize*2, gp.tileSize);
			}
		}
		
	}
	
	/**
	 * Updates the state of the player character
	 * Handles collision of player
	 * movement of player
	 * attacking
	 * Handles player character shooting projectiles
	 * also handles gameover if life = 0
	 */
	public void update() {
		if(attacking == true) {
			attacking();
		}
		else if(keyH.upPressed == true || 
				keyH.downPressed == true || 
				keyH.rightPressed == true || 
				keyH.leftPressed == true ||
				keyH.enterPressed == true) {
			if(keyH.upPressed == true) {
				direction = "up";
				
				
			}
			else if (keyH.downPressed == true) {
				direction = "down";
				
				
			}
			else if (keyH.leftPressed == true) {
				direction = "left";	
				
						
			}
			else if (keyH.rightPressed == true) {
				direction = "right";
				
				
			}
			
			// CHECK TILE COLLISION
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			// CHECK OBJECT COLLISION
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			//CHECK NPC COLLISION
			
			int npcIndex = gp.cChecker.checkEntity(this,gp.npc);
			interactNPC(npcIndex);
			
			// CHECK MONSTER COLLISION
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			contactMonster(monsterIndex);
			
			// CHECK INTERACTIVE TILE COLLISION
			int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);
			
			// CHECK EVENT
			
			gp.eHandler.checkEvent();
			
			
			// IF COLLISION IS FALSE PLAYER CAN MOVE
			if(collisionOn == false && keyH.enterPressed == false) {
				
				switch (direction) {
				case "up": worldY -= speed;  break;
				case "down": worldY += speed; break;
				case "left": worldX -= speed;  break;
				case "right": worldX += speed;  break;
				
				}

			}
			
			if(keyH.enterPressed == true && attackCanceled == false) {
				gp.playSE(7);
				attacking = true;
				spriteCounter = 0;		
			}
			
			attackCanceled = false;
			gp.keyH.enterPressed = false;
			
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
			
		}
		
		if(gp.keyH.shotKeyPressed == true && projectile.alive == false 
				&& shotAvailableCounter == 30 && projectile.haveResource(this) == true && gp.keyH.playerType!=1) {
			
			// SET DEFAULT COODINATES, DIRECTION AND USER
			projectile.set(worldX, worldY, direction, true, this);
			
			// SUBTRACT THE COST (MANA, AMMO ETC.)
			projectile.subtractResource(this);
			
			// ADD IT TO LIST
			gp.projectileList.add(projectile);
			
			shotAvailableCounter = 0;
			gp.playSE(10);
		}
		
		if (invincible == true) {
			invincibleCounter++;
			if(invincibleCounter>60) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
		
		if(shotAvailableCounter < 30) {
			shotAvailableCounter++;
		}
		
		if(life > maxLife) {
			life = maxLife;
		}
		
		if(mana > maxMana) {
			mana = maxMana;
		}
		
		if(life <= 0) {
			gp.ui.titleScreenState = 0;
			gp.gameState = gp.gameOverState;
			gp.playSE(12);
			gp.stopMusic();
		}
		
	}
	/**
	 * handles attacking images, and collision calculations
	 * 
	 */
	public void attacking() {
		
		spriteCounter++;
		
		if(spriteCounter <= 5) {
			spriteNum = 1;
		}
		if(spriteCounter > 5 && spriteCounter <= 25) {
			spriteNum = 2;
			
			// SAVE current worldX,worldY and solidArea
			int currentWorldX = worldX;
			int currentWorldY = worldY;
			int solidAreaWidth = solidArea.width;
			int solidAreaHeight = solidArea.height;
			
			// Adjust player's worldX/Y for attackArea
			
			switch (direction) {
			case "up": worldY -= attackArea.height; break;
			case "down": worldY += attackArea.height; break;
			case "left": worldX -= attackArea.width; break;
			case "right": worldX += attackArea.width; break;
			}
			// attackArea becomes solidArea
			solidArea.width = attackArea.width;
			solidArea.height = attackArea.height;
			// check monster collision with updated worldX/Y and solidArea; 
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			damageMonster(monsterIndex, attack);
			
			int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);
			damageInteractiveTile(iTileIndex);
			
			//After checking collision, restore the original data
			worldX = currentWorldX;
			worldY = currentWorldY;
			solidArea.width = solidAreaWidth;
			solidArea.height = solidAreaHeight;
		}
		if(spriteCounter > 25) {
			spriteNum = 1;
			spriteCounter = 0;
			attacking = false;
		}
		
	}
	/**
	 * handles picking up objects that can be kept in inventory, or pickup only items(disappears after pickup)
	 * @param i -  item index
	 */
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			// PICKUP ONLY ITEMS
			if(gp.obj[i].type == type_pickupOnly) {
				
				gp.obj[i].use(this);
				gp.obj[i] = null;
			}
			
			// OBSTACLE
			else if(gp.obj[i].type == type_obstacle) {
				if(keyH.enterPressed == true) {
					attackCanceled = true;
					gp.obj[i].interact();
				}
			}
			
			// INVENTORY ITEMS
			else {
				String text;
				
				if(inventory.size() != maxInventorySize) {
					inventory.add(gp.obj[i]);
					gp.playSE(1);
					text = "Got a" + gp.obj[i].name + "!";
				}
				
				else {
					text = "You cannot carry any more!";
				}
				gp.ui.addMessage(text);
				gp.obj[i] = null;
			}
		}
		
	}
	/**
	 * handles dialogue with npc
	 * @param i index of npc
	 */
	public void interactNPC(int i) {
		if(gp.keyH.enterPressed == true) {
			if(i != 999) {
				attackCanceled = true;
				gp.gameState = gp.dialogueState;
				gp.npc[i].speak();
				
			}
			
		}
		
	}
	/**
	 * handles direct hit with monster, inflicts damage to player and set invisibility frame
	 * @param i
	 */
	public void contactMonster(int i) {
		
		if(i != 999) {
			if (invincible == false && gp.monster[i].dying == false) {
				gp.playSE(6);
				int damage = gp.monster[i].attack - defense;
				if(damage < 0) {
					damage = 0;
				}
				
				life -= damage;
				invincible = true;
				
			}
		}
		
		
	}

	/**
	 * damages monster if player is attacking, and displays a message showing damage given
	 * @param i
	 * @param attack
	 */
	public void damageMonster(int i, int attack) {
		
		if (i != 999) {
			
			if(gp.monster[i].invincible == false) {
				
				gp.playSE(5);
				
				int damage = attack - gp.monster[i].defense;
				if(damage < 0) {
					damage = 0;
				}
				
				gp.monster[i].life -= damage;
				gp.ui.addMessage(damage + " damage!");
				
				gp.monster[i].invincible = true;
				gp.monster[i].damageReaction();
				
				if(gp.monster[i].life <= 0) {
					gp.monster[i].dying = true;
					gp.ui.addMessage("Killed " + gp.monster[i].name + "!");
					gp.ui.addMessage("+" + gp.monster[i].exp + " exp!");
					exp += gp.monster[i].exp;
					checkLevelUp();
				}
			}
		}
		
	}
	/**
	 * handles damage given to interactive tiles and decreases their health if hit with correct item
	 * @param i
	 */
	public void damageInteractiveTile(int i) {
		
		if(i != 999 && gp.iTile[i].destructible ==true && 
				gp.iTile[i].isCorrectItem(this) == true && gp.iTile[i].invincible == false) {
			
			gp.iTile[i].playSE();
			gp.iTile[i].life--;
			gp.iTile[i].invincible = true;
			
			// GENERATE PARTICLE
			generateParticle(gp.iTile[i],gp.iTile[i]);
			
			if(gp.iTile[i].life==0) {
				gp.iTile[i] = gp.iTile[i].getDestroyedForm();
			}
			
		}
	}
	/**
	 * checks exp of player if player can level up
	 * upgrades stats based on player character type
	 */
	public void checkLevelUp() {
		
		if(exp >= nextLevelExp) {
			level++;
			nextLevelExp = nextLevelExp + (10*level);
			for (int i = 0; i<gp.monster.length;i++) {
				gp.monster[i].attack += 1;
			}
			if(ptype == 0) {
				maxLife +=2;
				strength++;
				dexterity++;
				life = maxLife;
				attack = getAttack();
				defense = getDefense();
			}
			if(ptype == 1) {
				maxLife +=2;
				strength++;
				dexterity++;
				life = maxLife;
				attack = getAttack();
				defense = getDefense();	
			}
			if(ptype == 2) {
				maxLife +=2;
				dexterity++;
				life = maxLife;
				projectile.attack += 1;
				defense = getDefense();
			}
			
			gp.playSE(8);
			gp.gameState = gp.dialogueState;
			gp.ui.currentDialogue = "LEVEL UP!\n\nYou are level " + level + "!";
			
			
		}
		
	}
	/**
	 * handles item selection from inventory
	 */
	public void selectItem() {
		
		int itemIndex = gp.ui.getItemIndexOnSlot();
		
		if(itemIndex < inventory.size()) {
			
			Entity selectedItem = inventory.get(itemIndex);
			
			if(selectedItem.type == type_sword || selectedItem.type == type_axe) {
				currentWeapon = selectedItem;
				attack = getAttack();
				getAttackImage();
			}
			
			if(selectedItem.type ==type_shield) {
				currentShield = selectedItem;
				defense = getDefense();
			}
			
			if(selectedItem.type == type_consumable) {
			    if(selectedItem.use(this) ==  true) {
			    	inventory.remove(itemIndex);
			    }
			}
		}
	}
	
	/**
	 * method to draw player images whhen attacking or moving
	 * also handles the player becoming translucent in invincibility mode
	 * @param g2 is the graphics object used to display the object onto the screen
	 * 
	 */
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		int tempScreenX = screenX;
		int tempScreenY = screenY;
		switch(direction) {
		case "up":
			if(attacking == false) {
				if (spriteNum == 1) {image = up1;}
				if (spriteNum == 2) {image = up2;}
			}
			if(attacking == true && currentWeapon.type != type_nowep) {
				tempScreenY = screenY - gp.tileSize;
				if (spriteNum == 1) {image = attackUp1;}
				if (spriteNum == 2) {image = attackUp2;}
			}
			else if(attacking == true && currentWeapon.type == type_nowep) {
				if (spriteNum == 1) {image = attackUp1;}
				if (spriteNum == 2) {image = attackUp2;}
			}
			break;
		case "down":
			if(attacking == false) {
				if (spriteNum == 1) {image = down1;}
				if (spriteNum == 2) {image = down2;}
			}
			if(attacking == true) {
				if (spriteNum == 1) {image = attackDown1;}
				if (spriteNum == 2) {image = attackDown2;}
			}
			break;
		case "left":
			if(attacking == false) {
				if (spriteNum == 1) {image = left1;}
				if (spriteNum == 2) {image = left2;}
			}
			if(attacking == true && currentWeapon.type != type_nowep) {
				tempScreenX = screenX - gp.tileSize;
				if (spriteNum == 1) {image = attackLeft1;}
				if (spriteNum == 2) {image = attackLeft2;}
			}
			else if (attacking == true && currentWeapon.type == type_nowep){
				if (spriteNum == 1) {image = attackLeft1;}
				if (spriteNum == 2) {image = attackLeft2;}
			}
			
			break;
		case "right":
			if(attacking == false) {
				if (spriteNum == 1) {image = right1;}
				if (spriteNum == 2) {image = right2;}
			}
			if(attacking == true) {
				if (spriteNum == 1) {image = attackRight1;}
				if (spriteNum == 2) {image = attackRight2;}
			}
			break;
		}
		
		int x = screenX;
		int y = screenY;
		
		if (screenX>worldX) {
			x = worldX;
		}
		
		if (screenY>worldY) {
			y = worldY;
		}
		int rightOffset = gp.screenWidth - screenX;
		if(rightOffset > gp.worldWidth - worldX) {
			x = gp.screenWidth - (gp.worldWidth - worldX);
		}
		
		int bottomOffset = gp.screenHeight - screenY;
		if(bottomOffset > gp.worldHeight - gp.player.worldY) {
			y = gp.screenHeight - (gp.worldHeight - worldY);
		}
		
		if(invincible == true) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		}
		g2.drawImage(image, tempScreenX,  tempScreenY, null);
		
		//reset alpha
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		// DEBUG
//		
//		g2.setFont(new Font("Arial", Font.PLAIN, 26));
//		g2.setColor(Color.white);
//		g2.drawString("Invincible: "+invincibleCounter, 10, 400);
	}
}

























