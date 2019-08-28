package tank;

import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame implements KeyListener {
	public Player player1, player2;

	static ImageIcon iu0 = new ImageIcon("img/tank/0/tank-u.png");
	static ImageIcon id0 = new ImageIcon("img/tank/0/tank-d.png");
	static ImageIcon il0 = new ImageIcon("img/tank/0/tank-l.png");
	static ImageIcon ir0 = new ImageIcon("img/tank/0/tank-r.png");
	static ImageIcon ilu0 = new ImageIcon("img/tank/0/tank-lu.png");
	static ImageIcon ird0 = new ImageIcon("img/tank/0/tank-rd.png");
	static ImageIcon ild0 = new ImageIcon("img/tank/0/tank-ld.png");
	static ImageIcon iru0 = new ImageIcon("img/tank/0/tank-ru.png");

	static ImageIcon iu1 = new ImageIcon("img/tank/1/tank-u.png");
	static ImageIcon id1 = new ImageIcon("img/tank/1/tank-d.png");
	static ImageIcon il1 = new ImageIcon("img/tank/1/tank-l.png");
	static ImageIcon ir1 = new ImageIcon("img/tank/1/tank-r.png");
	static ImageIcon ilu1 = new ImageIcon("img/tank/1/tank-lu.png");
	static ImageIcon ird1 = new ImageIcon("img/tank/1/tank-rd.png");
	static ImageIcon ild1 = new ImageIcon("img/tank/1/tank-ld.png");
	static ImageIcon iru1 = new ImageIcon("img/tank/1/tank-ru.png");
	static ImageIcon background = new ImageIcon("img/background/rock.jpg"); // �I��
	static JLabel bgLabel = new JLabel(background); // ��I������ܦbLabel��
	public int[][] arr = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 3, 3, 3, 3, 3, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 1, 1, 2, 1, 1, 0, 2, 2, 2 }, { 0, 0, 0, 0, 1, 1, 2, 1, 1, 1, 1, 0, 0 },
			{ 0, 0, 1, 1, 2, 2, 2, 2, 2, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1, 1, 2, 1, 1, 0, 0, 0, 0 },
			{ 2, 2, 2, 0, 1, 1, 2, 1, 1, 0, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 0, 0, 0, 0, 3, 3, 3, 3, 3, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public MyFrame() {
		setSize(624, 624);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		this.player1 = new Player(0, 0, iu0, id0, il0, ir0, ilu0, ird0, ild0, iru0);
		this.player2 = new Player(575, 560, iu1, id1, il1, ir1, ilu1, ird1, ild1, iru1);
		this.player1.tank.setLocation(this.player1.x, this.player1.y);
		this.player2.tank.setLocation(this.player2.x, this.player2.y);

		bgLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());

		this.getLayeredPane().add(this.player1.tank, 1);
		this.getLayeredPane().add(this.player2.tank, 1);

		Block block = new Block(this);

		this.getLayeredPane().add(bgLabel, -1);
		addKeyListener(this);

	}

	public void keyTyped(KeyEvent k) {
	}

	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		this.player1.loc();
		this.player2.loc();
		switch (key) {
		case KeyEvent.VK_LEFT:
			this.player1.pleft();
			break;
		case KeyEvent.VK_UP:
			this.player1.pup();
			break;
		case KeyEvent.VK_RIGHT:
			this.player1.pright();
			break;
		case KeyEvent.VK_DOWN:
			this.player1.pdown();
			break;
		case KeyEvent.VK_L:
			if (this.player1.tank.isVisible() == true)
				this.player1.Bullet(this.player2);
			break;
		case KeyEvent.VK_A:
			this.player2.pleft();
			break;
		case KeyEvent.VK_W:
			this.player2.pup();
			break;
		case KeyEvent.VK_D:
			this.player2.pright();
			break;
		case KeyEvent.VK_S:
			this.player2.pdown();
			break;
		case KeyEvent.VK_G:
			if (this.player2.tank.isVisible() == true)
				this.player2.Bullet(this.player1);
			break;
		}

		this.player1.locataDirection();
		this.player1.move();
		this.player1.tank.setLocation(this.player1.x, this.player1.y);
		this.player2.locataDirection();
		this.player2.move();
		this.player2.tank.setLocation(this.player2.x, this.player2.y);

	}

	public void keyReleased(KeyEvent k) {
		int key = k.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			this.player1.rleft();
			break;
		case KeyEvent.VK_UP:
			this.player1.rup();
			break;
		case KeyEvent.VK_RIGHT:
			this.player1.rright();
			break;
		case KeyEvent.VK_DOWN:
			this.player1.rdown();
			break;
		case KeyEvent.VK_A:
			this.player2.rleft();
			break;
		case KeyEvent.VK_W:
			this.player2.rup();
			break;
		case KeyEvent.VK_D:
			this.player2.rright();
			break;
		case KeyEvent.VK_S:
			this.player2.rdown();
			break;
		}

		this.player1.locataDirection();
		this.player1.move();
		this.player1.tank.setLocation(this.player1.x, this.player1.y);
		this.player2.locataDirection();
		this.player2.move();
		this.player2.tank.setLocation(this.player2.x, this.player2.y);
	}
}
