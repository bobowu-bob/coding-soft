package tank;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Blocks {//生成障礙物
	public void Blcks(JFrame frame)  {     //Blcks(建構值)，frame(共用的視窗)
		// TODO Auto-generated method stub
		int[][] arr = {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 3, 3, 3, 3, 3, 0, 0, 0, 0},
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{ 1, 1, 1, 0, 1, 1, 2, 1, 1, 0, 2, 2, 2},
			{ 0, 0, 0, 0, 1, 1, 2, 1, 1, 1, 1, 0, 0},
			{ 0, 0, 1, 1, 2, 2, 2, 2, 2, 1, 1, 0, 0},
			{ 0, 0, 1, 1, 1, 1, 2, 1, 1, 0, 0, 0, 0},
			{ 2, 2, 2, 0, 1, 1, 2, 1, 1, 0, 1, 1, 1},
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{ 0, 0, 0, 0, 3, 3, 3, 3, 3, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int block_type = arr[i][j];
//				System.out.println(arr[i][j]);
				switch (block_type) {
				case 0:
					break;
				case 1:
					ImageIcon block_image1 = new ImageIcon("img/blocks/Cover.jpg");
					JLabel block1 = new JLabel(block_image1);
					block1.setSize(48, 48);
					block1.setLocation(48 * i, 48 * j);
					frame.add(block1);  //放上圖片
					break;
				case 2:
					ImageIcon block_image2 = new ImageIcon("img/blocks/Bricks.jpg");
					JLabel block2 = new JLabel(block_image2);
					block2.setSize(48, 48);
					block2.setLocation(48 * i, 48 * j);
					frame.add(block2);  //不用「frame.getContentPane().add(block2);」，會無法執行
					break;
				case 3:
					ImageIcon block_image3 = new ImageIcon("img/blocks/Wooden-crate.jpg");
					JLabel block3 = new JLabel(block_image3);
					block3.setSize(48, 48);
					block3.setLocation(48 * i, 48 * j);
					frame.add(block3);
					break;
				default:
					break;
				}
			}
		}
	}
}
