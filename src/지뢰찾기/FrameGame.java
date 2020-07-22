package 지뢰찾기;

import java.awt.Color;

import javax.swing.JFrame;

public class FrameGame extends JFrame{
	GameBox_Panel gamebox;
	FrameGame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(168, 69, 36));
		this.setTitle("지뢰찾기");
		this.setSize(800,800);
		this.setVisible(true);
		this.setLocation(370, 20);
		this.setLayout(null);
		gamebox = new GameBox_Panel();
		this.add(gamebox);
		this.repaint();
		//this.add(new RestartButton());
	}
}