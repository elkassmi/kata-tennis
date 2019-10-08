package fr.onepoint;

public class Player extends GameScore implements GameManager {
	private String name;

	public Player(String name) {
		super();
		this.name = name;
	}

	public void wonPoint() {
		this.point++;
	}

	public void wonGame() {
		this.game++;
		this.point = 0;
	}

	public void wonSet() {
		this.set++;
		this.game = 0;
		this.point = 0;

	}

	public void wonPointTieBreak() {
		this.tieBreakPoint++;
	}

	@Override
	public int getGame() {
		return this.game;
	}

	@Override
	public int getSet() {
		return this.set;
	}

	@Override
	public int getTieBreakPoint() {
		return this.tieBreakPoint;
	}

	@Override
	public void wonMatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPoint() {
		return this.point;
	}

	public String getName() {
		return name;
	}

	public StringBuffer getDisplayScore() {
		StringBuffer displayScore = new StringBuffer();
		displayScore.append("The " + this.name + " score is ");
		displayScore.append(this.getPoint() >= 3 ? 40 : this.getPoint() * 15);
		displayScore.append(",Set: " + set);
		return displayScore;
	}

	
}
