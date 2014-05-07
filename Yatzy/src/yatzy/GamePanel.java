package yatzy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
 
public class GamePanel extends JPanel {
	public GamePanel() {
     setBorder(BorderFactory.createLineBorder(Color.black));
	 GridBagConstraints c = new GridBagConstraints();	
	 Image image= Toolkit.getDefaultToolkit().getImage("resources/dice_1.jpg");
	 ImageIcon icon = new ImageIcon(image);
	 image =  Toolkit.getDefaultToolkit().getImage("resources/dice_2.jpg");
	 ImageIcon icon2 = new ImageIcon(image);
	 addDice(icon, icon2);
	 addDice(icon2, icon);
	}
	public void addDice(final ImageIcon icon, final ImageIcon icon2){
		final JToggleButton dice = new JToggleButton();
		dice.setIcon(icon);
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