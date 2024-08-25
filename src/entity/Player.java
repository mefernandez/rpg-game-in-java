package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler kh;
	public Player(GamePanel gp, KeyHandler kh) {
		super();
		this.gp = gp;
		this.kh = kh;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		this.x = 100;
		this.y = 100;
		this.speed = 4;
		this.direction = "down";
	}
	
	public void getPlayerImage() {
		
		try {
			this.up1 = ImageIO.read(getClass().getResourceAsStream("/player/yo.png"));
			this.up2 = ImageIO.read(getClass().getResourceAsStream("/player/yo.png"));
			this.down1 = ImageIO.read(getClass().getResourceAsStream("/player/yo.png"));
			this.down2 = ImageIO.read(getClass().getResourceAsStream("/player/yo.png"));
			this.left1 = ImageIO.read(getClass().getResourceAsStream("/player/yo.png"));
			this.left2 = ImageIO.read(getClass().getResourceAsStream("/player/yo.png"));
			this.right1 = ImageIO.read(getClass().getResourceAsStream("/player/pixel.png"));
			this.right2 = ImageIO.read(getClass().getResourceAsStream("/player/yo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update() {
		if (this.kh.upPressed == true) {
			this.direction = "up";
			this.y -= this.speed;
			
		} else if (this.kh.downPressed == true) {
			this.direction = "down";
			this.y += this.speed;
			
		} else if (this.kh.leftPressed == true) {
			this.direction = "left";
			this.x -= this.speed;
			
		} else if (this.kh.rightPressed == true) {
			this.direction = "right";
			this.x += this.speed;
			
		}		
	}
	
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(this.x, this.y, gp.tileSize, gp.tileSize);

		BufferedImage image = null;
		switch (this.direction) {
		case "up":
			image = up1;
			break;
		case "down":
			image = down1;
			break;
		case "left":
			image = left1;
			break;
		case "right":
			image = right1;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.direction);
		}
		
		g2.drawImage(image, this.x, this.y, gp.tileSize, gp.tileSize, null);
		
	}
}
