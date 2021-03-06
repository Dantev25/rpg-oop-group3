package main;

import entity.NPC_Oldman;
import monster.MON_GreenSlime;
import monster.MON_Mage;
import object.OBJ_Axe;
import object.OBJ_Chest;
import object.OBJ_Coin_Bronze;
import object.OBJ_Door;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_ManaCrystal;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;
import tile_interactive.IT_DryTree;

/**
 * This class implements the objects: bronze coins, axe, blue shield, heart, mana crystal, 
 * the non-player character: old man, 
 * the monsters: green slimes and red mages and 
 * the interactive tile: dry trees and trunk on the map.
 * @author mrish
 * @author Oomar
 * @author Sadiyah
 * 
 */
public class AssetSetter {
	
	GamePanel gp;
	/**
	 * constructor for class asset setter
	 * @param gp gamepanel
	 */
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
		
	/**
	 * This method sets the objects bronze coins,axe, blue shield, heart, mana crystal
	 * on the map.
	 */
	public void setObject() {
		
		
		int i = 0;
		gp.obj[i] = new OBJ_Coin_Bronze(gp);
		gp.obj[i].worldX = gp.tileSize*29;
		gp.obj[i].worldY = gp.tileSize*23;
		i++;
		
		gp.obj[i] = new OBJ_Coin_Bronze(gp);
		gp.obj[i].worldX = gp.tileSize*25;
		gp.obj[i].worldY = gp.tileSize*20;
		i++;
		
		gp.obj[i] = new OBJ_Coin_Bronze(gp);
		gp.obj[i].worldX = gp.tileSize*31;
		gp.obj[i].worldY = gp.tileSize*21;
		i++;
	
		
		gp.obj[i] = new OBJ_Heart(gp);
		gp.obj[i].worldX = gp.tileSize*30;
		gp.obj[i].worldY = gp.tileSize*29;
		i++;
		
		gp.obj[i] = new OBJ_Potion_Red(gp);
		gp.obj[i].worldX = gp.tileSize*40;
		gp.obj[i].worldY = gp.tileSize*7;
		i++;
		
		gp.obj[i] = new OBJ_Potion_Red(gp);
		gp.obj[i].worldX = gp.tileSize*17;
		gp.obj[i].worldY = gp.tileSize*17;
		i++;
		
		gp.obj[i] = new OBJ_Potion_Red(gp);
		gp.obj[i].worldX = gp.tileSize*37;
		gp.obj[i].worldY = gp.tileSize*40;
		i++;
		
		
		gp.obj[i] = new OBJ_Heart(gp);
		gp.obj[i].worldX = gp.tileSize*37;
		gp.obj[i].worldY = gp.tileSize*37;
		i++;
		
		gp.obj[i] = new OBJ_Heart(gp);
		gp.obj[i].worldX = gp.tileSize*27;
		gp.obj[i].worldY = gp.tileSize*7;
		i++;
		gp.obj[i] = new OBJ_ManaCrystal(gp);
		gp.obj[i].worldX = gp.tileSize*28;
		gp.obj[i].worldY = gp.tileSize*7;
		i++;
		gp.obj[i] = new OBJ_ManaCrystal(gp);
		gp.obj[i].worldX = gp.tileSize*30;
		gp.obj[i].worldY = gp.tileSize*7;
		i++;
		gp.obj[i] = new OBJ_ManaCrystal(gp);
		gp.obj[i].worldX = gp.tileSize*31;
		gp.obj[i].worldY = gp.tileSize*7;
		i++;
		gp.obj[i] = new OBJ_ManaCrystal(gp);
		gp.obj[i].worldX = gp.tileSize*32;
		gp.obj[i].worldY = gp.tileSize*7;
		i++;
		gp.obj[i] = new OBJ_ManaCrystal(gp);
		gp.obj[i].worldX = gp.tileSize*29;
		gp.obj[i].worldY = gp.tileSize*7;
		i++;
		gp.obj[i] = new OBJ_Heart(gp);
		gp.obj[i].worldX = gp.tileSize*33;
		gp.obj[i].worldY = gp.tileSize*7;
		i++;
		gp.obj[i] = new OBJ_ManaCrystal(gp);
		gp.obj[i].worldX = gp.tileSize*30;
		gp.obj[i].worldY = gp.tileSize*31;
		i++;
		gp.obj[i] = new OBJ_ManaCrystal(gp);
		gp.obj[i].worldX = gp.tileSize*42;
		gp.obj[i].worldY = gp.tileSize*42;
		i++;
	
		gp.obj[i] = new OBJ_ManaCrystal(gp);
		gp.obj[i].worldX = gp.tileSize*44;
		gp.obj[i].worldY = gp.tileSize*25;
		i++;
		gp.obj[i] = new OBJ_ManaCrystal(gp);
		gp.obj[i].worldX = gp.tileSize*44;
		gp.obj[i].worldY = gp.tileSize*26;
		i++;
		
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize*32;
		gp.obj[i].worldY = gp.tileSize*16;
		i++;
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize*17;
		gp.obj[i].worldY = gp.tileSize*12;
		i++;
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize*21;
		gp.obj[i].worldY = gp.tileSize*26;
		i++;
		
		
		gp.obj[i] = new OBJ_Chest(gp, new OBJ_Axe(gp));
		gp.obj[i].worldX = gp.tileSize*39;
		gp.obj[i].worldY = gp.tileSize*16;
		i++;
		gp.obj[i] = new OBJ_Chest(gp, new OBJ_Key(gp));
		gp.obj[i].worldX = gp.tileSize*20;
		gp.obj[i].worldY = gp.tileSize*39;
		i++;
		gp.obj[i] = new OBJ_ManaCrystal(gp);
		gp.obj[i].worldX = gp.tileSize*35;
		gp.obj[i].worldY = gp.tileSize*12;
		i++;
		gp.obj[i] = new OBJ_Chest(gp, new OBJ_Key(gp));
		gp.obj[i].worldX = gp.tileSize*33;
		gp.obj[i].worldY = gp.tileSize*32;
		i++;
		gp.obj[i] = new OBJ_Chest(gp, new OBJ_Shield_Blue(gp));
		gp.obj[i].worldX = gp.tileSize*17;
		gp.obj[i].worldY = gp.tileSize*8;
		i++;
	}
	
	/**
	 * This method sets the old man non-player character 
	 * on the map. 
	 */
	
	public void setNPC() {
		
		int i = 0;
		gp.npc[i] = new NPC_Oldman(gp);
		gp.npc[i].worldX = gp.tileSize * 25;
		gp.npc[i].worldY = gp.tileSize * 21;
		i++;
		
	}
	
	/**
	 * This method sets the monsters slimes and mages
	 * on the map. 
	 */
	
	public void setMonster() {
		int i = 0;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 27;
		gp.monster[i].worldY = gp.tileSize * 36;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 27;
		gp.monster[i].worldY = gp.tileSize * 37;
		i++;
		gp.monster[i] = new MON_Mage(gp);
		gp.monster[i].worldX = gp.tileSize * 28;
		gp.monster[i].worldY = gp.tileSize * 37;
		i++;
		gp.monster[i] = new MON_Mage(gp);
		gp.monster[i].worldX = gp.tileSize * 17;
		gp.monster[i].worldY = gp.tileSize * 10;
		i++;
		
		gp.monster[i] = new MON_Mage(gp);
		gp.monster[i].worldX = gp.tileSize * 47;
		gp.monster[i].worldY = gp.tileSize * 8;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 45;
		gp.monster[i].worldY = gp.tileSize * 7;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 43;
		gp.monster[i].worldY = gp.tileSize * 8;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 36;
		gp.monster[i].worldY = gp.tileSize * 34;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 21;
		gp.monster[i].worldY = gp.tileSize * 34;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 19;
		gp.monster[i].worldY = gp.tileSize * 34;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 15;
		gp.monster[i].worldY = gp.tileSize * 19;
		i++;
		
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 44;
		gp.monster[i].worldY = gp.tileSize * 40;
		i++;
		
		
	}
	

	/**
	 * This method sets the dry trees and the trunk
	 * on the map. 
	 */
	
	public void setInteractiveTile() {
		
		int i = 0;
		
		
		gp.iTile[i] = new IT_DryTree(gp,38,12);i++;
		gp.iTile[i] = new IT_DryTree(gp,39,12);i++;
		gp.iTile[i] = new IT_DryTree(gp,40,12);i++;
		gp.iTile[i] = new IT_DryTree(gp,34,22);i++;
		gp.iTile[i] = new IT_DryTree(gp,34,20);i++;
		gp.iTile[i] = new IT_DryTree(gp,34,21);i++;
		gp.iTile[i] = new IT_DryTree(gp,24,20);i++;
		gp.iTile[i] = new IT_DryTree(gp,24,21);i++;
		gp.iTile[i] = new IT_DryTree(gp,24,22);i++;
		gp.iTile[i] = new IT_DryTree(gp,26,24);i++;
		gp.iTile[i] = new IT_DryTree(gp,27,24);i++;
		gp.iTile[i] = new IT_DryTree(gp,27,24);i++;
		gp.iTile[i] = new IT_DryTree(gp,17,35);i++;
		gp.iTile[i] = new IT_DryTree(gp,17,36);i++;
		gp.iTile[i] = new IT_DryTree(gp,40,34);i++;
		gp.iTile[i] = new IT_DryTree(gp,40,35);i++;
		gp.iTile[i] = new IT_DryTree(gp,36,40);i++;
	}
	
}
