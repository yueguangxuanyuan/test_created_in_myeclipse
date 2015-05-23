package frame;
//failure

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ��������������ͼ��
 * 
 * @author �Ƹ���
 */
public class TestTray extends JFrame implements Runnable {

	private SystemTray sysTray;// ��ǰ����ϵͳ�����̶���

	private TrayIcon trayIcon;// ��ǰ���������

	private int num = 10;

	ImageIcon icon = null;

	public TestTray() {
		this.createTrayIcon();// �������̶���
		init();
	}

	/**
	 * ��ʼ������ķ���
	 */
	/**
  * 
  */
	public void init() {
		this.setTitle("��������");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// ��Ӵ����¼�,��������ӵ�����ϵͳ������
		this.addWindowListener(new WindowAdapter() {

			public void windowIconified(WindowEvent e) {
				addTrayIcon();
			}
		});

		this.setVisible(true);
	}

	/**
	 * ������̵ķ���
	 */
	public void addTrayIcon() {
		try {
			sysTray.add(trayIcon);// ��������ӵ�����ϵͳ������
			setVisible(false);// ʹ�õ�ǰ�Ĵ�������
			new Thread(this).start();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * ����ϵͳ���̵Ķ��� ����: 1,��õ�ǰ����ϵͳ�����̶��� 2,���������˵�popupMenu 3,��������ͼ��icon
	 * 4,����ϵͳ�����̶���trayIcon
	 */
	public void createTrayIcon() {
		sysTray = SystemTray.getSystemTray();// ��õ�ǰ����ϵͳ�����̶���
		icon = new ImageIcon("image/1.gif");// ����ͼ��
		PopupMenu popupMenu = new PopupMenu();// �����˵�
		MenuItem mi = new MenuItem("����");
		MenuItem exit = new MenuItem("�ر�");
		popupMenu.add(mi);
		popupMenu.add(exit);
		// Ϊ�����˵�������¼�
		mi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				sysTray.remove(trayIcon);
			}
		});
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		trayIcon = new TrayIcon(icon.getImage(), "��������", popupMenu);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestTray testTray = new TestTray();
	}

	/*
	 * �߳̿������� (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (num >= 0) {
			this.trayIcon.setImage(new ImageIcon("").getImage());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.trayIcon.setImage(icon.getImage());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num--;
		}
	}

}
