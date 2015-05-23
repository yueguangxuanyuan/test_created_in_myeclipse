package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

class CircleButton extends JButton {
	private static final long serialVersionUID = 1L;
	Shape shape;
	Color bgColor = SystemColor.control;

	public CircleButton() {
		this("δ����", null);
	}

	public CircleButton(String label) {
		this(label, null);
	}

	public CircleButton(String label, Color bgColor) {
		super(label); // ���ø��๹�췽��
		if (bgColor != null) {
			this.bgColor = bgColor;
		}
		Dimension size = this.getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		this.setPreferredSize(size); // ���ÿ�ߵȾ�
		this.setContentAreaFilled(false); // ��������������
		this.setBorderPainted(false); // �����Ʊ߿�
		this.setFocusPainted(false); // �����ƽ���״̬
	}

	protected void paintComponent(Graphics g) {
		// �����갴�£�isArmed()��������true
		if (this.getModel().isArmed()) {
			g.setColor(java.awt.SystemColor.controlHighlight);
		} else {
			g.setColor(java.awt.SystemColor.controlShadow);
			g.setColor(this.bgColor); // ���ñ�����ɫ
		}
		g.fillOval(0, 0, this.getSize().width - 1, this.getSize().height - 1); // ����Բ�α�������
		g.setColor(java.awt.SystemColor.controlShadow); // ���ñ߿���ɫ
		g.drawOval(0, 0, this.getSize().width - 1, this.getSize().height - 1); // ���Ʊ߿���
		super.paintComponent(g);
	}

	public boolean contains(int x, int y) {
		if ((shape == null) || (!shape.getBounds().equals(this.getBounds()))) {
			this.shape = new Ellipse2D.Float(0, 0, this.getWidth(),
					this.getHeight());
		}
		return shape.contains(x, y);
	}
}

class CircleButtonTest {
	public static void main(String[] args) {
		JFrame jf = new JFrame("�Զ��尴ť");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(350, 280);
		jf.setLocationRelativeTo(null);
		jf.setLayout(new FlowLayout());
		Color arrColor[] = new Color[] { Color.blue, Color.black, Color.red,
				Color.yellow, Color.green };
		for (int i = 0; i < 5; i++) {
			CircleButton cb = new CircleButton("Բ�ΰ�ť" + (i + 1), arrColor[i]);
			jf.getContentPane().add(cb);
			cb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "������Բ�ΰ�ť");
				}
			});
		}
		jf.setVisible(true);
	}
}
