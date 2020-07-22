package 지뢰찾기;

import javax.swing.JPanel;

public class GameBox_Panel extends JPanel{
	MineBox_Button box[][];
	boolean mine[][];
	GameBox_Panel(){
		this.setSize(600, 600);
		this.setLocation(90, 120);
		this.setLayout(null);
		box = new MineBox_Button[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				box[i][j] = new MineBox_Button(i,j);
				this.add(box[i][j]);
			}
		}
		mine = new boolean[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				mine[i][j] = false;
			}
		}
	}
}