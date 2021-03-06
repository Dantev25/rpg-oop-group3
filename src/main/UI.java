package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entity.Entity;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;

/**
 * This class handles the User Interface.
 * @author mrish
 * @author Oomar
 * @author Sadiyah
 */
public class UI {
	
	GamePanel gp;
	Graphics2D g2;
	Font arial_40, arial_80B;
	BufferedImage heart_full, heart_half, heart_blank, crystal_full, crystal_blank;
	public boolean messageOn = false;
	ArrayList<String> message = new ArrayList<>();
	ArrayList<Integer> messageCounter = new ArrayList<>();
	public boolean gameFinished = false;
	public String currentDialogue = "";
	public int commandNum = 0; 
	public int titleScreenState = 0; //0:the first screen, 1: the second screen
	public int slotCol = 0;
	public int slotRow = 0;
	int subState = 0;
	

	/**
	 * This constructs the User Interface.
	 * @param gp this game panel
	 */
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_80B = new Font("Arial", Font.BOLD, 80);
		
		//CREATE HUD OBJECT
		Entity heart = new OBJ_Heart(gp);
		heart_full = heart.image;
		heart_half = heart.image2;
		heart_blank = heart.image3;
		Entity crystal = new OBJ_ManaCrystal(gp);
        crystal_full = crystal.image;
		crystal_blank = crystal.image2;
	}
	/**
	 * This method displays the text that is passed to it onto the screen.
	 * @param text this added text.
	 */
	public void addMessage(String text) {
		
		message.add(text);
		messageCounter.add(0);
	}
	/**
	 * This draws the appropriate ui for the current gamestates
	 * title state
	 * play state
	 * pause state
	 * dialogue state
	 * character state
	 * options state
	 * game over state
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
		
		this.g2 = g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
		
		//PLAYING GAME
		if(gp.gameState == gp.playState) {
			drawPlayerLife();
			drawMessage();
		}
		//PAUSE GAME
		if(gp.gameState == gp.pauseState) {
			drawPlayerLife();
			drawPauseScreen();
		}
		//DIALOGUE STATE
		if(gp.gameState == gp.dialogueState) {
			drawPlayerLife();
			drawDialogueScreen();
		}
		//CHARACTERSTATE
		if(gp.gameState == gp.characterState) {
			drawCharacterScreen();
			drawInventory();
		}
		// OPTIONS STATE
		if(gp.gameState == gp.optionsState){
			drawOptionsScreen();
		}
		if(gp.gameState == gp.gameOverState){
			drawGameOverScreen();
		}
		
	}
	/**
	 * This displays the title screen.
	 */
	public void drawTitleScreen() {
		
		if(titleScreenState == 0) {
			
			
			// BACKGROUND COLOR
			g2.setColor(new Color(0,0,0));
			g2.fillRect(0, 0,  gp.screenWidth, gp.screenHeight);
			
			
			// TITLE NAME
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN,96F));
			String text =  "RPG Group 3";
			int x = getXforCenteredText(text);
			int y = gp.tileSize*3;
			
			// TITLE SHADOW
			g2.setColor(Color.gray);
			g2.drawString(text, x+5, y+5);
			// MAIN COLOR
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
			//SET PLAYER IMAGE
			x = gp.screenWidth/2 - (gp.tileSize*2)/2;
			y = gp.tileSize*5;
			g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);
			
			// TITLE MENU
			
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN,48F));
			
			text = "NEW GAME";
			x = getXforCenteredText(text);
			y += gp.tileSize*3.5;
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				g2.drawString(">", x-gp.tileSize, y);		
			}
			
			text = "LOAD GAME";
			x = getXforCenteredText(text);
			y += gp.tileSize*1;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.drawString(">", x-gp.tileSize, y);		
			}
			
			text = "QUIT";
			x = getXforCenteredText(text);
			y += gp.tileSize*1;
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				g2.drawString(">", x-gp.tileSize, y);		
			}
		}
		else if(titleScreenState == 1) {
			g2.setColor(new Color(0,0,0));
			g2.fillRect(0, 0,  gp.screenWidth, gp.screenHeight);
			
			// CLASS SELECTION SCREEN
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(34F));
			
			String text = "Select your class!";
			int x = getXforCenteredText(text);
			int y = gp.tileSize*3;
			g2.drawString(text, x, y);
	
			
			text = "Warrior (Sword, +atk,-def,1 mana)";
			x = getXforCenteredText(text);
			y = gp.tileSize*5;
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			text = "Tank (Axe,+hp,+def,0 mana)";
			x = getXforCenteredText(text);
			y = gp.tileSize*6;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			text = "Sorcerer (Fireball,-hp,6 mana)";
			x = getXforCenteredText(text);
			y = gp.tileSize*7;
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			text = "Back";
			x = getXforCenteredText(text);
			y = gp.tileSize*9;
			g2.drawString(text, x, y);
			if(commandNum == 3) {
				g2.drawString(">", x-gp.tileSize, y);
			}
		}
		else if(titleScreenState == 2) {
			g2.setColor(new Color(0,0,0));
			g2.fillRect(0, 0,  gp.screenWidth, gp.screenHeight);
			
			// CLASS SELECTION SCREEN
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(24F));
			
			String text = "INSTRUCTIONS!";
			int x = getXforCenteredText(text);
			int y = gp.tileSize;
			g2.drawString(text, x, y);
			
			text = "W/A/S/D - Movement";
			x = gp.tileSize;
			y = gp.tileSize+40;
			g2.drawString(text, x, y);
	
			text = "Enter - Melee";
			x = gp.tileSize;
			y = gp.tileSize+80;
			g2.drawString(text, x, y);
			
			text = "F - Projectile";
			x = gp.tileSize;
			y = gp.tileSize+120;
			g2.drawString(text, x, y);
			
			text = "C - Inventory";
			x = gp.tileSize;
			y = gp.tileSize+160;
			g2.drawString(text, x, y);
			
			text = "T - debug";
			x = gp.tileSize;
			y = gp.tileSize+200;
			g2.drawString(text, x, y);
			
			text = "P - Pause/Resume";
			x = gp.tileSize;
			y = gp.tileSize+240;
			g2.drawString(text, x, y);
			
			text = "Esc - Options Menu";
			x = gp.tileSize;
			y = gp.tileSize+280;
			g2.drawString(text, x, y);
			
			text = "Kill monsters to get EXP. Use keys to open doors and get chests!";
			x = gp.tileSize;
			y = gp.tileSize+350;
			g2.drawString(text, x, y);
		}
		
	}
	/**
	 * This displays the player life as hearts and mana as crystals in top left.
	 */
	public void drawPlayerLife() {
		int x = gp.tileSize/4;
		int y = gp.tileSize/4;
		int i = 0;
		
		//DRAW MAX LIFE
		while (i < gp.player.maxLife/2) {
			g2.drawImage(heart_blank, x, y,null);
			i++;
			x += gp.tileSize/2;
		}
		
		//RESET 
		x = gp.tileSize/4;
		y = gp.tileSize/4;
		i = 0;
		
		//DRAW CURRENT LIFE
		while(i < gp.player.life) {
			g2.drawImage(heart_half, x, y, null);
			i++;
			if(i < gp.player.life) {
				g2.drawImage(heart_full, x, y, null);
			}
			i++;
			x += gp.tileSize/2;
		}
		
		// DRAW MAX MANA
		x = (gp.tileSize/6);
		y = (int) (gp.tileSize);
		i = 0;
		
		while(i<gp.player.maxMana) {
			g2.drawImage(crystal_blank, x, y, null);
			i++;
			x += gp.tileSize/2;
		}
		
		// DRAW MANA
		x = (gp.tileSize/6);
		y = (int) (gp.tileSize);
		i = 0;
		while(i<gp.player.mana) {
			g2.drawImage(crystal_full, x, y, null);
			i++;
			x += gp.tileSize/2;
		}
	}
	/**
	 * This displays the message.
	 */
	public void drawMessage() {
	
		int messageX = gp.tileSize;
		int messageY = gp.tileSize*4;
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 21F));
		
		for(int i = 0; i < message.size(); i++) {
			
			if(message.get(i) != null) {
				g2.setColor(Color.black);
				g2.drawString(message.get(i), messageX+2, messageY+2);
				g2.setColor(Color.white);
				g2.drawString(message.get(i), messageX, messageY);
				
				int counter = messageCounter.get(i) + 1;
				messageCounter.set(i,counter);
				messageY += 20;
				
				if(messageCounter.get(i) > 180) {
					message.remove(i);
					messageCounter.remove(i);
				}
			}
		}
	}
	/**
	 * This display the pause screen.
	 */
	public void drawPauseScreen() {
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
		String text = "PAUSED";
		int x = getXforCenteredText(text);
		
		int y = gp.screenHeight/2;
		
		g2.drawString(text, x, y);
	}
	
	/**
	 * This display the dialogue screen.
	 */
	public void drawDialogueScreen() {
		
		//WINDOW
		int x = gp.tileSize * 2;
		int y = gp.tileSize/2;
		int width = gp.screenWidth - (gp.tileSize*4);
		int height = gp.tileSize*4;
		
		drawSubWindow(x, y, width, height);
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,27F));
		x += gp.tileSize;
		y += gp.tileSize;
		
		for (String line : currentDialogue.split("\n")) {
			g2.drawString(line, x, y);
			y += 40;
		}
		
	}
	/**
	 * This display the character screen.
	 */
	public void drawCharacterScreen() {
		
		// CREATE A FRAME
		final int frameX = gp.tileSize*2;
		final int frameY = gp.tileSize;
		final int frameWidth = gp.tileSize*5;
		final int frameHeight = gp.tileSize*10;
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		// TEXT
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(32F));
		
		int textX = frameX + 20;
		int textY = frameY + gp.tileSize;
		final int lineHeight = 35;
		
		// NAMES
		g2.drawString("Level", textX, textY);
		textY += lineHeight;
		g2.drawString("Life", textX, textY);
		textY += lineHeight;
		g2.drawString("Mana", textX, textY);
		textY += lineHeight;
		g2.drawString("Strength", textX, textY);
		textY += lineHeight;
		g2.drawString("Dexterity", textX, textY);
		textY += lineHeight;
		g2.drawString("Attack", textX, textY);
		textY += lineHeight;
		g2.drawString("Defense", textX, textY);
		textY += lineHeight;
		g2.drawString("Exp", textX, textY);
		textY += lineHeight;
		g2.drawString("Next Level", textX, textY);
		textY += lineHeight;
		g2.drawString("Coin", textX, textY);
		textY += lineHeight + 10;
		g2.drawString("Weapon", textX, textY);
		textY += lineHeight + 15;
		g2.drawString("Shield", textX, textY);
		textY += lineHeight;
		
		// VALUES
		int tailX = (frameX + frameWidth) - 30;
		// Reset textY
		textY = frameY + gp.tileSize;
		String value;
		
		value = String.valueOf(gp.player.level);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.life + "/" + gp.player.maxLife);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.mana + "/" + gp.player.maxMana);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.strength);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.dexterity);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.attack);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.defense);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.exp);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.nextLevelExp);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.coin);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		// Draw weapon image
		g2.drawImage(gp.player.currentWeapon.down1, tailX - gp.tileSize, textY - 24, null);
		textY += gp.tileSize;
		g2.drawImage(gp.player.currentShield.down1, tailX - gp.tileSize, textY - 24, null);
		
		
	}
	/**
	 * This display the inventory.
	 */
	public void drawInventory() {
		
		//FRAME
		int frameX = gp.tileSize*12;
		int frameY = gp.tileSize;
		int frameWidth = gp.tileSize*6;
		int frameHeight = gp.tileSize*5;
		drawSubWindow(frameX,frameY,frameWidth,frameHeight);
		
		//SLOT
		final int slotXstart = frameX + 20;
		final int slotYstart = frameY + 20; 
		int slotX = slotXstart;
		int slotY = slotYstart;
		int slotSize = gp.tileSize + 3;
		
		//CURSOR
		int cursorX = slotXstart + (slotSize * slotCol);
		int cursorY = slotYstart + (slotSize * slotRow);
		int cursorWidth = gp.tileSize;
		int cursorHeight = gp.tileSize;
		
		//DRAW PLAYER'S ITEMS
		for(int i = 0; i <gp.player.inventory.size(); i++) {
			
			//EQUIP CURSOR
			if(gp.player.inventory.get(i) == gp.player.currentWeapon || 
					gp.player.inventory.get(i) == gp.player.currentShield) {
				g2.setColor(new Color(240,190,90));
				g2.fillRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
			}
			g2.drawImage(gp.player.inventory.get(i).down1, slotX, slotY, null);
			
			slotX += slotSize;
			
			if(i==4 || i==9 || i==14) {
				slotX = slotXstart;
				slotY += slotSize;
			}
		}
		
		//DRAW CURSOR
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
        
		//DESCRIPTION FRAME
		int dFrameX = frameX;
		int dFrameY = frameY + frameHeight;
		int dFrameWidth = frameWidth;
		int dFrameHeight = gp.tileSize*3;
	    
		//DRAW FRAME DESCRIPTION TEXT
		int textX = dFrameX + 20;
		int textY = dFrameY + gp.tileSize;
		g2.setFont(g2.getFont().deriveFont(28F));
		
		int itemIndex = getItemIndexOnSlot();
		
		if(itemIndex <gp.player.inventory.size()) {
			drawSubWindow(dFrameX,dFrameY,dFrameWidth, dFrameHeight);
			for(String line: gp.player.inventory.get(itemIndex).description.split("\n")) {
				g2.drawString(line, textX, textY);
				textY += 32;
			}
		}
	}
	/**
	 * This display the options screen.
	 */
	public void drawOptionsScreen() {
		
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(28F));
		
		// SUB WINDOW
		int frameX = gp.tileSize * 6;
		int frameY = gp.tileSize;
		int frameWidth = (int) (gp.tileSize*8.5);
		int frameHeight = gp.tileSize*10;
		
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		switch (subState) {
		case 0: options_top(frameX, frameY); break;
		case 1: options_fullscreenNotification(frameX, frameY); break;
		case 2: options_control(frameX, frameY); break;
		case 3: options_endGameConfirmation(frameX, frameY); break;
		}
		
		gp.keyH.enterPressed = false;
	}
	/**
	 * This display the top options.
	 * @param frameX this frame X
	 * @param frameY this frame Y
	 */
	public void options_top(int frameX, int frameY) {
		
		int textX;
		int textY;
		
		//TITLE
		String text = "Options";
		textX = getXforCenteredText(text);
		textY = frameY +gp.tileSize;
		g2.drawString(text, textX, textY);
		
		// FULL SCREEN ON/OFF
		textX = frameX + gp.tileSize;
		textY += gp.tileSize*2;
		g2.drawString("Full Screen", textX, textY);
		if(commandNum == 0) {
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				if(gp.fullScreenOn == false) {
					gp.fullScreenOn = true;
				}
				else if(gp.fullScreenOn == true) {
					gp.fullScreenOn = false;
				}
				subState = 1;
			}
		}
		
		// MUSIC
		textY += gp.tileSize;
		g2.drawString("Music", textX, textY);
		if(commandNum == 1) {
			g2.drawString(">", textX-25, textY);
		}
		
		// SE
		textY += gp.tileSize;
		g2.drawString("SE", textX, textY);
		if(commandNum == 2) {
			g2.drawString(">", textX-25, textY);
		}
		
		// CONTROL
		textY += gp.tileSize;
		g2.drawString("CONTROL", textX, textY);
		if(commandNum == 3) {
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				subState =2;
				commandNum =0;
			}
		}
		
		// END GAME
		textY += gp.tileSize;
		g2.drawString("End Game", textX, textY);
		if(commandNum == 4) {
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 3;
				commandNum = 0;
			}
		}
		
		// BACK
		textY += gp.tileSize*2;
		g2.drawString("Back", textX, textY);
		if(commandNum == 5) {
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				gp.gameState = gp.playState;
				commandNum = 0;
			}
		}
		
		// FULL SCREEN CHECK BOX
		textX = frameX + (int) (gp.tileSize*4.5);
		textY = frameY +gp.tileSize*2 +24;
		g2.setStroke(new BasicStroke(3));
		g2.drawRect(textX, textY, 24, 24);
		if(gp.fullScreenOn == true) {
			g2.fillRect(textX, textY, 24, 24);
		}
		
		// MUSIC VOLUME
		textY += gp.tileSize;
		g2.drawRect(textX, textY, 120, 24); // 120/5 = 24
		int volumeWidth = 24 * gp.music.volumeScale;
		g2.fillRect(textX, textY, volumeWidth, 24);
		
		// SE VOLUME
		textY += gp.tileSize;
		g2.drawRect(textX, textY, 120, 24);
		volumeWidth = 24 * gp.se.volumeScale;
		g2.fillRect(textX, textY, volumeWidth, 24);
		
		gp.config.saveConfig();
	}
	/**
	 * This display the full screen message option.
	 * @param frameX this frame X
	 * @param frameY this frame X
	 */
	public void options_fullscreenNotification(int frameX, int frameY) {
		
		int textX = frameX + gp.tileSize;
		int textY = frameY + gp.tileSize*3;
		
		currentDialogue = "The change will take \nplace after restarting \nthe game.";
		
		for(String line: currentDialogue.split("\n")) {
			g2.drawString(line, textX, textY);
			textY += 40;
		}
		
		// BACK
		textY =  frameY + gp.tileSize*9;
		g2.drawString("Back", textX, textY);
		if(commandNum == 0) {
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 0;
			}
		}
	}
	/**
	 * This display the control options.
	 * @param frameX this frame X
	 * @param frameY this frame y
	 */
	public void options_control(int frameX, int frameY) {
		
		int textX;
		int textY;
		
		// TITLE
		String text = "Control";
		textX = getXforCenteredText(text);
		textY = frameY + gp.tileSize;
		g2.drawString(text, textX, textY);
		
		textX = frameX + gp.tileSize;
		textY += gp.tileSize;
		g2.drawString("Move", textX, textY); textY+=gp.tileSize;
		g2.drawString("Confirm/Attack", textX, textY); textY+=gp.tileSize;
		g2.drawString("Shoot/Cast", textX, textY); textY+=gp.tileSize;
		g2.drawString("Character Screen", textX, textY); textY+=gp.tileSize;
		g2.drawString("Pause", textX, textY); textY+=gp.tileSize;
		g2.drawString("Options", textX, textY); textY+=gp.tileSize;
		
		textX = frameX + gp.tileSize*6;
		textY = frameY + gp.tileSize*2;
		g2.drawString("WASD", textX, textY); textY += gp.tileSize;
		g2.drawString("ENTER", textX, textY); textY += gp.tileSize;
		g2.drawString("F", textX, textY); textY += gp.tileSize;
		g2.drawString("C", textX, textY); textY += gp.tileSize;
		g2.drawString("P", textX, textY); textY += gp.tileSize;
		g2.drawString("ESC", textX, textY); textY += gp.tileSize;
		
		// BACK
		textX = frameX + gp.tileSize;
		textY = frameY + gp.tileSize*9;
		g2.drawString("Back", textX, textY);
		if(commandNum == 0) {
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 0;
				commandNum = 3;
			}
		}
	}
	/**
	 * This display the end game affirmation.
	 * @param frameX this frame X
	 * @param frameY this frame Y
	 */
	public void options_endGameConfirmation(int frameX, int frameY) {

		
		int textX = frameX + gp.tileSize;
		int textY = frameY + gp.tileSize*3;
		currentDialogue = "Quit the game and return \nto the title screen?";
		
		for(String line: currentDialogue.split("\n")) {
			g2.drawString(line, textX, textY);
			textY += 40;
		}
		
		// YES
		String text  = "Yes";
		textX = getXforCenteredText(text);
		textY += gp.tileSize*3;
		g2.drawString(text, textX, textY);
		if(commandNum == 0) {
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 0;
				titleScreenState = 0;
				gp.gameState = gp.titleState;
			}
		}
		
		// NO
		text = "No";
		textX = getXforCenteredText(text);
		textY += gp.tileSize;
		g2.drawString(text, textX, textY);
		if(commandNum == 1) {
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 0;
				commandNum = 4;
			}
		}
	}
	/**
	 * displays the game over screen
	 */
	public void	drawGameOverScreen(){
		g2.setColor(new Color(0,0,0,255));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		int x;
		int y;
		String text;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));
		
		text = "Game Over";
		g2.setColor(Color.black);
		x = getXforCenteredText(text);
		y = gp.tileSize*4;
		g2.drawString(text, x, y);
		
		// Main
		g2.setColor(Color.white);
		g2.drawString(text, x-4, y-4);
		
		// RETRY
		g2.setFont(g2.getFont().deriveFont(50f));
		text = "Retry";
		x = getXforCenteredText(text);
		y += gp.tileSize*4;
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			g2.drawString(">", x-40, y);
		}
		
		// BACK TO THE TITLE SCREEN
		text = "Quit";
		x = getXforCenteredText(text);
		y += 55;
		g2.drawString(text, x, y);
		if(commandNum == 1) {
			g2.drawString(">", x-40, y);
		}
	}
	/**
	 * This returns the item index on slot.
	 * @return this item index.
	 */
	public int getItemIndexOnSlot() {
		int itemIndex = slotCol + (slotRow*5);
		return itemIndex;
	}
	/**
	 * This displays the sub window.
	 * @param x this x coordinate of the rectangle to be filled.
	 * @param y this y coordinate of the rectangle to be filled.
	 * @param width this width of the rectangle to be filled.
	 * @param height this height of the rectangle to be filled.
	 */
	public void drawSubWindow(int x, int y, int width, int height) {
		
		Color c = new Color(0,0,0,200);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c = new Color(255,255,255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
	}
	/**
	 * This displays the centered text.
	 * @param text
	 * @return this centered text
	 */
	public int getXforCenteredText(String text) {
		
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		
		return x;
	}
	/**
	 * This displays the aligned text.
	 * @param text 
	 * @param tailX 
	 * @return this aligned Text
	 */
	public int getXforAlignToRightText(String text, int tailX) {
		
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = tailX - length;
		
		return x;
	}

		
		
}
