package yatzy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class Scoresheet - Constructs the score sheet, etc.
 * 
 * @author Kashmir Klingestedt & Edvard Mickos
 * @version 1.0
 */
public class Scoresheet extends JPanel {

	int players;
	private int columns;
	private static final int ROWS = 19;
	private int currentPlayer = 1;
	JLabel[][] results;
	public String[] rules = new String[19]; {
		rules[1] = "Ones";
		rules[2] = "Twos";
		rules[3] = "Threes";
		rules[4] = "Fours";
		rules[5] = "Fives";
		rules[6] = "Sixes";
		rules[7] = "Sum";
		rules[8] = "Bonus";
		rules[9] = "1 pair";
		rules[10] = "2 pair";
		rules[11] = "3 of a kind";
		rules[12] = "4 of a kind";
		rules[13] = "Small Straight";
		rules[14] = "Large Straight";
		rules[15] = "Full House";
		rules[16] = "Chance";
		rules[17] = "Yatzy";
		rules[18] = "Total";
	}

	/**
	 * Constructor for Score sheet
	 */
	public Scoresheet(int players, Dice[] dices) {
		columns=players+1;
		results = new JLabel[players][ROWS];
		setLayout(new GridBagLayout());
		GridBagConstraints grid = new GridBagConstraints();
		for (int i=1; i<ROWS; i++){
			JButton button = new JButton(rules[i]);
			addScore(button, i);
			grid.fill = GridBagConstraints.HORIZONTAL;
			grid.gridx = 0;
			grid.gridy = i;
			add(button, grid);
		 }
		
		for (int i=1; i<results.length; i++){
			for( int j=1; j<results[0].length; j++){
			JLabel l = new JLabel();
			l.setMinimumSize(new Dimension(20,5));
			l.setPreferredSize(new Dimension(20,5));
			grid.fill = GridBagConstraints.HORIZONTAL;
			l.setText("1505");
			l.setOpaque(true);
			l.setBackground(Color.white);
			grid.insets = new Insets(0,10,10,0);
			grid.gridx = i;
			grid.gridy = j;
			grid.ipadx = 20;
			grid.ipady = 10;
			results[i][j]=l;
			add(l, grid);
			}
		}
		}

		/**
		 * Checks the values of the dices to figure out where it is allowed to put the score.
		 */
		public void addScore(JButton b, int row){
	    switch (row) {
         case 1:
          b.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e){
			  System.out.println("dix");
		  }	
		    });
		  break;
         case 2:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  System.out.println("nodix");
       		  }	
       		    });
        	 break;
         case 3:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 4:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 5:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 6:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 7:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 8:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 9:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 10:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 11:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 12:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 13:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 14:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 15:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 16:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 17:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
         case 18:
        	 b.addActionListener(new ActionListener(){
       		  public void actionPerformed(ActionEvent e){
       			  
       		  }	
       		    });
        	 break;
		}
	}
}
