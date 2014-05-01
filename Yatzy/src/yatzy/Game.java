package yatzy;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Game {
 
   	
  public static void main(String args[]) {
	  if (args.length > 1){
		  System.exit(1);
	  }
	  final int PLAYERAMOUNT = args[0];
	  SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              creatGameGUI(); 
          }
  });
	  
  }
  private static void createGameGUI(){
      JFrame gameField = new JFrame("Yatzy");
      gameField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
  }
}
