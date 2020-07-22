package 지뢰찾기;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class RestartButton extends JButton{
	RestartButton(FrameGame fg){
		this.setText("다시 시작");
		this.setLocation(350,40);
		this.setSize(100,50);
		this.addMouseListener(new ML());
	}
	
	class ML extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
		}
	}
}
