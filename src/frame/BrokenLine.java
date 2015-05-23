package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class BrokenLine extends JFrame {
    public static void main(String args[]) { 
        BrokenLine frame = new BrokenLine(); 
        frame.setVisible(true);
    }
    
    public BrokenLine() {
        super(); 
        setTitle("设置虚线模式");
        setBounds(100, 100, 326, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        add(new DashedModelPanel()); 
    }
    
    class DashedModelPanel extends JPanel { 
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D)g; 
            float[] arr = {4.0f,2.0f}; 
//            float[] arr = {5.0f,3.0f,2.0f,3.0f};  //另一种虚线模型
            BasicStroke stroke = new BasicStroke(1,
              BasicStroke.CAP_BUTT,
              BasicStroke.JOIN_BEVEL,
              1.0f,arr,0); 
            g2.setStroke(stroke);
            Line2D.Float line = new Line2D.Float(20,50,300,50);
            g2.draw(line);
        }
    }
}

