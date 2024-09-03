package org.example.rpg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.example.rpg.entity.Player;
import org.example.rpg.object.SuperObject;
import org.example.rpg.tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale; // 48x48
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public Player player = new Player(this, keyH);
	public SuperObject obj[] = new SuperObject[10];
	
	// Set player's default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	// WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
//	public final int worldWidth = tileSize * maxWorldCol;
//	public final int worldHeight = tileSize * maxWorldRow;
	
	int fps = 60;
	
	TileManager tileM = new TileManager(this);
	
	Sound sound = new Sound();
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		aSetter.setObject();
		this.playMusic(0);
	}
	
	public void startGameThread() {
		this.gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		// GAME LOOP
		double drawInterval = 1_000_000_000 / fps; // 0.016666 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while (gameThread != null) {

			// 1: UPDATE info such as character positions
			update();
			// 2: DRAW the screen with the updated info
			repaint();
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1_000_000; // convert to millis
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long)remainingTime);
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		player.update();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		// TILES
		tileM.draw(g2);
		
		// OBJECTS
		for(int i = 0; i < obj.length; i++) {
			if (obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		player.draw(g2);
		
		g2.dispose();
	}
	
	public void playMusic(int i) {
		this.sound.setFile(i);
		this.sound.play();
		this.sound.loop();
	}
	
	public void stopMusic() {
		this.sound.stop();
	}
	
	public void playSoundEffect(int i) {
		this.sound.setFile(i);
		this.sound.play();		
	}

}
