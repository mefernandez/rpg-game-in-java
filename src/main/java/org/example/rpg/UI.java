package org.example.rpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import org.example.rpg.object.KeyObject;

public class UI {
	
	GamePanel gp;
	Font arial40, arial80Bold;
	BufferedImage keyImage;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	
	double playTime;
	DecimalFormat df = new DecimalFormat("#0.00");
	
	public UI(GamePanel gp) {
		super();
		this.gp = gp;
		this.arial40 = new Font("Arial", Font.PLAIN, 40);
		this.arial80Bold = new Font("Arial", Font.BOLD, 80);
		KeyObject key = new KeyObject();
		this.keyImage = key.image;
	}
	
	public void showMessage(String text) {
		this.message = text;
		this.messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		if (this.gameFinished == true) {
			String text;
			int textLength;
			int x;
			int y;
			
			g2.setFont(arial40);
			g2.setColor(Color.WHITE);
			text = "You found the Treasure!";
			
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 - (gp.tileSize*3);
			
			g2.drawString(text, x, y);
			
			g2.setFont(arial40);
			g2.setColor(Color.WHITE);
			text = "Your time is " + df.format(playTime) + "!";
			
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize*4);
			
			g2.drawString(text, x, y);
			
			
			g2.setFont(arial80Bold);
			g2.setColor(Color.YELLOW);
			text = "Congratulations!";
			
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize*3);

			g2.drawString(text, x, y);

			gp.gameThread = null;
			
			
		} else {
			g2.setFont(arial40);
			g2.setColor(Color.WHITE);
			g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
			g2.drawString("x " + gp.player.hasKey, 74, 65);

			// TIME
			playTime += (double)1/60;
			g2.drawString("Time: " + df.format(playTime), gp.tileSize*11, 65);
			
			// MESSAGE
			if (this.messageOn == true) {
				g2.setFont(g2.getFont().deriveFont(30f));
				g2.drawString(this.message, gp.tileSize/2, gp.tileSize*5);
				this.messageCounter++;
				
				if (messageCounter > 120) {
					messageCounter = 0;
					messageOn = false;
				}
			}
		}
	}

}
