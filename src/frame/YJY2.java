package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class YJY2 {
	Frame f1 = new Frame("绠�崟缁樺浘");
	Panel p1 = new Panel();
	Button bt1 = new Button("缁樺埗鐭╁舰");
	Button bt2 = new Button("缁樺埗鍦嗗舰");
	Button bt3 = new Button("娓呯┖");
	Mycanvas drawArea1 = new Mycanvas(){

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawOval(90, 70, 100, 60);
		}
	   
	};
	Mycanvas drawArea2 = new Mycanvas();

	public YJY2() {
		p1.add(bt1);
		p1.add(bt2);
		p1.add(bt3);
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics gg = drawArea1.getGraphics();
				drawArea1.update(gg);
				System.out.println("鎴戞兂灏辨槸杩欐牱鐨�");
			}
		});
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		f1.add(p1, BorderLayout.SOUTH);
		drawArea1.setPreferredSize(new Dimension(250, 180));
		drawArea2.setPreferredSize(new Dimension(300, 180));
		f1.add(drawArea1, BorderLayout.EAST);
		f1.add(drawArea2, BorderLayout.WEST);
		f1.pack();
		f1.setVisible(true);
	}

	public static void main(String args[]) {
		new YJY2();
	}

	class Mycanvas extends Canvas {
		public void paint(Graphics g) {
			g.drawRect(80, 60, 150, 92);
//			g.drawOval(90, 70, 100, 60);
		}

		public void update(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}
}