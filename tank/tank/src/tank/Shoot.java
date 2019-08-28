package tank;

import javax.swing.*;

public class Shoot extends Thread {

	private int x, y;
	private JLabel bullet;
	private ImageIcon iu, id, il, ir, ilu, ird, ild, iru, inow;
	private ImageIcon ib = new ImageIcon("img/bullet/normal.png");
	private Player target;

	public Shoot(Player target, JLabel bullet, int x, int y, ImageIcon iu, ImageIcon id, ImageIcon il, ImageIcon ir,
			ImageIcon ilu, ImageIcon ird, ImageIcon ild, ImageIcon iru, ImageIcon inow) {
		this.target = target;
		this.bullet = bullet;
		this.x = x + 20;
		this.y = y + 22;
		this.iu = iu;
		this.id = id;
		this.il = il;
		this.ir = ir;
		this.ilu = ilu;
		this.ird = ird;
		this.ild = ild;
		this.iru = iru;
		this.inow = inow;

	}

	public void run() {
		this.bullet.setIcon(ib);
		if (inow == il) {
			int i = x;
			int r = y;
			while (i > 0) {
				this.bullet.setLocation(i, r);
				if ((this.target.x <= i && i <= this.target.x + 48)
						&& (this.target.y <= r && r <= this.target.y + 48)) {
					this.target.tank.setVisible(false);
					break;
				}
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
				i--;
			}
		} else if (inow == ilu) {
			int i = x;
			int r = y;
			while (i > 0) {
				this.bullet.setLocation(i, r);
				if ((this.target.x <= i && i <= this.target.x + 48)
						&& (this.target.y <= r && r <= this.target.y + 48)) {
					this.target.tank.setVisible(false);
					break;
				}
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
				i--;
				r--;
			}
		} else if (inow == iu) {
			int i = x;
			int r = y;
			while (r > 0) {
				this.bullet.setLocation(i, r);
				if ((this.target.x <= i && i <= this.target.x + 48)
						&& (this.target.y <= r && r <= this.target.y + 48)) {
					this.target.tank.setVisible(false);
					break;
				}
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
				r--;
			}
		} else if (inow == iru) {
			int i = x;
			int r = y;
			while (i < 624 && r > 0) {
				this.bullet.setLocation(i, r);
				if ((this.target.x <= i && i <= this.target.x + 48)
						&& (this.target.y <= r && r <= this.target.y + 48)) {
					this.target.tank.setVisible(false);
					break;
				}
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
				i++;
				r--;
			}
		} else if (inow == ir) {
			int i = x;
			int r = y;
			while (i < 624) {
				this.bullet.setLocation(i, r);
				if ((this.target.x <= i && i <= this.target.x + 48)
						&& (this.target.y <= r && r <= this.target.y + 48)) {
					this.target.tank.setVisible(false);
					break;
				}
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
				i++;
			}
		} else if (inow == ird) {
			int i = x;
			int r = y;
			while (i < 624 && r < 624) {
				this.bullet.setLocation(i, r);
				if ((this.target.x <= i && i <= this.target.x + 48)
						&& (this.target.y <= r && r <= this.target.y + 48)) {
					this.target.tank.setVisible(false);
					break;
				}
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
				i++;
				r++;
			}
		} else if (inow == id) {
			int i = x;
			int r = y;
			while (r < 624) {
				this.bullet.setLocation(i, r);
				if ((this.target.x <= i && i <= this.target.x + 48)
						&& (this.target.y <= r && r <= this.target.y + 48)) {
					this.target.tank.setVisible(false);
					break;
				}
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
				r++;
			}
		} else if (inow == ild) {
			int i = x;
			int r = y;
			while (i > 0 && r < 624) {
				this.bullet.setLocation(i, r);
				if ((this.target.x <= i && i <= this.target.x + 48)
						&& (this.target.y <= r && r <= this.target.y + 48)) {
					this.target.tank.setVisible(false);
					break;
				}
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
				i--;
				r++;
			}
		}
		this.bullet.setIcon(null);
	}
}
