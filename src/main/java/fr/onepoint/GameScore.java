package fr.onepoint;

public abstract class GameScore{
	
	protected int point=0;
	protected int game = 0;
	protected int set = 1;
	protected int tieBreakPoint=0;
	
	public abstract int getPoint();
	public abstract int getGame();
	public abstract int getSet();
	public abstract int getTieBreakPoint();

}
