package main;

import javax.swing.JFrame;

/**
 * This class implements the JFrame Window.
 * @author mrish
 * @author Oomar
 * @author Sadiyah
 */

public class Main {
	
	/**
	 * This method constructs the JFrame Window.
	 */
	
	public static JFrame window;
	
	/**
	 * This field sets the features of the new frame.
	 * @param args
	 */

	public static void main(String[] args) {
		
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2D Rpg");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		gamePanel.config.loadConfig();
		if(gamePanel.fullScreenOn == true) {
			window.setUndecorated(true);
		}
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.setupGame();
		gamePanel.startGameThread();
	}

}
