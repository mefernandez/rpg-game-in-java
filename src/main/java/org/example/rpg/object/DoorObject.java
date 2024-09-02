package org.example.rpg.object;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class DoorObject extends SuperObject {
	
	public DoorObject() {
		this.name = "Door";
		try (InputStream is = getClass().getResourceAsStream("/objects/door.png")) {
			this.image = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
