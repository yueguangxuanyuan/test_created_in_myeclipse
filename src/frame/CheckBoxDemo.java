package frame;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxDemo extends Applet implements ItemListener {
	String msg = " ";
	Checkbox WinXP, WinNT, solaris, mac;

	public void init() {
		WinXP = new Checkbox("WindowsXP", null, true);
		WinNT = new Checkbox("Window NT/2000");
		solaris = new Checkbox("Solaris");
		mac = new Checkbox("MacOS");
		add(WinXP);
		add(WinNT);
		add(solaris);
		add(mac);
		WinXP.addItemListener(this);
		WinNT.addItemListener(this);
		solaris.addItemListener(this);
		mac.addItemListener(this);
	}

	public void itemStateChanged(ItemEvent ie) {
		repaint();
	}

	public void paint(Graphics g) {
		msg = "��ǰϵͳ��:";
		g.drawString(msg, 6, 80);
		msg = "Windows XP:" + WinXP.getState();
		g.drawString(msg, 6, 100);
		msg = "Windows NT/2000:" + WinNT.getState();
		g.drawString(msg, 6, 120);
		msg = "Solaris :" + WinXP.getState();
		g.drawString(msg, 6, 140);
		msg = "MacOS :" + mac.getState();
		g.drawString(msg, 6, 160);
	}
}