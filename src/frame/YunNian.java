package frame;

import javax.swing.*;
import java.awt.*;

public class YunNian { 
	 public static void main(String[] args) { 
	  new T();
	 } 
	}

	class T extends JFrame {
	 public T() {
	  
	  setBounds(200,100,200,500);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setVisible(true);
	 }

	@Override
	 public void paint(Graphics g) {
	  
	  super.paint(g);
	  g.drawLine(40,40,100,100);
	 }
	}