package Bite_Beat_1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(BiteBeat.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			BiteBeat.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			BiteBeat.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			BiteBeat.game.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			BiteBeat.game.pressSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			BiteBeat.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			BiteBeat.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			BiteBeat.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(BiteBeat.game == null)
			return;
		if(e.getKeyCode() == KeyEvent.VK_S) {
			BiteBeat.game.releaseS();
    	}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			BiteBeat.game.releaseD();
    	}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			BiteBeat.game.releaseF();
    	}           
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			BiteBeat.game.releaseSpace();
    	}           
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			BiteBeat.game.releaseJ();
    	}           	
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			BiteBeat.game.releaseK();
    	}           	
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			BiteBeat.game.releaseL();
    	}           
	}
}

