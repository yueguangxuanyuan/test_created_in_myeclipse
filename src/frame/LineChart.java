package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

public class LineChart extends JPanel {

    
	int Default_Width = 600;
	int Default_Height = 370;
	int horizon_margin = 50;
	int vertic_margin = 30;
	String title = "鏆傛棤";
	String y= "";
	double[] data;
	public LineChart(String title,double[] data,String y){
		this.title = title;
		setSize(Default_Width, Default_Height);
		this.data = data;
		this.y = y;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon img = new ImageIcon("image/bkgd1.jpg");
		g.drawImage(img.getImage(), 0,0,Default_Width,Default_Height,this);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setPaint(Color.black);
		
		drawAL(horizon_margin,Default_Height-vertic_margin,Default_Width-horizon_margin,Default_Height-vertic_margin,false,g2);
		drawAL(horizon_margin,Default_Height-vertic_margin,horizon_margin,vertic_margin,true,g2);
		
		int vertic_gap  = (Default_Height - 2*vertic_margin -20) /5;
		int horizon_gap = (Default_Width - 2*horizon_margin - 20)/7;
	    
		if(!title.equals("鏆傛棤")){
		  g2.drawString(title, (Default_Width-50)/2, 30);
		}
		
		double vertic_max = 0;
		for(int i = 0 ; i < 7 ;i++){
			vertic_max = vertic_max >= data[i] ? vertic_max:data[i];
		}
		
		int vertic_interval = (int)(vertic_max/5)+1;
		
		
		g2.drawString("0", horizon_margin-30, Default_Height-vertic_margin);
		for(int i = 1 ; i <= 5 ; i++){
			g2.drawLine(horizon_margin, Default_Height-vertic_margin - i*vertic_gap,horizon_margin+5, Default_Height-vertic_margin - i*vertic_gap);
		    g2.drawString(""+i*vertic_interval,horizon_margin-30, Default_Height-vertic_margin - i*vertic_gap + 5);
		}
		
		
		int height = 5*vertic_gap;
		int height_num = 5*vertic_interval;
		int[] temp_y = new int[7];
		
		for(int i = 1 ; i <= 7 ; i++){
			g2.drawLine(horizon_margin+i*horizon_gap, Default_Height-vertic_margin,horizon_margin+i*horizon_gap, Default_Height-vertic_margin-5);
			if(7- i >0){
				g2.drawString((7-i)+"澶╁墠", horizon_margin+i*horizon_gap-20, Default_Height-vertic_margin+15);
			}else{
				g2.drawString("褰撳ぉ", horizon_margin+i*horizon_gap-20, Default_Height-vertic_margin+15);
			}
			
			temp_y[i-1] = Default_Height-vertic_margin - (int)((data[i-1]*1.0/height_num)*height);
			g2.drawOval(horizon_margin+i*horizon_gap-2, temp_y[i-1]-2, 4, 4);
			g2.drawString(data[i-1]+"",horizon_margin+i*horizon_gap-10, temp_y[i-1]-5);
			
			
			
			if(i > 1){
				g2.drawLine(horizon_margin+(i-1)*horizon_gap, temp_y[i-2], horizon_margin+i*horizon_gap, temp_y[i-1]);
			}
			
		}
		
		g2.drawString("鍗曚綅锛�"+y, horizon_margin-30,vertic_margin);
		for(int i= 1 ; i <= 7 ; i++){
			drawBrokenLine( horizon_margin+i*horizon_gap, Default_Height-vertic_margin,  horizon_margin+i*horizon_gap, temp_y[i-1], g2);
			drawBrokenLine(horizon_margin, temp_y[i-1], horizon_margin+i*horizon_gap, temp_y[i-1], g2);
		}
		
		
	}
	
	public static void drawAL(int sx, int sy, int ex, int ey,boolean isVertic, Graphics2D g2){

		double H = 10; // 绠ご楂樺害
		double L = 4; // 搴曡竟鐨勪竴鍗�
		int x3 = 0;
		int y3 = 0;
		int x4 = 0;
		int y4 = 0;
		
		if(isVertic){
			x3 = (int) (ex - L);
			y3 = (int) (ey +H);
			x4 = (int) (ex + L);
			y4 = (int) (ey +H);
			
		}else{
			
			x3 = (int) (ex - H);
			y3 = (int) (sy +L);
			x4 = (int) (ex - H);
			y4 = (int) (sy -L);
		}
		
		// 鐢荤嚎
		g2.drawLine(sx, sy, ex, ey);
		//
		GeneralPath triangle = new GeneralPath();
		triangle.moveTo(ex, ey);
		triangle.lineTo(x3, y3);
		triangle.lineTo(x4, y4);
		triangle.closePath();
		//瀹炲績绠ご
		g2.fill(triangle);

	}
	
	public void drawBrokenLine(int sx,int sy,int ex,int ey,Graphics2D g2){
		 float[] arr = {4.0f,2.0f}; 
//       float[] arr = {5.0f,3.0f,2.0f,3.0f};  //鍙︿竴绉嶈櫄绾挎ā鍨�
       BasicStroke stroke = new BasicStroke(1,
         BasicStroke.CAP_BUTT,
         BasicStroke.JOIN_BEVEL,
         1.0f,arr,0); 
       g2.setStroke(stroke);
       Line2D.Float line = new Line2D.Float(sx,sy,ex,ey);
       g2.draw(line);
       
	}
    
    
	
	public static void main(String[] args) {
		JFrame drawTriange = new JFrame("triangle");
        drawTriange.setSize(600,400);
        drawTriange.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        double[] data = {1,3,2,10,6,5,8};
        LineChart myDrawTriangle = new LineChart("姣忔棩灞�暟鏇茬嚎",data,"鍒�");
        
        drawTriange.add(myDrawTriangle);
        
        drawTriange.setVisible(true);
	}
}
