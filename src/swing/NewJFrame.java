package swing;

/*
 * NewJFrame.java
 *
 * Created on 2008年2月2日, 上午11:06
 */

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;

import java.util.Queue;

/**
 * 
 * @author Administrator
 */
public class NewJFrame extends javax.swing.JFrame {

	/** Creates new form. NewJFrame. */
	public NewJFrame() {
		Files f;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form. Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc=" 生成的代码 ">
	private void initComponents() {
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new MyTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new NewJFrame().setVisible(true);
			}
		});
	}

	class MyTextArea extends JTextArea implements DropTargetListener {
		public MyTextArea() {
			new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
		}

		public void dragEnter(DropTargetDragEvent dtde) {
		}

		public void dragOver(DropTargetDragEvent dtde) {
		}

		public void dropActionChanged(DropTargetDragEvent dtde) {
		}

		public void dragExit(DropTargetEvent dte) {
		}

		public void drop(DropTargetDropEvent dtde) {
			try {
				//得到可传输对象
				Transferable tr = dtde.getTransferable();
                //验证对象会否是文件流
				if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
					//验证文件流是否有对应的操作权限
					dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
					// System.out.println("file cp");
					//获取文件流
					List list = (List) (tr
							.getTransferData(DataFlavor.javaFileListFlavor));
					//声明缓冲队列
					Queue<File> waitList = new LinkedList<File>(list);
					StringBuilder sb = new StringBuilder();
					int splitIndex = -1;
					//获取前缀文件路径长度，为之后的去除文件前缀 提供方案
					if (!list.isEmpty()) {
						splitIndex = ((File) list.get(0)).getParent().length();
					}
					while (!waitList.isEmpty()) {
						File f = (File) waitList.poll();
						sb.append(f.getAbsolutePath().substring(splitIndex));
						if (f.isDirectory()) {
							sb.append("\\");
							File[] tempFiles = f.listFiles();
							for (File tempFile : tempFiles) {
								waitList.add(tempFile);
							}
						}
						sb.append("\n");
					}
					this.setText(sb.toString());
					dtde.dropComplete(true);
					this.updateUI();
				} else {
					dtde.rejectDrop();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} catch (UnsupportedFlavorException ufe) {
				ufe.printStackTrace();
			}
		}

	}

	// 变量声明 - 不进行修改
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	// 变量声明结束

}
