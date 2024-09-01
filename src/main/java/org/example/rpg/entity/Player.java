package org.example.rpg.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.example.rpg.GamePanel;
import org.example.rpg.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler kh;
	
	public final int screenX;
	public final int screenY;
	
	public Player(GamePanel gp, KeyHandler kh) {
		super();
		this.gp = gp;
		this.kh = kh;
		this.screenX = gp.screenWidth / 2 - (gp.tileSize/2);
		this.screenY = gp.screenHeight / 2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		this.worldX = gp.tileSize * 23;
		this.worldY = gp.tileSize * 21;
		this.speed = 4;
		this.direction = "down";
	}
	
	public void getPlayerImage() {
		
		try {
			this.up0 = ImageIO.read(getClass().getResourceAsStream("/player/bobble-stand-up.png"));
			this.up1 = ImageIO.read(getClass().getResourceAsStream("/player/bobble-up-1.png"));
			this.up2 = ImageIO.read(getClass().getResourceAsStream("/player/bobble-up-2.png"));
			this.down0 = ImageIO.read(getClass().getResourceAsStream("/player/bobble-stand-down.png"));
			this.down1 = ImageIO.read(getClass().getResourceAsStream("/player/bobble-down-1.png"));
			this.down2 = ImageIO.read(getClass().getResourceAsStream("/player/bobble-down-2.png"));
			this.left0 = ImageIO.read(getClass().getResourceAsStream("/player/bobble-stand-left.png"));
			this.left1 = ImageIO.read(getClass().getResourceAsStream("/player/bobble-left-1.png"));
			this.left2 = ImageIO.read(getClass().getResourceAsStream("/player/bobble-left-2.png"));
			this.right0 = ImageIO.read(getClass().getResourceAsStream("/player/bobble-stand-right.png"));
			this.right1 = ImageIO.read(getClass().getResourceAsStream("/player/bobble-right-1.png"));
			this.right2 = ImageIO.read(getClass().getResourceAsStream("/player/bobble-right-2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update() {
		if (this.kh.upPressed == true) {
			this.direction = "up";
		} else if (this.kh.downPressed == true) {
			this.direction = "down";
		} else if (this.kh.leftPressed == true) {
			this.direction = "left";
		} else if (this.kh.rightPressed == true) {
			this.direction = "right";
		} else {
			this.spriteCounter = 10;
			this.spriteNum = 0;
			return;
		}
		
		// CHECK TILE COLLISION
		collisionOn = false;
		gp.cChecker.checkTile(this);
		
		// IF COLLISION IS FALSE, PLAYER CAN MOVE
		if (collisionOn == false) {
			switch(direction) {
			case "up":
				this.worldY -= this.speed;
				break;
			case "down":
				this.worldY += this.speed;
				break;
			case "left":
				this.worldX -= this.speed;
				break;
			case "right":
				this.worldX += this.speed;			
				break;
			}
		}
		
		this.spriteCounter++;
		if (this.spriteCounter > 10) {
			if (this.spriteNum == 0) {
				this.spriteNum = 1;
			} else if (this.spriteNum == 1) {
				this.spriteNum = 2;
			} else if (this.spriteNum == 2) {
				this.spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(this.x, this.y, gp.tileSize, gp.tileSize);

		BufferedImage image = null;
		switch (this.direction) {
		case "up":
			if (this.spriteNum == 0) {
				image = up0;
			}
			if (this.spriteNum == 1) {
				image = up1;
			}
			if (this.spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if (this.spriteNum == 0) {
				image = down0;
			}
			if (this.spriteNum == 1) {
				image = down1;
			}
			if (this.spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if (this.spriteNum == 0) {
				image = left0;
			}
			if (this.spriteNum == 1) {
				image = left1;
			}
			if (this.spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if (this.spriteNum == 0) {
				image = right0;
			}
			if (this.spriteNum == 1) {
				image = right1;
			}
			if (this.spriteNum == 2) {
				image = right2;
			}
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.direction);
		}
		
		g2.drawImage(image, this.screenX, this.screenY, gp.tileSize, gp.tileSize, null);
		
	}
}
