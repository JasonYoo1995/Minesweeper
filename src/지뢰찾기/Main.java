package 지뢰찾기;

public class Main {
	public static void main(String[] args) {
		FrameGame fg = new FrameGame();
		MineManager mm = new MineManager(fg.gamebox);
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				fg.gamebox.box[i][j].mm = mm;
				if(fg.gamebox.mine[i][j]==true) fg.gamebox.box[i][j].mine_num = 9;
			}
		}
	}
}
