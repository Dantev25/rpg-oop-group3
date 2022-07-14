package main;
/**
 * handles events such as healing points, and damage traps
 * @author mrish
 * @author Oomar
 * @author Sadiyah
 *
 */
public class EventHandler {
	
	GamePanel gp;
	EventRect eventRect[][];
	
	int previousEventX, previousEventY;
	boolean canTouchEvent = true;
	/**
	 * constructor for EventHandler
	 * @param gp - gamepanel object
	 */
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];
		
		int col = 0;
		int row = 0;
		while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
			
			eventRect[col][row] = new EventRect();
			eventRect[col][row].x = 23;
			eventRect[col][row].y = 23;
			eventRect[col][row].width = 2;
			eventRect[col][row].height = 2;
			eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
			eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;
			
			col++;
			if(col == gp.maxWorldCol) {
				col = 0;
				row++;
			}
		}
		
		
		
	}
	/**
	 * checks whether the player has encountered an event
	 */
	public void checkEvent() {
		
		// Check if the player character is more than one tile away from the last event
		int xDistance = Math.abs(gp.player.worldX - previousEventX);
		int yDistance = Math.abs(gp.player.worldY - previousEventY);
		int distance = Math.max(xDistance, yDistance);
		if(distance > gp.tileSize) {
			canTouchEvent = true;
		}
		if(canTouchEvent == true) {
			if(hit(27,16,"right") == true) {damagePit(27,16,gp.dialogueState);}
			if(hit(23,23,"any") == true) {damagePit(23,23,gp.dialogueState);}
			if(hit(30,12,"up") == true) {healingPool(30,12,gp.dialogueState);}
		}
		
	}
	/**
	 * checks whether the player is making contact with the event
	 * @param col column location of the event
	 * @param row row location of the event
	 * @param reqDirection required direction to set off the event
	 * @return
	 */
	public boolean hit(int col, int row, String reqDirection) {
		
		boolean hit = false;
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		eventRect[col][row].x = col*gp.tileSize + eventRect[col][row].x;
		eventRect[col][row].y = row*gp.tileSize + eventRect[col][row].y;
		
		if(gp.player.solidArea.intersects(eventRect[col][row]) && eventRect[col][row].eventDone == false) {
			if(gp.player.direction.equals(reqDirection)|| reqDirection.contentEquals("any")){
				hit = true;
				
				previousEventX = gp.player.worldX;
				previousEventY = gp.player.worldY;
			}
		}
				
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;
		eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
		eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;
		
		return hit;
	}
	/**
	 * trap to deal damage
	 * @param col column location of the event
	 * @param row row location of the event
	 * @param gameState game state
	 */
	public void damagePit(int col, int row, int gameState) {
		gp.gameState = gameState;
		gp.playSE(6);
		gp.ui.currentDialogue = "You fell into a poisonous pit";
		gp.player.life -= 1;
		//eventRect[col][row].eventDone = true;
		canTouchEvent = false;
		
	}
	/**
	 * event to heal and give max mana
	 * @param col column location of the event
	 * @param row row location of the event
	 * @param gameState game state
	 */
	public void healingPool(int col, int row, int gameState) {
		
		if(gp.keyH.enterPressed == true) {
			gp.gameState = gameState;
			gp.player.attackCanceled = true;
			gp.playSE(2);
			gp.ui.currentDialogue = "You drunk water. \nYour life and mana have been recovered.";
			gp.player.life = gp.player.maxLife;
			gp.player.mana = gp.player.maxMana;
			gp.aSetter.setMonster();
		}
	}
}















