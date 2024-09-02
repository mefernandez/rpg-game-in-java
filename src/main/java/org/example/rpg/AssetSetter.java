package org.example.rpg;

import org.example.rpg.object.ChestObject;
import org.example.rpg.object.DoorObject;
import org.example.rpg.object.KeyObject;

public class AssetSetter {
	
	GamePanel gp;

	public AssetSetter(GamePanel gp) {
		super();
		this.gp = gp;
	}
	
	public void setObject() {
		gp.obj[0] = new KeyObject();
		gp.obj[0].worldX = 23 * gp.tileSize;
		gp.obj[0].worldY = 7 * gp.tileSize;
		
		gp.obj[1] = new KeyObject();
		gp.obj[1].worldX = 23 * gp.tileSize;
		gp.obj[1].worldY = 40 * gp.tileSize;

		gp.obj[2] = new KeyObject();
		gp.obj[2].worldX = 38 * gp.tileSize;
		gp.obj[2].worldY = 8 * gp.tileSize;

		gp.obj[3] = new DoorObject();
		gp.obj[3].worldX = 10 * gp.tileSize;
		gp.obj[3].worldY = 11 * gp.tileSize;

		gp.obj[4] = new DoorObject();
		gp.obj[4].worldX = 8 * gp.tileSize;
		gp.obj[4].worldY = 28 * gp.tileSize;

		gp.obj[5] = new DoorObject();
		gp.obj[5].worldX = 12 * gp.tileSize;
		gp.obj[5].worldY = 22 * gp.tileSize;

		gp.obj[6] = new ChestObject();
		gp.obj[6].worldX = 10 * gp.tileSize;
		gp.obj[6].worldY = 7 * gp.tileSize;

	}
}
