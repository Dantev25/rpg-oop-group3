package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * 
 * class to allow keyboard input and handle cursor/player movements
 * @author Oomar
 * @author Sadiyah
 * @author Mrish
 */
public class KeyHandler implements KeyListener{
	
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, shotKeyPressed;
	public int playerType;
	//DEBUG
	boolean showDebugText = false;
	/**
	 * constructor
	 * @param gp gamepanel
	 */
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	
	}

	/**
	 * method to input the keys pressed into each game state
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		// TITLE STATE
		if(gp.gameState == gp.titleState) {
			
			titleState(code);
			
		}
			
		//PLAYSTATE
	    else if(gp.gameState == gp.playState) {
			playState(code);
		}
		//PAUSESTATE
		else if (gp.gameState == gp.pauseState) {
			pauseState(code);
		}
		//DIALOGSTATE
		else if (gp.gameState == gp.dialogueState) {
			dialogueState(code);
		}
		// CHARACTERSTATE
		else if (gp.gameState == gp.characterState) {
			characterState(code);
		}
		
		// OPTIONS STATE
		else if (gp.gameState == gp.optionsState) {
			optionsState(code);
		}
		
		// GAME OVER STATE
		else if (gp.gameState == gp.gameOverState) {
			gameOverState(code);
		}
	}
		
	/**
	 * method to navigate title state
	 * also handles navigation through character class choice
	 * @param code - numeric value of key pressed
	 */
		public void titleState(int code) {
			
			if(gp.ui.titleScreenState == 0) {
				
				if(code == KeyEvent.VK_W) {
					gp.ui.commandNum--;
					
					if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
					}
				}
				if(code == KeyEvent.VK_S) {
					gp.ui.commandNum++;
					
					if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
					}
				}
				if(code == KeyEvent.VK_ENTER) {
					if(gp.ui.commandNum == 0) {
						gp.ui.titleScreenState = 1;						
					}
					if(gp.ui.commandNum == 1) {
						//add later
					}
					if(gp.ui.commandNum == 2) {
						System.exit(0);
					}
				
			}
		}
		else if(gp.ui.titleScreenState == 1) {
				
				if(code == KeyEvent.VK_W) {
					gp.ui.commandNum--;
					
					if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 3;
					}
				}
				if(code == KeyEvent.VK_S) {
					gp.ui.commandNum++;
					
					if(gp.ui.commandNum > 3) {
					gp.ui.commandNum = 0;
					}
				}
				if(code == KeyEvent.VK_ENTER) {
					if(gp.ui.commandNum == 0) {
						playerType = 0;
						gp.player.updateDefaultValues(playerType);
						gp.gameState = gp.playState;
						gp.playMusic(0);
					}
					if(gp.ui.commandNum == 1) {
						playerType = 1;
						gp.player.updateDefaultValues(playerType);
						gp.gameState = gp.playState;
						gp.playMusic(0);
					}
					if(gp.ui.commandNum == 2) {
						playerType = 2;
						gp.player.updateDefaultValues(playerType);
						gp.gameState = gp.playState;
						gp.playMusic(0);
					}
					if(gp.ui.commandNum == 3) {
						gp.ui.titleScreenState = 0;
					}
				
				}
			
			}
			
	}
		/**
		 * method to move and do player specific actions using certain keys
		 * w/a/s/d move
		 * p pause
		 * t telemetry
		 * c character stats
		 * enter npc dialogue engage/attack/engage event
		 * f shoot projectile(mage and warrior only)
		 * @param code - numeric value of key pressed
		 */
		public void playState(int code) {
			
			if(code == KeyEvent.VK_W) {
				upPressed = true;
			}
			
			if(code == KeyEvent.VK_S) {
				downPressed = true;
				
    		}
			
			if(code == KeyEvent.VK_A) {
				leftPressed = true;
			}
			
			if(code == KeyEvent.VK_D) {
				rightPressed = true;
				
			}
			
			if(code == KeyEvent.VK_P) {
				gp.gameState = gp.pauseState;
				gp.stopMusic();
			
			}
			if(code == KeyEvent.VK_C) {
				gp.gameState = gp.characterState;
				
			}
			if(code == KeyEvent.VK_ENTER) {
				enterPressed = true;
			}
			
			if(code == KeyEvent.VK_F) {
				if (playerType == 1) {
					shotKeyPressed = false;
				}
				else {
					shotKeyPressed = true;
				}
				
			}
			
			if(code == KeyEvent.VK_ESCAPE) {
				gp.gameState = gp.optionsState;
			}
			
			//DEBUG
			if(code == KeyEvent.VK_T) {
				if (showDebugText == false) {
					showDebugText = true;
				}
				else if (showDebugText == true) {
					showDebugText = false;
				}
				
			}
			
			if(code == KeyEvent.VK_R) {
				gp.tileM.loadMap("/maps/worldV2.txt");
			}
		}
		/**
		 * method to enter pause state
		 * @param code - numeric value of key pressed
		 */
		public void pauseState(int code) {
			
			if(code == KeyEvent.VK_P) {
				gp.gameState = gp.playState;
				gp.playMusic(0);
			
			}
		}
		/**
		 * method to enter dialogue state
		 * @param code - numeric value of key pressed
		 */
		public void dialogueState(int code) {
			
			if(code == KeyEvent.VK_ENTER) {
				gp.gameState = gp.playState;
			}
		}
		/**
		 * method to enter and navigate character inventory/stats screen
		 * @param code - numeric value of key pressed
		 */
		public void characterState(int code) {
			
			if(code == KeyEvent.VK_C) {
				gp.gameState = gp.playState;
			}
			
			if(code == KeyEvent.VK_W) {
				if(gp.ui.slotRow !=0) {
					gp.ui.slotRow--;
					gp.playSE(9);
				}
			}
			
            if(code == KeyEvent.VK_A) {
            	if(gp.ui.slotCol !=0) {
            		gp.ui.slotCol--;
                	gp.playSE(9);
            	}
			}
            
            if(code == KeyEvent.VK_S) {
            	if(gp.ui.slotRow !=3) {
            		gp.ui.slotRow++;
                	gp.playSE(9);
            	}
			}

            if(code == KeyEvent.VK_D) {
            	if(gp.ui.slotCol !=4) {
            		gp.ui.slotCol++;
                	gp.playSE(9);
            	}
			}
            
            if(code == KeyEvent.VK_ENTER) {
            	gp.player.selectItem();
            }
	}
		
		/**
		 * method to enter option menu and navigate through choices
		 * @param code - numeric value of key pressed
		 */
	public void optionsState(int code) {
		
		if(code == KeyEvent.VK_ESCAPE) {
			gp.gameState = gp.playState;
		}
		
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}
		
		int maxCommandNum = 0;
		switch(gp.ui.subState) {
		case 0: maxCommandNum = 5; break;
		case 3: maxCommandNum = 1; break;
		}
		
		if(code == KeyEvent.VK_W) {
			gp.ui.commandNum--;
			gp.playSE(9);
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = maxCommandNum;
			}
		}
		
		if(code == KeyEvent.VK_S) {
			gp.ui.commandNum++;
			gp.playSE(9);
			if(gp.ui.commandNum > maxCommandNum) {
				gp.ui.commandNum = 0;
			}
		}
		
		if(code == KeyEvent.VK_A) {
			if(gp.ui.subState == 0) {
				if(gp.ui.commandNum == 1 && gp.music.volumeScale > 0) {
					gp.music.volumeScale--;
					gp.music.checkVolume();
					gp.playSE(9);
				}
				if(gp.ui.commandNum == 2 && gp.se.volumeScale > 0) {
					gp.se.volumeScale--;
					gp.playSE(9);
				}
			}
		}
		
		if(code == KeyEvent.VK_D) {
			if(gp.ui.subState == 0) {
				if(gp.ui.commandNum == 1 && gp.music.volumeScale < 5) {
					gp.music.volumeScale++;
					gp.music.checkVolume();
					gp.playSE(9);
				}
				if(gp.ui.commandNum == 2 && gp.se.volumeScale < 5) {
					gp.se.volumeScale++;
					gp.playSE(9);
				}
			}
		}
	}
	/**
	 * method to navigate through game over screen
	 * @param code - numeric value of key pressed
	 */
	public void gameOverState(int code) {
		
		if(code == KeyEvent.VK_W) {
			gp.ui.commandNum--;
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = 1;
			}
			gp.playSE(9);
		}
		
		if(code == KeyEvent.VK_S) {
			gp.ui.commandNum++;
			if(gp.ui.commandNum > 1) {
				gp.ui.commandNum = 0;
			}
			gp.playSE(9);
		}
		
		if(code == KeyEvent.VK_ENTER) {
			if(gp.ui.commandNum == 0) {
				gp.gameState = gp.playState;
				gp.retry();
			}
			else if(gp.ui.commandNum == 1) {
				gp.gameState = gp.titleState;
				gp.restart();
			}
		}
	}
	/**
	 * method to check whether a key has been released or not
	 * @param e object of type KeyEvent allowing keyboard input
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		
		if(code == KeyEvent.VK_S) {
			downPressed = false;
			
		}
		
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
			
		}
		
		if(code == KeyEvent.VK_F) {
			shotKeyPressed = false;
		}
	}
	
}
	
	

