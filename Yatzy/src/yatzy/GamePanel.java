package yatzy;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
 
public class GamePanel extends JPanel {
	public GamePanel() {
     setBorder(BorderFactory.createLineBorder(Color.black));
	 GridBagConstraints c = new GridBagConstraints();	
	 Dice dice1 = new Dice();
	 Dice dice2 = new Dice();
	 
	 add(dice1.addDice(1));
	 add(dice2.addDice(2));
	}
	/**
	 * Kommer antagligen inte att behövas.
	 */
//	@Override
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//
//	   // Image dice1 = Toolkit.getDefaultToolkit().getImage("resources/dice_1.jpg");
//	    
//		// g.drawImage(dice1, 150, 10, this);
//

	}