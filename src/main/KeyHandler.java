package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
	//DEBUG
	boolean checkDrawTime = false;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		// TITLE STATE
		if(gp.gameState == gp.titleState) {
			
			if(code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
			}
			if(code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
			}
		}
		//PLAYSTATE
		if(gp.gameState == gp.playState) {
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
			if(code == KeyEvent.VK_ENTER) {
				enterPressed = true;
				
			
			}
			//DEBUG
			if(code == KeyEvent.VK_T) {
				if (checkDrawTime == false) {
					checkDrawTime = true;
				}
				else if (checkDrawTime == true) {
					checkDrawTime = false;
				}
				
			}
		}
		
		
		//PAUSESTATE
		
		else if (gp.gameState == gp.pauseState) {
			if(code == KeyEvent.VK_P) {
				gp.gameState = gp.playState;
				gp.playMusic(0);
			
			}
		}
		
		//DIALOGSTATE
		
		else if (gp.gameState == gp.dialogueState) {
			if(code == KeyEvent.VK_ENTER) {
				gp.gameState = gp.playState;
			}
		}

}

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
	}
	
	
}
