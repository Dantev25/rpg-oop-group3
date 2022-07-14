package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;
/**
 * 
 * Subclass of class Entity, used to create particles when attacking and receiving attacks
 * @author Sadiyah
 *
 */
public class Particle extends Entity{
	
	Entity generator;
	Color color;
	int size;
	int xd;
	int yd;
	/**
	 * constructor
	 * @param gp gamepanel
	 * @param generator entity causing the particle
	 * @param color color of the particle
	 * @param size size of the particle
	 * @param speed speed of particle
	 * @param maxLife maxlife of particle
	 * @param xd x-direction of particle
	 * @param yd y-direction of particle 
	 */
	public Particle(GamePanel gp, Entity generator, Color color, int size, int speed, int maxLife, int xd, int yd) {
		super(gp);
		
		this.generator = generator;
		this.color = color;
		this.size = size;
		this.speed = speed;
		this.maxLife = maxLife;
		this.xd = xd;
		this.yd = yd;
		
		life = maxLife;
		int offset = (gp.tileSize/2) - (size/2);
		worldX = generator.worldX + offset;
		worldY = generator.worldY + offset;
	}
	/**
	 * updates the particle life and speed
	 */
	public void update() {
		
		life--;
		
		if(life < maxLife/3) {
			yd++;
		}
		
		worldX += xd*speed;
		worldY += yd*speed;
		
		if(life == 0) {
			alive = false;
		}
		
	}
	
	/**
	 * method to display the particle
	 * @param g2 - graphics object used to display the object onto the screen
	 */
	public void draw(Graphics2D g2) {
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		g2.setColor(color);
		g2.fillRect(screenX, screenY, size, size);
		
	}

}
