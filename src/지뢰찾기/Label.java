package 지뢰찾기;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel{
	Label(int x){
		this.setLocation(x, 35);
		this.setSize(600,50);
		this.setFont(new Font("Serif", Font.BOLD, 30));
		this.setForeground(Color.yellow);
		this.setVisible(false);
	}
}
