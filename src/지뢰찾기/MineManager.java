package 지뢰찾기;

import java.util.Random;

public class MineManager{
	GameBox_Panel gamebox;
	Images images;
	int total_mine;
	Label label1, label2;
	
	MineManager(GameBox_Panel gamebox){
		this.gamebox = gamebox;
		images = new Images();
//***************************************************************************************************************//
		total_mine = 25;          // <- ���̵� ���� (���� ���� 0~225�� ���̷�!)
//***************************************************************************************************************//
		putMine(total_mine);
		countMine();
		putImage();
		
		label1 = new Label(100);
		label2 = new Label(130);
		gamebox.getParent().getParent().add(label1);
		gamebox.getParent().getParent().add(label2);
	}
	void putMine(int mine_num) {
		Random rand = new Random();
		int total_mine = 0;
		while(total_mine != mine_num) {
			int i = rand.nextInt(15);
			int j = rand.nextInt(15);
			if(gamebox.mine[i][j] == true) continue;
			gamebox.mine[i][j] = true;
			gamebox.box[i][j].mine_num = 9;
			total_mine++;
		}
	}
	
	void countMine() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				gamebox.box[i][j].mine_num = count(i,j);
			}
		}
	}

	int count(int x, int y) {
		if(gamebox.mine[x][y] == true) return 0;
		int num = 0;
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				if(i==-1||j==-1||i==15||j==15) continue;
				if(gamebox.mine[i][j]==true) num++;
			}
		}
		return num;
	}
	
	void putImage() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				gamebox.box[i][j].setImage(images.notClicked);
			}
		}
	}
	
	void end() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if(gamebox.mine[i][j]==true)
					gamebox.box[i][j].setImage(images.mine);
			}
		}
		disable();
		label1.setText("껐다 켜세요");
		label1.setVisible(true);
	}
	
	void disable() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				gamebox.box[i][j].removeML();
			}
		}
	}
	
	void checkSuccess() {
		int num = 0;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if(gamebox.box[i][j].clicked==true)	num++;
			}
		}

		if(num==15*15-total_mine) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					if(gamebox.mine[i][j]==true) gamebox.box[i][j].setImage(images.flag);
				}
			}
			disable();
			label2.setText("축하합니다");
			label2.setVisible(true);
		}
	}
}