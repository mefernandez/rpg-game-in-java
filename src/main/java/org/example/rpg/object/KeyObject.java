package org.example.rpg.object;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class KeyObject extends SuperObject {
	
	public KeyObject() {
		this.name = "Key";
		try (InputStream is = getClass().getResourceAsStream("/objects/key.png")) {
			this.image = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
