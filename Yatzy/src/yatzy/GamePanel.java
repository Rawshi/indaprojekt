package yatzy;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A Backround panel where every 
 * @author Mig
 *
 */
public class GamePanel extends JPanel {

	private JButton rollButton;
	private GridBagConstraints c;
	private Dice[] dices;
	private int rollCount;
	
	public GamePanel() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		rollButton = new JButton("Roll");
		c = new GridBagConstraints();	
		dices = new Dice[5];
		rollCount = 0;

		for(int i = 0; i < 5; i++){
			dices[i] = new Dice();
			c.gridx = 0;
			c.gridy = i;
			add(dices[i].addDice(), c);

		}

		rollButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(rollCount == 3) {
					rollButton.setEnabled(false);
				} else {
					for(int i = 0; i < 5; i++){
						dices[i].roll();
					}
					rollCount++;
				}

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