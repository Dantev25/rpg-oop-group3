package main;

import entity.NPC_Oldman;
import monster.MON_GreenSlime;
import object.OBJ_Axe;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_ManaCrystal;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;
import tile_interactive.IT_DryTree;
import tile_interactive.IT_Trunk;


public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
		
	public void setObject() {
		
		int i = 0;
		gp.obj[i] = new OBJ_Coin_Bronze(gp);
		gp.obj[i].worldX = gp.tileSize*25;
		gp.obj[i].worldY = gp.tileSize*23;
		i++;
		
		gp.obj[i] = new OBJ_Coin_Bronze(gp);
		gp.obj[i].worldX = gp.tileSize*21;
		gp.obj[i].worldY = gp.tileSize*19;
		i++;
		
		gp.obj[i] = new OBJ_Coin_Bronze(gp);
		gp.obj[i].worldX = gp.tileSize*26;
		gp.obj[i].worldY = gp.tileSize*21;
		i++;
		
		gp.obj[i] = new OBJ_Axe(gp);
		gp.obj[i].worldX = gp.tileSize*33;
		gp.obj[i].worldY = gp.tileSize*21;
		i++;
		
		gp.obj[i] = new OBJ_Shield_Blue(gp);
		gp.obj[i].worldX = gp.tileSize*35;
		gp.obj[i].worldY = gp.tileSize*21;
		i++;
		
		gp.obj[i] = new OBJ_Heart(gp);
		gp.obj[i].worldX = gp.tileSize*22;
		gp.obj[i].worldY = gp.tileSize*29;
		i++;
		
		gp.obj[i] = new OBJ_ManaCrystal(gp);
		gp.obj[i].worldX = gp.tileSize*22;
		gp.obj[i].worldY = gp.tileSize*31;
		i++;
	}
	
	public void setNPC() {
		int i = 0;
		gp.npc[i] = new NPC_Oldman(gp);
		gp.npc[i].worldX = gp.tileSize * 21;
		gp.npc[i].worldY = gp.tileSize * 21;
		i++;
//		gp.npc[0] = new NPC_Oldman(gp);
//		gp.npc[0].worldX = gp.tileSize * 9;
//		gp.npc[0].worldY = gp.tileSize * 10;
//		
	}
	
	public void setMonster() {
		int i = 0;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 23;
		gp.monster[i].worldY = gp.tileSize * 36;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 23;
		gp.monster[i].worldY = gp.tileSize * 37;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 21;
		gp.monster[i].worldY = gp.tileSize * 23;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 11;
		gp.monster[i].worldY = gp.tileSize * 10;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 11;
		gp.monster[i].worldY = gp.tileSize * 11;
		i++;
		
	}
	
	public void setInteractiveTile() {
		
		int i = 0;
		gp.iTile[i] = new IT_DryTree(gp,27,12);i++;
		gp.iTile[i] = new IT_DryTree(gp,28,12);i++;
		gp.iTile[i] = new IT_DryTree(gp,29,12);i++;
		gp.iTile[i] = new IT_DryTree(gp,30,12);i++;
		gp.iTile[i] = new IT_DryTree(gp,31,12);i++;
		gp.iTile[i] = new IT_DryTree(gp,32,12);i++;
		gp.iTile[i] = new IT_DryTree(gp,33,12);i++;
		gp.iTile[i] = new IT_Trunk(gp,30,22);i++;
		gp.iTile[i] = new IT_DryTree(gp,30,20);i++;
		gp.iTile[i] = new IT_DryTree(gp,30,21);i++;
		gp.iTile[i] = new IT_DryTree(gp,20,20);i++;
		gp.iTile[i] = new IT_DryTree(gp,20,21);i++;
		gp.iTile[i] = new IT_DryTree(gp,20,22);i++;
		gp.iTile[i] = new IT_DryTree(gp,22,24);i++;
		gp.iTile[i] = new IT_DryTree(gp,23,24);i++;
		gp.iTile[i] = new IT_DryTree(gp,24,24);i++;
	
	
}
	
}
