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
	 ImageIcon[] diceImages = new ImageIcon[6];
	 for (int i = 0; i< 6; i++){
			Image image= Toolkit.getDefaultToolkit().getImage("resources/dice_"+i+".jpg");
			diceImages[i] = new ImageIcon(image);
			}
	 
	 addDice(diceImages[1], diceImages[2]);
	 addDice(diceImages[2], diceImages[3]);
	}
	public void addDice(final ImageIcon icon, final ImageIcon icon2){
		final JToggleButton dice = new JToggleButton();
		dice.setIcon(icon);
		Border emptyBorder = BorderFactory.createEmptyBorder();
    	dice.setBorder(emptyBorder);
		dice.addItemListener(new ItemListener() {
			   public void itemStateChanged(ItemEvent ev) {
			      if(ev.getStateChange()==ItemEvent.SELECTED){
			        dice.setIcon(icon2);
			      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
			        dice.setIcon(icon);
			      }
			   }
		 });
		 add(dice);
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