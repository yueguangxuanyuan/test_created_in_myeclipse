package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyCanvas extends Canvas {

	private static final long serialVersionUID = 1L;

	// 窗体的宽与高

	public static final int WIDTH = 480;

	public static final int HEIGHT = 480;

	private Image screen = createImage(WIDTH, HEIGHT, true);// 双缓冲

	private Graphics graphics = screen.getGraphics();

	private Image resultImage;

	/**
	 * 
	 * 生成一个BufferImage
	 * 
	 * 生成一个BufferImage BufferImage是Image的子类，左上角坐标都为 (0, 0)
	 * 
	 * 第三个参数是代码Image图形类型，分为14种，以位数又分为1，2或4位
	 * 
	 * 
	 * 
	 * @param width
	 * 
	 * @param height
	 * 
	 * @param flag
	 * 
	 * @return
	 */

	final static public BufferedImage createImage(int width, int height,

	boolean flag) {

		if (flag) {

			return new BufferedImage(width, height, 2);

		} else {

			return new BufferedImage(width, height, 1);

		}

	}

	public MyCanvas() {

		// 设定初始构造时面板大小

		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		// 初始导入一张图片

		ImageIcon icon = new ImageIcon("./image/1.gif");

		resultImage = icon.getImage();

	}

	//

	@Override
	public void update(Graphics g) {

		graphics.drawImage(resultImage, 0, 0, this);

		g.drawImage(screen, 0, 0, null);// 最后个参数一定要用null，这样可以防止drawImage调用update方法

		g.dispose();

	}

	public void paint(Graphics g) {

		update(g);// 我们在paint方法中，直接调用update方法

	}
	
	public static void main(String[] args){
		MyCanvas myCanvas = new MyCanvas();
	}

}