package tile_interactive;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the Interactive Tile 
 * This class inherits the class Entity.
 * @author Sadiyah
 *
 */
public class InteractiveTile extends Entity{
	
	GamePanel gp;
	public boolean destructible = false;

	public InteractiveTile(GamePanel gp, int col, int row) {
		super(gp);
		this.gp = gp;
	}
	public boolean isCorrectItem(Entity entity) {
		boolean isCorrectItem = false;
		return isCorrectItem;
	}
	/**
	 * This method plays the sound effects 11.
	 */
	public void playSE() {
		
	}
	/**
	 * This returns the interactive tile trunk.
	 */
	public InteractiveTile getDestroyedForm() {
		InteractiveTile tile = null;
		return tile;
	}
	/**
	 * This updates dry tree invincible state.
	 */
	public void update()
	{
		if (invincible == true) {
			invincibleCounter++;
			if(invincibleCounter>20) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
	}
	/**
	 * This method draws the interactive tile onto the screen
	 * @param g2 graphics object to display the tile
	 */
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if (	worldX + gp.tileSize> gp.player.worldX - gp.player.screenX &&
				worldX - gp.tileSize< gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize> gp.player.worldY - gp.player.screenY && 
				worldY - gp.tileSize< gp.player.worldY + gp.player.screenY) {
					
			g2.drawImage(down1,screenX,screenY, null);
		}
	}
}


