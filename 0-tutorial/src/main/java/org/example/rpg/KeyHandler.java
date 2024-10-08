package org.example.rpg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, hitBoxPressed;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = true;
		} else if (code == KeyEvent.VK_S) {
			downPressed = true;
		} else if (code == KeyEvent.VK_A) {
			leftPressed = true;
		} else if (code == KeyEvent.VK_D) {
			rightPressed = true;
		} else if (code == KeyEvent.VK_F3) {
			hitBoxPressed = true;
		} 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = false;
		}
		
		if (code == KeyEvent.VK_S) {
			downPressed = false;
			
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
			
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
			
		}
		
		
	}

}
