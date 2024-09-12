package org.example.rpg.object;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class BootsObject extends SuperObject {

	public BootsObject() {
		this.name = "Boots";
		try (InputStream is = getClass().getResourceAsStream("/objects/boots.png")) {
			this.image = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
