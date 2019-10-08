package fr.onepoint;

public class TennisGameManager {

	private Player playerOne;
	private Player playerTwo;
	
	private String message;
	
	private boolean isTieBreak = false;
	

	public TennisGameManager(String playerOneName, String playerTwoName) {
		this.playerOne = new Player(playerOneName);
		this.playerTwo = new Player(playerTwoName);
		
	}

	public void playerOneWonPoint() {
		if(isTieBreak) {
			playerOne.wonPointTieBreak();
		}else {
			playerOne.wonPoint();
		}
		
		displayScore(playerOne);
	}
	
	public void playerTwoWonPoint() {
		if(isTieBreak) {
			playerTwo.wonPointTieBreak();
		}else {
			playerTwo.wonPoint();
		}
		
		displayScore(playerTwo);
		
		
	}
	
	public void checKScore() {
		if (hasWinner()) {
			Player player = playerWithHighestScore();
			updateScore(player);
			message=  player.getName()+ " wins";
		}
		
		if (hasAdvantage()) { 
			message =  "Advantage " + playerWithHighestScore().getName(); 
		}
		
		if (isDeuce())
			message= "Deuce";
		
	}
	
	public String getSet() {
		if(hasWinnerMatch()) {
			message= playerWithHighestScore().getName() + " win match";
			return playerWithHighestScore().getName() + " win match";
		}
		if(playerOne.getSet()==playerTwo.getSet()) {
			this.isTieBreak = true;
			return "Tie-Break";
		}
		
		return message;
	}
	
	private void updateScore(Player winner) {
		winner.wonGame();
		if(winner.getGame()==6 && getOtherPlayer(winner).getGame()<=4) {
			winner.wonSet();
		}
		if(winner.getGame()==7) {
			winner.wonSet();
		}
		if(getOtherPlayer(winner).getGame()==7) {
			getOtherPlayer(winner).wonSet();
		}
		getOtherPlayer(winner).point=0;
		
		
	}

	private Player getOtherPlayer(Player p) {
		return p.getName().equals(playerOne.getName()) ? playerTwo: playerOne;
	}

	
	

	private boolean hasWinnerMatch() {
		if(isTieBreak) {
			if( playerOne.getTieBreakPoint() >= playerTwo.getTieBreakPoint()+2) {
				return true;
			}
			if( playerTwo.getTieBreakPoint() >= playerOne.getTieBreakPoint()+2) {
				return true;
			}
		}
		
		if(playerTwo.getSet()>= 2 && playerTwo.getSet() > playerOne.getSet()) {
			return true;
		}
		if(playerOne.getSet()>= 2 && playerOne.getSet() > playerTwo.getSet()) {
			return true;
		}
		return false;
	}

	private void displayScore(Player p) {
		StringBuffer buffer = playerOne.getDisplayScore();
		System.out.println(buffer.toString());
		StringBuffer buffer2 = playerTwo.getDisplayScore();
		System.out.println(buffer2.toString());
		
	}

	private Player playerWithHighestScore() {
		if(playerOne.getPoint()==playerTwo.getPoint()) {
			if(playerOne.getSet()==playerTwo.getSet()) {
				if (playerOne.getTieBreakPoint() > playerTwo.getTieBreakPoint()) {
					return playerOne;
				} else {
					return playerTwo;
				}
			}
			if (playerOne.getSet() > playerTwo.getSet()) {
				return playerOne;
			} else {
				return playerTwo;
			}
		}
		if (playerOne.getPoint() > playerTwo.getPoint()) {
			return playerOne;
		} else {
			return playerTwo;
		}
	}
	
	
	private boolean hasWinner() {
		if(playerTwo.getPoint() >= 4 && (playerOne.getPoint() <= 3 ||
				playerTwo.getPoint() >= playerOne.getPoint() + 2))
			return true;
		if(playerOne.getPoint() >= 4 && (playerTwo.getPoint() <= 3 ||
				playerOne.getPoint() >= playerTwo.getPoint() + 2))
			return true;
		return false;
	}
	
	
	private boolean hasAdvantage() {
		if (playerTwo.getPoint()>= 4 && playerTwo.getPoint() == playerOne.getPoint() + 1)
			return true;
		if (playerOne.getPoint() >= 4 && playerOne.getPoint() == playerTwo.getPoint() + 1)
			return true;
		
		return false;

	}

	public String getMessage() {
		return message;
	}
	
	
	private boolean isDeuce() {
		return playerOne.getPoint() >= 3 && playerTwo.getPoint() == playerOne.getPoint();
	}
	

	
}
