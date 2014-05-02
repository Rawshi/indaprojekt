package yatzy;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Graphics;

public class Game {
 
   	
  public static void main(String args[]) {
	  Dice[] dice = new Dice[5];
	  SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              createGameGUI(); 
          }
  });
	  
 }
  
  private static void createGameGUI(){
      JFrame gameField = new JFrame("Yatzy");
      gameField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gameField.setSize(500,500);
      gameField.setVisible(true);
      
  }
}

class GamePanel extends JPanel {
	
	public GamePanel() {
		
	    
	}
}