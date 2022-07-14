package tile_interactive;

import main.GamePanel;
/**
 * This class implements the Interactive Tile Trunk
 * This class inherits the class Interactive Tile
 * @author Sadiyah
 *
 */
public class IT_Trunk extends InteractiveTile{
	
		/**
		 * constructor for interactive tile trunk
		 * @param gp gamepanel
		 * @param col x location 
		 * @param row y location
		 */
		public IT_Trunk(GamePanel gp, int col, int row) {
		super(gp,col,row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		down1 = setup("/tile_interactive/trunk",gp.tileSize,gp.tileSize);
		
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = 0;
		solidArea.height = 0;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
	}
}
