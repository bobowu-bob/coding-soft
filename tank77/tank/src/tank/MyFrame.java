package tank;

import javax.swing.*;

public class MyFrame extends JFrame {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ImageIcon iu = new ImageIcon("tank/hero-u.png"); 
		ImageIcon id = new ImageIcon("tank/hero-d.png"); 
		ImageIcon il = new ImageIcon("tank/hero-l.png"); 
		ImageIcon ir = new ImageIcon("tank/hero-r.png"); 
		ImageIcon ilu = new ImageIcon("tank/hero-lu.png"); 
		ImageIcon ird = new ImageIcon("tank/hero-rd.png"); 
		ImageIcon ild = new ImageIcon("tank/hero-ld.png"); 
		ImageIcon iru = new ImageIcon("tank/hero-ru.png");
		
		
		MyFrame frame = new MyFrame();
		frame.setSize(624,624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		
		JLabel tank1 = new JLabel(iu); 
		tank1.setSize(48, 48);
		tank1.setLocation(0, 0);
		
		JLabel tank2 = new JLabel(iu); 
		tank2.setSize(48, 48);
		tank2.setLocation(0, 0);
		
		frame.addKeyListener(new Player1(tank1,iu,id,il,ir,ilu,ird,ild,iru));
		frame.addKeyListener(new Player2(tank2,iu,id,il,ir,ilu,ird,ild,iru));
		
		frame.getContentPane().add(tank1);
		frame.getContentPane().add(tank2);
		
		
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
}
