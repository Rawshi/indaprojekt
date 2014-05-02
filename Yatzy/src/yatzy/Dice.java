package yatzy;

import java.util.Random;

/**
 * Class Dice - Constructs a dice
 * 
 * @author Kashmir Klingestedt & Edvard Mickos
 * @version 1.0
 */
public class Dice {
 
	private static final int SIDES = 6;
	private boolean locked;
	private Random randomGen;
	private int sideUp;
	private int x;
	private int y;
	
	/**
	 * Constructor for Dice
	 */
	public Dice(int x, int y) {
		locked = false;
		randomGen = new Random();
		sideUp = 1;
		drawDice(sideUp, locked);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Draws the dice
	 */
	public void drawDice(int side, boolean locked) {
		
	}
	
	/**
	 * Rolls the dice
	 */
	public void roll() {
		if(!locked) {
			//roll
			sideUp = randomGen.nextInt(SIDES)+1;
			drawDice(sideUp, locked);
		}
	}
	
	/**
	 * Locks the dice
	 */
	public void lock() {
		locked = true;
		drawDice(sideUp, locked);
	}
	
	/**
	 * Unlocks the dice
	 */
	public void unlock() {
		locked = false;
		drawDice(sideUp, locked);
	}
}
