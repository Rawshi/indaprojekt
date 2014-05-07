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
	}
	public void addDice(ImageIcon icon, ImageIcon icon2){
		JToggleButton dice = new JToggleButton();
		dice.setIcon(icon);
		dice.addItemListener(new ItemListener() {
			   public void itemStateChanged(ItemEvent ev) {
			      if(ev.getStateChange()==ItemEvent.SELECTED){
			        System.out.println("no rawr");
			      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
			        System.out.println("rawr");
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