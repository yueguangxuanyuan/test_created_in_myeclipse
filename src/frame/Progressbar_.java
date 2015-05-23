package frame;

import javax.swing.*;
import java.awt.*;
public class Progressbar_ extends JFrame {
 public Progressbar_(){
  super();
  setSize(100,100);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setVisible(true);
  JProgressBar progressBar = new JProgressBar();
  getContentPane().add(progressBar,BorderLayout.NORTH);
  progressBar.setStringPainted(true);
  for (int i = 0;i < 50;i++){
   progressBar.setValue(i);
   try {
    Thread.sleep(100);
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
  }
 }
 public static void main(String[] args) {
  new Progressbar_();
 }
}
