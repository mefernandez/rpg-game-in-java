package org.example.rpg.object;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ChestObject extends SuperObject {
	
	public ChestObject() {
		this.name = "Chest";
		try (InputStream is = getClass().getResourceAsStream("/objects/chest.png")) {
			this.image = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
