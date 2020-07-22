package 지뢰찾기;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Images{
	Icon flag = new ImageIcon(getClass().getClassLoader().getResource("깃발.png"));
	Icon notClicked = new ImageIcon(getClass().getClassLoader().getResource("미클릭.png"));
	Icon mine = new ImageIcon(getClass().getClassLoader().getResource("지뢰.png"));
	Icon mine0 = new ImageIcon(getClass().getClassLoader().getResource("지뢰0개.png"));
	Icon mine1 = new ImageIcon(getClass().getClassLoader().getResource("지뢰1개.png"));
	Icon mine2 = new ImageIcon(getClass().getClassLoader().getResource("지뢰2개.png"));
	Icon mine3 = new ImageIcon(getClass().getClassLoader().getResource("지뢰3개.png"));
	Icon mine4 = new ImageIcon(getClass().getClassLoader().getResource("지뢰4개.png"));
	Icon mine5 = new ImageIcon(getClass().getClassLoader().getResource("지뢰5개.png"));
	Icon mine6 = new ImageIcon(getClass().getClassLoader().getResource("지뢰6개.png"));
	Icon mine7 = new ImageIcon(getClass().getClassLoader().getResource("지뢰7개.png"));
	Icon mine8 = new ImageIcon(getClass().getClassLoader().getResource("지뢰8개.png"));
	Icon getImage(int num) {
		switch(num){
        case -2: 
            return notClicked;
        case -1: 
            return flag;
        case 0: 
            return mine0;
        case 1: 
            return mine1;
        case 2:
            return mine2;
        case 3 :
            return mine3;
        case 4: 
            return mine4;
        case 5:
            return mine5;
        case 6 :
            return mine6;
        case 7:
            return mine7;
        case 8 :
            return mine8;
        case 9 :
            return mine;
        default :
            return null;
		}
	}
}