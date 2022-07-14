package tile_interactive;

import java.awt.Color;

import entity.Entity;
import main.GamePanel;
/**
 * This class implements the Interactive Tile Dry Tree
 * This class inherits the class Interactive Tile
 * @author Sadiyah
 *
 */
public class IT_DryTree extends InteractiveTile{

	GamePanel gp;
	
	public IT_DryTree(GamePanel gp, int col, int row) {
		super(gp,col,row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		down1 = setup("/tile_interactive/drytree",gp.tileSize,gp.tileSize);
		destructible = true;
		life = 3;
		
	}
	/**
	 * method checks if entity is holding the correct weapon type to cut the tree
	 * @return true if correct weapon type
	 */
	public boolean isCorrectItem(Entity entity) {
		boolean isCorrectItem = false;
		
		if(entity.currentWeapon.type == type_axe) {
			isCorrectItem = true;
		}
		
		return isCorrectItem;
	}
	/**
	 * This method plays the sound effects 11.
	 */
	public void playSE() {
		gp.playSE(11);
	}
	/**
	 * This returns the interactive tile trunk.
	 */
	public InteractiveTile getDestroyedForm() {
		InteractiveTile tile = new IT_Trunk(gp,worldX/gp.tileSize,worldY/gp.tileSize);
		return tile;
	}
	/**
	 * This gets the Particle color.
	 */
	public Color getParticleColor() {
		Color color = new Color(65,50,30);
		return color;
	}
	/**
	 * This gets the Particle size.
	 */
	public int getParticleSize() {
		int size = 6; // 6 pixels
		return size;
	}
	/**
	 * This gets the Particle speed.
	 */
	public int getParticleSpeed() {
		int speed = 1;
		return speed;
	}
	/**
	 * This gets the Particle maximum life.
	 */
	public int getParticleMaxLife() {
		int maxLife = 20;
		return maxLife;
	}

}
