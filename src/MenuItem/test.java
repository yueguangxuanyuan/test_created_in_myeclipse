package MenuItem;

import javax.swing.*;

public class test {
    public static void main(String[] args){
     	JMenuItem[][] menuItemArr = new JMenuItem[3][4];
     	String[][] menuItemStr= new String[3][4];
    	for(int i=0; i<menuItemStr.length; i++) {
			for(int j=0; j<menuItemStr[i].length; j++) {
				menuItemArr[i][j] = new JMenuItem(menuItemStr[i][j]);
			}
    	}
    }
}
