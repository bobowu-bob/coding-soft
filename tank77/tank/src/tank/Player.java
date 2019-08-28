package tank;

import javax.swing.*;

public class Player{
	
	protected JLabel tank; 
	private ImageIcon iu,id,il,ir,ilu,ird,ild,iru;
	protected boolean bU,bD,bL,bR;
	protected static final int XSPEED=10;
	protected static final int YSPEED=10;
	protected int x,y;
	private Direction dir = Direction.STOP;
	enum Direction {L,LU,U,RU,R,RD,D,LD,STOP};
	
	public Player(JLabel tank, ImageIcon iu,ImageIcon id,ImageIcon il,ImageIcon ir,ImageIcon ilu,ImageIcon ird,ImageIcon ild,ImageIcon iru){
		this.tank = tank;
		this.iu = iu;
		this.id = id;
		this.il = il;
		this.ir = ir;
		this.ilu = ilu;
		this.ird = ird;
		this.ild = ild;
		this.iru = iru;
	}
	
	public void locataDirection(){ 
		if(bL && !bU && !bR && !bD) 
			dir = Direction.L;//判斷朝什麼方向
		else if(bL && bU && !bR && !bD) 
			dir = Direction.LU;
		else if(!bL && bU && !bR && !bD) 
			dir = Direction.U;
		else if(!bL && bU && bR && !bD) 
			dir = Direction.RU;
		else if(!bL && !bU && bR && !bD) 
			dir = Direction.R;
		else if(!bL && !bU && bR && bD) 
			dir = Direction.RD;
		else if(!bL && !bU && !bR && bD) 
			dir = Direction.D;
		else if(bL && !bU && !bR && bD) 
			dir = Direction.LD;
		else if(!bL && !bU && !bR && !bD) 
			dir = Direction.STOP; 
	}
	
	public void move(){ 
		switch(dir){ 
			case L: 
				if(x>0)
					x-=XSPEED; 
				tank.setIcon(il);
				break; 
			case LU: 
				if(x>0&&y>0) {
					x-=XSPEED; 
					y-=YSPEED; 
				}
				tank.setIcon(ilu);
				break; 
			case U: 
				if (y>0)
					y-=YSPEED; 
				tank.setIcon(iu);
				break; 
			case RU: 
				if(x<570&&y>0) {
					x+=XSPEED; 
					y-=YSPEED;
				}
				tank.setIcon(iru);
				break; 
			case R: 
				if(x<570)
					x+=XSPEED; 
				tank.setIcon(ir);
				break; 
			case RD: 
				if(x<570&&y<545) {
					x+=XSPEED; 
					y+=YSPEED; 
				}
				tank.setIcon(ird);
				break; 
			case D: 
				if(y<545)
					y+=YSPEED;
				tank.setIcon(id);
				break; 
			case LD: 
				if(x>0&&y<545) {
					x-=XSPEED; 
					y+=YSPEED;
				}
				tank.setIcon(ild);
				break; 
			case STOP: 
				break;
		}
	}
}



		