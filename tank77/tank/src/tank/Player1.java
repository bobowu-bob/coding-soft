package tank;

import java.awt.event.*;

import javax.swing.*;

public class Player1 extends Player implements KeyListener{
	
	public Player1(JLabel tank, ImageIcon iu,ImageIcon id,ImageIcon il,ImageIcon ir,ImageIcon ilu,ImageIcon ird,ImageIcon ild,ImageIcon iru){
		super(tank,iu,id,il,ir,ilu,ird,ild,iru);
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyPressed(KeyEvent e){
		System.out.print("a");
		int key = e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_LEFT :
				bL=true;
				break;
			case KeyEvent.VK_UP : 
				bU=true;
				break;
			case KeyEvent.VK_RIGHT : 
				bR=true;
				break;
			case KeyEvent.VK_DOWN : 
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
			case KeyEvent.VK_LEFT :
				bL=false;
				break;
			case KeyEvent.VK_UP : 
				bU=false;
				break;
			case KeyEvent.VK_RIGHT : 
				bR=false;
				break;
			case KeyEvent.VK_DOWN : 
				bD=false;
				break;
		}
		locataDirection();//按下鍵以後重新定位一下方向
		move();
		tank.setLocation(x, y);
	} 
}
