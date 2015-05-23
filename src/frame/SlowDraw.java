package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlowDraw extends JFrame{
	int x ;
	SlowDraw slowDraw = this;
	
    Timer timer;
	Point start = new Point(0,200);
	Point end = new Point(200,100);
	public SlowDraw(){
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		x = 0;
		
		timer = new Timer(100,new Timer_AL());
		timer.start();
	}
	
	class Timer_AL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(x <= 200){
				
				x = x+10;
				slowDraw.repaint();
			}else{
				timer.stop();
			}
			
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		if( x < end.x){
			g.drawLine(start.x,start.y, x, start.y + (end.y -start.y)*(x-start.x)/(end.x - start.x));
		}else{
		    g.drawLine(start.x , start.y , end.x,end.y);	
		}
		
	}



	public static void main(String[] args){
		 SlowDraw slowDraw = new SlowDraw();
	}

}
