package yatzy;

import javax.swing.JLabel;

public class ScoreSquare extends JLabel{

	private boolean hasScore=false;
	private int score;
	
	public ScoreSquare(){
	}
	
	public void setScore(int result){
		score = result;
		hasScore=true;
	}
	
	public boolean hasScore(){
		return hasScore;
	}
	
	public int getScore(){
		return score;
	}
	
	
}
