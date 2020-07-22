package 지뢰찾기;

import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MineBox_Button extends JButton {
	int prop;
	int mine_num;
	boolean clicked;
	boolean flag;
	MineManager mm;
	Icon image;
	MouseAdapter ML;
	int x,y;
	MineBox_Button(int x, int y) {
		this.x = x;
		this.y = y;
		this.clicked = false;
		this.flag = false;
		this.prop = 0;
		this.setLocation(x*40, y*40);
		this.setSize(40,40);
		this.mine_num = 0;
		this.setMargin(new Insets(0,0,0,0));
		this.ML = new ML();
		this.addMouseListener(ML);
	}
	
	void setMM(MineManager mm) {
		this.mm = mm;
	}
	
	void setImage(Icon image) {
		Image originImg = ((ImageIcon) image).getImage(); 
		Image changedImg= originImg.getScaledInstance(40, 40, Image.SCALE_DEFAULT );
		ImageIcon icon = new ImageIcon(changedImg);
		this.image = icon;
		this.setIcon(this.image);
		this.repaint();
	}
	
	void leftPressed() {
		if(this.mine_num!=0 && this.mine_num!=9) {
			this.setImage(mm.images.getImage(mine_num));
			this.clicked = true;
			mm.checkSuccess();
			return;
		}
		if(this.clicked==true) return;
		if(this.mine_num == 9 && prop == 0) {
			if(prop!=0) {
				return;
			}
			mm.end();
			return;
		}
		this.setImage(mm.images.getImage(mine_num));
		this.clicked = true;
		mm.checkSuccess();

		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				if(i==-1||j==-1||i==15||j==15) continue;
				if(i==x && j==y) continue;
				if(mm.gamebox.box[i][j].mine_num != 9) {
					prop++;
					mm.gamebox.box[i][j].leftPressed();
					prop--;
				}
			}
		}
	}
	
	void rightPressed() {
		if(this.clicked==true) return;
		if(this.flag==false) {
			this.setImage(mm.images.getImage(-1));
			this.flag = true;
		}
		else{
			this.setImage(mm.images.getImage(-2));
			this.flag = false;
		}
	}
	
	boolean checkAnswer() {
		int num = 0;
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				if(i==-1||j==-1||i==15||j==15) continue;
				if(mm.gamebox.mine[i][j]==true && (mm.gamebox.box[i][j].flag == true)) num++;
			}
		}
		return num == mm.count(x, y);
	}
	
	boolean checkSameNum() {
		int num1 = 0, num2 = 0;
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				if(i==-1||j==-1||i==15||j==15) continue;
				if(mm.gamebox.mine[i][j]==true) num1++;
				if(mm.gamebox.box[i][j].flag == true) num2++;
			}
		}
		return num1 == num2;
	}
	
	boolean checkDiffer() {
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				if(i==-1||j==-1||i==15||j==15) continue;
				if(mm.gamebox.mine[i][j] != mm.gamebox.box[i][j].flag) {
					return true;
				}
			}
		}
		return false;
	}
	
	void bothPressed() {
		if(this.clicked == true) {
			if(checkDiffer() && checkSameNum()) {
				mm.end(); return;
			}
			if(!checkSameNum()) return;
			if(checkAnswer()) {
				for (int i = x-1; i <= x+1; i++) {
					for (int j = y-1; j <= y+1; j++) {
						if(i==-1||j==-1||i==15||j==15) continue;
						if(mm.gamebox.box[i][j].mine_num!=9)
							mm.gamebox.box[i][j].leftPressed();
					}
				}
			}
		}
	}
	
	void removeML() {
		this.removeMouseListener(this.ML);
	}
	
	class ML extends MouseAdapter{
		boolean left, right, both;

		public void mousePressed(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) { // ���� ��ư
				left = true;
				if(right==true) both = true;
			}
			else if(e.getButton() == MouseEvent.BUTTON3) { // ������ ��ư
				right = true;
				if(left==true) both = true;
			}
		}

		public void mouseReleased(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) { // ���� ��ư
				if(right==true) bothPressed();
				else {
					if(both==false) leftPressed();
				}
				left = false;
			}
			else if(e.getButton() == MouseEvent.BUTTON3) { // ������ ��ư
				if(left==true) bothPressed();
				else {
					if(both==false) rightPressed();
				}
				right = false;
			}
		}
	}
}