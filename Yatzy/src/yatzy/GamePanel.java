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
	
	JButton rollButton;
	GridBagConstraints con;
	Dice[] dices;
	
	public GamePanel() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		rollButton = new JButton("Roll");
		con = new GridBagConstraints();	
		dices = new Dice[5];

		for(int i = 0; i < 5; i++){
			dices[i] = new Dice();
			add(dices[i].addDice());
	
		}
		
        rollButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        	for(int i = 0; i < 5; i++){
    			dices[i].roll();
    	
    		}
        	}
		});
        add(rollButton);
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