package tank;

import java.awt.event.*;

import javax.swing.*;

public class Player2 extends Player implements KeyListener{
	
	public Player2(JLabel tank, ImageIcon iu,ImageIcon id,ImageIcon il,ImageIcon ir,ImageIcon ilu,ImageIcon ird,ImageIcon ild,ImageIcon iru){
		super(tank,iu,id,il,ir,ilu,ird,ild,iru);
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_A :
				bL=true;
				break;
			case KeyEvent.VK_W : 
				bU=true;
				break;
			case KeyEvent.VK_D : 
				bR=true;
				break;
			case KeyEvent.VK_S : 
				bD=true;
				break;
		}
		locataDirection();//按下鍵以後重新定位一下方向
		move();
		tank.setLocation(x, y);
	}
	
	public void keyReleased(KeyEvent e) { 
		int key = e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_A :
				bL=false;
				break;
			case KeyEvent.VK_W : 
				bU=false;
				break;
			case KeyEvent.VK_D : 
				bR=false;
				break;
			case KeyEvent.VK_S: 
				bD=false;
				break;
		}
		locataDirection();//按下鍵以後重新定位一下方向
		move();
		tank.setLocation(x, y);
	} 
}
