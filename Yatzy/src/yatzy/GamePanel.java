package yatzy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * A Backround panel where the dice are placed
 * 
 * @author Mig
 * 
 */
public class GamePanel extends JPanel {

	private JButton rollButton;
	private Dice[] dices;
	private int rollCount;

	public GamePanel() {
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(200, 600));
		rollButton = new JButton("Roll");
		GridBagConstraints c = new GridBagConstraints();
		dices = new Dice[5];
		rollCount = 0;

		for (int i = 0; i < 5; i++) {
			dices[i] = new Dice();
			c.gridx = 0;
			c.gridy = i;
			add(dices[i].addDice(), c);

		}

		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rollCount == 0) {
					for (int i = 0; i < dices.length; i++) {
						if (dices[i].rollCheck()) {
							JOptionPane
									.showMessageDialog(null,
											"You can't roll while previous dice are locked");
							return;
						}
					}
				}
				if (rollCount == 2) {
					rollAllDice();
					rollCount++;
					rollButton.setEnabled(false);
				} else {
					rollAllDice();
				}
				rollCount++;

			}
		});
		c.gridx = 1;
		c.gridy = 2;
		c.ipadx = 40;
		c.ipady = 20;
		add(rollButton, c);
	}

	public void resetRoll() {
		rollCount = 0;
		rollButton.setEnabled(true);
		for (int i = 0; i < 5; i++){
         dices[i].unlock();
         dices[i].setVisible(false);
		}
	}

	public int getRollCount() {
		return rollCount;
	}

	public int[] getDiceSides() {
		    return new int[]{
			dices[0].getSideUp(),
			dices[1].getSideUp(),
			dices[2].getSideUp(),
			dices[3].getSideUp(),
			dices[4].getSideUp(),
		};
			
		
	}

	private void rollAllDice() {
		for (int i = 0; i < 5; i++) {
			dices[i].roll();
			dices[i].setVisible(true);
		}
	}

	/**
	 * Kommer antagligen inte att behövas.
	 */
	// @Override
	// public void paintComponent(Graphics g){
	// super.paintComponent(g);
	//
	// // Image dice1 =
	// Toolkit.getDefaultToolkit().getImage("resources/dice_1.jpg");
	//
	// // g.drawImage(dice1, 150, 10, this);
	//

}