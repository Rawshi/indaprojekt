package yatzy;

import javax.swing.JLabel;

/**
 * 
 * 
 * @author Edvard Mickos
 * @version 1.0
 */
public class ScoreSquare extends JLabel{

	private boolean hasScore = false;
	private int score;

	public ScoreSquare(){
	}

	public void setScore(int result){
		score = result;
		hasScore = true;
	}

	public boolean hasScore(){
		return hasScore;
	}

	public int getScore(){
		return score;
	}


}
