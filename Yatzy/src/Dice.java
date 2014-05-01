public class Dice {
 
	public boolean locked;
	public int diceFace;
	
	public void roll(){
		diceFace = (int)(6.0 * Math.random()) +1;
	}
}
