package Bite_Beat_1;

public class Beat {
	private int time;
	private String noteName;
	private int gameScore;
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public int getGameScore() {
		return gameScore;
	}
	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}
	public Beat(int time, String noteName) {
		super();
		this.time = time;
		this.noteName = noteName;
	}	
	

}
