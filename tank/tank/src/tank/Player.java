package tank;

import javax.swing.*;

public class Player {

	public JLabel tank;
	protected ImageIcon iu, id, il, ir, ilu, ird, ild, iru, inow;
	protected boolean bU, bD, bL, bR;
	protected static final int XSPEED = 12;
	protected static final int YSPEED = 12;
	protected int x, y;
	public Shoot shoot;

	private Direction dir = Direction.STOP;
	private ImageIcon ib = new ImageIcon("img/bullet/normal.png");

	enum Direction {
		L, LU, U, RU, R, RD, D, LD, STOP
	};

	public int[][] collision_array = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 3, 3, 3, 3, 3, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 1, 1, 2, 1, 1, 0, 2, 2, 2 },
			{ 0, 0, 0, 0, 1, 1, 2, 1, 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 2, 2, 2, 2, 2, 1, 1, 0, 0 },
			{ 0, 0, 1, 1, 1, 1, 2, 1, 1, 0, 0, 0, 0 }, { 2, 2, 2, 0, 1, 1, 2, 1, 1, 0, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 }, { 0, 0, 0, 0, 3, 3, 3, 3, 3, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public int x_right, x_left, y_top, y_down;

	public Player(int x, int y, ImageIcon iu, ImageIcon id, ImageIcon il, ImageIcon ir, ImageIcon ilu, ImageIcon ird,
			ImageIcon ild, ImageIcon iru) {
		this.tank = new JLabel(iu);
		inow = iu;
		this.tank.setSize(48, 48);
		this.x = x;
		this.y = y;
		this.iu = iu;
		this.id = id;
		this.il = il;
		this.ir = ir;
		this.ilu = ilu;
		this.ird = ird;
		this.ild = ild;
		this.iru = iru;

	}

	public void Bullet(Player target) {
		JLabel bullet = new JLabel();
		bullet.setSize(9, 9);
		bullet.setIcon(ib);
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(tank);
		frame.getLayeredPane().add(bullet, 0);
		shoot = new Shoot(target, bullet, x, y, iu, id, il, ir, ilu, ird, ild, iru, inow);
		shoot.start();

	}

	public void loc() {
		x_right = (x + 48) / 48;
		if (y > 48) {
			y_top = (y - 12) / 48;
		} else {
			y_top = 0;
		}
		if (x > 48) {
			x_left = (x - 12) / 48;
		} else {
			x_left = 0;
		}
		y_down = (y + 48) / 48;
	}

	public void pleft() {
		bL = true;
	}

	public void pup() {
		bU = true;
	}

	public void pright() {
		bR = true;
	}

	public void pdown() {
		bD = true;
	}

	public void rleft() {
		bL = false;
	}

	public void rup() {
		bU = false;
	}

	public void rright() {
		bR = false;
	}

	public void rdown() {
		bD = false;
	}

	public void locataDirection() {
		if (bL && !bU && !bR && !bD)
			dir = Direction.L;// 判斷朝什麼方向
		else if (bL && bU && !bR && !bD)
			dir = Direction.LU;
		else if (!bL && bU && !bR && !bD)
			dir = Direction.U;
		else if (!bL && bU && bR && !bD)
			dir = Direction.RU;
		else if (!bL && !bU && bR && !bD)
			dir = Direction.R;
		else if (!bL && !bU && bR && bD)
			dir = Direction.RD;
		else if (!bL && !bU && !bR && bD)
			dir = Direction.D;
		else if (bL && !bU && !bR && bD)
			dir = Direction.LD;
		else if (!bL && !bU && !bR && !bD)
			dir = Direction.STOP;
	}

	public void move() {
		switch (dir) {
		case L:
			if (x > 0 && !(collision_array[x_left][y / 48] == 2 || collision_array[x_left][(y + 36) / 48] == 2
					|| collision_array[x_left][y / 48] == 3 || collision_array[x_left][(y + 36) / 48] == 3))
				x -= XSPEED;
			inow = il;
			break;
		case LU:
			if (x > 0 && y > 0
					&& !(collision_array[x_left][y / 48] == 2 || collision_array[x_left][(y + 36) / 48] == 2
							|| collision_array[x_left][y / 48] == 3 || collision_array[x_left][(y + 36) / 48] == 3)
					&& !(collision_array[x / 48][y_top] == 2 || collision_array[(x + 36) / 48][y_top] == 2
							|| collision_array[x / 48][y_top] == 3 || collision_array[(x + 36) / 48][y_top] == 3)) {
				x -= XSPEED;
				y -= YSPEED;
			}
			inow = ilu;
			break;
		case U:
			if (y > 0 && !(collision_array[x / 48][y_top] == 2 || collision_array[(x + 36) / 48][y_top] == 2
					|| collision_array[x / 48][y_top] == 3 || collision_array[(x + 36) / 48][y_top] == 3))
				y -= YSPEED;
			inow = iu;
			break;
		case RU:
			if (x < 570 && y > 0
					&& !(collision_array[x / 48][y_top] == 2 || collision_array[(x + 36) / 48][y_top] == 2
							|| collision_array[x / 48][y_top] == 3 || collision_array[(x + 36) / 48][y_top] == 3)
					&& !(collision_array[x_right][y / 48] == 2 || collision_array[x_right][(y + 36) / 48] == 2
							|| collision_array[x_right][y / 48] == 3 || collision_array[x_right][(y + 36) / 48] == 3)) {
				x += XSPEED;
				y -= YSPEED;
			}
			inow = iru;
			break;
		case R:
			if (x < 570 && !(collision_array[x_right][y / 48] == 2 || collision_array[x_right][(y + 36) / 48] == 2
					|| collision_array[x_right][y / 48] == 3 || collision_array[x_right][(y + 36) / 48] == 3))
				x += XSPEED;
			inow = ir;
			break;
		case RD:
			if (x < 570 && y < 545
					&& !(collision_array[x_right][y / 48] == 2 || collision_array[x_right][(y + 36) / 48] == 2
							|| collision_array[x_right][y / 48] == 3 || collision_array[x_right][(y + 36) / 48] == 3)
					&& !(collision_array[x / 48][y_down] == 2 || collision_array[(x + 36) / 48][y_down] == 2
							|| collision_array[x / 48][y_down] == 3 || collision_array[(x + 36) / 48][y_down] == 3)) {
				x += XSPEED;
				y += YSPEED;
			}
			inow = ird;
			break;
		case D:
			if (y < 545 && !(collision_array[x / 48][y_down] == 2 || collision_array[(x + 36) / 48][y_down] == 2
					|| collision_array[x / 48][y_down] == 3 || collision_array[(x + 36) / 48][y_down] == 3))
				y += YSPEED;
			inow = id;
			break;
		case LD:
			if (x > 0 && y < 545
					&& !(collision_array[x / 48][y_down] == 2 || collision_array[(x + 36) / 48][y_down] == 2
							|| collision_array[x / 48][y_down] == 3 || collision_array[(x + 36) / 48][y_down] == 3)
					&& !(collision_array[x_left][y / 48] == 2 || collision_array[x_left][(y + 36) / 48] == 2
							|| collision_array[x_left][y / 48] == 3 || collision_array[x_left][(y + 36) / 48] == 3)) {
				x -= XSPEED;
				y += YSPEED;
			}
			inow = ild;
			break;
		case STOP:
			break;
		}

		tank.setIcon(inow);
	}

}