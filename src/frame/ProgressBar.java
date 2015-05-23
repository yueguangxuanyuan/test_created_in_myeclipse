package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
public class ProgressBar implements ActionListener{
 private static final String DEFAULT_STATUS = "Please Waiting";
    private JDialog dialog;
    private JProgressBar progressBar;
    private JLabel lbStatus;
    private JButton btnCancel;
    private Window parent;  
    private Thread thread;  //澶勭悊涓氬姟鐨勭嚎绋�
    private String statusInfo; 
    private String resultInfo; 
    private String cancelInfo;
    public ProgressBar(){
        Thread thread = new Thread()
        {
            public void run()
            {
                int index = 0;
                while(index < 5)
                {
                    try
                    {
                        sleep(1000);  
                        ++index;
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
        ProgressBar.show((Frame)null, thread, "姝ｅ湪鐧婚檰绯荤粺,璇风◢鍊欌�鈥�", "鐧婚檰鎴愬姛", "鐧婚檰澶辫触锛岃鏌ョ湅鏁版嵁搴撴槸鍚﹁繛鎺ワ紒");        
    }
    public static void show(Window parent, Thread thread)
    {
        new ProgressBar(parent, thread, DEFAULT_STATUS, null, null);
    }
   
    public static void show(Window parent, Thread thread, String statusInfo)
    {
        new ProgressBar(parent, thread, statusInfo, null, null);
    }
   
    public static void show(Window parent, Thread thread, String statusInfo,String resultInfo, String cancelInfo)
    {
        new ProgressBar(parent, thread, statusInfo, resultInfo, cancelInfo);
    }
   
    private ProgressBar(Window parent, Thread thread, String statusInfo,String resultInfo, String cancelInfo)
    {
        this.parent = parent;
        this.thread = thread;
        this.statusInfo = statusInfo;
        this.resultInfo = resultInfo;
        this.cancelInfo = cancelInfo;
        initUI();
        startThread();
        dialog.setVisible(true);
    }
    private void initUI()
    {
        if(parent instanceof Dialog)
        {
            dialog = new JDialog((Dialog)parent,  true);
        }
        else if(parent instanceof Frame)
        {
            dialog = new JDialog((Frame)parent,  true);
        }
        else
        {
            dialog = new JDialog((Frame)null,  true);
        }
        final JPanel mainPane = new JPanel(null);
        progressBar = new JProgressBar();
        lbStatus = new JLabel("" + statusInfo);
        btnCancel = new JButton("Cancel");
        progressBar.setIndeterminate(true);
        btnCancel.addActionListener(this);
        mainPane.add(progressBar);
        mainPane.add(lbStatus);
        dialog.getContentPane().add(mainPane);
        dialog.setUndecorated(true);//闄ゅ幓title
        dialog.setResizable(true);
        dialog.setSize(390, 100);
        dialog.setLocationRelativeTo(parent); //璁剧疆姝ょ獥鍙ｇ浉瀵逛簬鎸囧畾缁勪欢鐨勪綅缃�
             
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // 涓嶅厑璁稿叧闂�
       
        mainPane.addComponentListener(new ComponentAdapter()
        {
            public void componentResized(ComponentEvent e)
            {
                layout(mainPane.getWidth(), mainPane.getHeight());
            }
        });
    }
    private void startThread()
    {
        new Thread()
        {
            public void run()
            {
                try
                {
                    thread.start(); // 澶勭悊鑰楁椂浠诲姟
                    // 绛夊緟浜嬪姟澶勭悊绾跨▼缁撴潫
                    thread.join();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    // 鍏抽棴杩涘害鎻愮ず妗�
                    dialog.dispose();
                    if(resultInfo != null && !resultInfo.trim().equals(""))
                    {
                        String title = "娑堟伅";
                        JOptionPane.showMessageDialog(parent, resultInfo, title,JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }.start();
    }
    private void layout(int width, int height)
    {
        progressBar.setBounds(20, 20, 350, 15);
        lbStatus.setBounds(20, 50, 350, 25);
        btnCancel.setBounds(width - 85, height - 31, 75, 21);
    }
    @SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent e)
    {
        resultInfo = cancelInfo;
        thread.stop();
    }  
    public static void main(String[] args) throws Exception{
     new ProgressBar();
    }
}
