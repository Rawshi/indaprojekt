package yatzy;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

/**
 * Class Dice - Constructs a dice
 * 
 * @author Kashmir Klingestedt & Edvard Mickos
 * @version 1.0
 */
public class Dice {

	private static final int SIDES = 6;
	private boolean locked;
	private boolean invisible;
	private int sideUp;
	ImageIcon[] diceImage = new ImageIcon[6];
	ImageIcon[] diceLockedImage = new ImageIcon[6];
	JToggleButton dice = new JToggleButton();

	/**
	 * Constructor for Dice
	 */
	public Dice() {
		locked = false;
		sideUp = 0;
		for (int i = 0; i< 6; i++){
			Image image= Toolkit.getDefaultToolkit().getImage("resources/dice_"+i+".jpg");
			diceImage[i] = new ImageIcon(image);
			image = Toolkit.getDefaultToolkit().getImage("resources/locked_dice_"+i+".jpg");
			diceLockedImage[i] = new ImageIcon(image);
		}
	}

	/**
	 * Draws the dice
	 */
	public JToggleButton addDice() {
		dice.setIcon(diceImage[0]);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		dice.setBorder(emptyBorder);
		dice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange()==ItemEvent.SELECTED){
					lock();
				} else if(ev.getStateChange()==ItemEvent.DESELECTED){
					unlock();
				}
			}
		});
		dice.setVisible(false);
		return dice;
	}

	/**
	 * Rolls the dice
	 */
	public void roll() {
		if(!locked) {
			//roll
			Random randomGen = new Random();
			sideUp = randomGen.nextInt(SIDES);
			dice.setIcon(diceImage[sideUp]);
			dice.setSelected(false);
			System.out.println(sideUp);
		}
	}

	/**
	 * Locks the dice
	 */
	public void lock() {
		locked = true;
		dice.setIcon(diceLockedImage[sideUp]);
	}

	/**
	 * Unlocks the dice
	 */
	public void unlock() {
		locked = false;
		dice.setIcon(diceImage[sideUp]);
	}
	
	public boolean rollCheck() {
		return locked;
	}
	/**
	 * returns the current side Up
	 */
	public int getSideUp() {
		return sideUp; 
	}
	
	public void setVisible(boolean isVisible){
		dice.setVisible(isVisible);
	}
}
