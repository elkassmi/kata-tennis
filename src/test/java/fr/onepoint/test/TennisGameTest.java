package fr.onepoint.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.onepoint.TennisGameManager;

public class TennisGameTest {
	
	TennisGameManager game ;
	
	@Test
	public void testPlayersAreDuce() {
		createScorePlayerTwo(4);
		createScorePlayerOne(4);
		game.checKScore();
		assertEquals("Deuce", game.getMessage());
	}
	
	@Test
	public void testAdvPlayerOne() {
		createScorePlayerOne(4);
		createScorePlayerTwo(4);
		createScorePlayerOne(1);
		game.checKScore();
		assertEquals("Advantage Rafael Nadal", game.getMessage());
	}
	
	@Test
	public void testAdvPlayerTwo() {
		createScorePlayerOne(4);
		createScorePlayerTwo(5);
		game.checKScore();
		assertEquals("Advantage Novac Djokovic", game.getMessage() );
	}
		
	@Test
	public void testPlayerOneWin() {
		createScorePlayerTwo(3);
		createScorePlayerOne(4);
		game.checKScore();
		assertEquals("Rafael Nadal wins", game.getMessage());
		
	}
	
	@Test
	public void testPlayerTwoWin() {
		createScorePlayerOne(3);
		createScorePlayerTwo(4);
		game.checKScore();
		assertEquals("Novac Djokovic wins", game.getMessage());
	}
	
	@Test
	public void testPlayerOneWinAfterDouce() {
		createScorePlayerOne(2);
		createScorePlayerTwo(1);
		createScorePlayerOne(2);
		createScorePlayerTwo(4);
		game.checKScore();
		assertEquals("Advantage Novac Djokovic", game.getMessage());
		
		createScorePlayerOne(1);
		game.checKScore();
		assertEquals("Deuce", game.getMessage());
		
		createScorePlayerOne(1);
		game.checKScore();
		assertEquals("Advantage Rafael Nadal", game.getMessage());
		
		createScorePlayerOne(1);
		game.checKScore();
		assertEquals("Rafael Nadal wins", game.getMessage());
	}
	
	@Test
	public void testPlayerOneWinMatchWithSet() {
		for(int i=0;i<12;i++) {
			createScorePlayerTwo(3);
			createScorePlayerOne(4);
			game.checKScore();
		}
		String win = game.getSet();
		assertEquals("Rafael Nadal win match", win);
	}
	
	@Test
	public void testPlayerTwoWinMatchWithSet() {
		for(int i=0;i<12;i++) {
			createScorePlayerOne(3);
			createScorePlayerTwo(4);
			game.checKScore();
			
		}
		String win = game.getSet();
		assertEquals("Novac Djokovic win match", win);
	}

	@Test
	public void testTieBreak() {
		for(int i=0;i<6;i++) {
			createScorePlayerOne(3);
			createScorePlayerTwo(4);
			game.checKScore();
		}
		
		for(int i=0;i<6;i++) {
			createScorePlayerTwo(3);
			createScorePlayerOne(4);
			game.checKScore();
		}
		String win = game.getSet();
		assertEquals("Tie-Break", win);
	}
	
	@Test
	public void testPlayerTwoWinAfterTieBreak() {
		for(int i=0;i<6;i++) {
			createScorePlayerOne(3);
			createScorePlayerTwo(4);
			game.checKScore();
		}
		
		for(int i=0;i<6;i++) {
			createScorePlayerTwo(3);
			createScorePlayerOne(4);
			game.checKScore();
		}
		String tieBreak = game.getSet();
		assertEquals("Tie-Break", tieBreak);
		
		createScorePlayerOne(2);
		String win = game.getSet();
		
		assertEquals("Rafael Nadal win match", win);		
	}
	
	
	@Test
	public void testPlayerTwoWinAfterTieBreak2() {
		for(int i=0;i<6;i++) {
			createScorePlayerOne(3);
			createScorePlayerTwo(4);
			game.checKScore();
		}
		
		for(int i=0;i<6;i++) {
			createScorePlayerTwo(3);
			createScorePlayerOne(4);
			game.checKScore();
		}
		String tieBreak = game.getSet();
		assertEquals("Tie-Break", tieBreak);
		
		createScorePlayerOne(1);
		assertEquals("Tie-Break", game.getSet());
		
		createScorePlayerTwo(1);
		assertEquals("Tie-Break", game.getSet());
		
		createScorePlayerOne(2);
		
		assertEquals("Rafael Nadal win match", game.getSet());
		
	}
	
	@Before
	public void startGame() {
		game = new TennisGameManager("Rafael Nadal" , "Novac Djokovic");
		
	}
	
	private void createScorePlayerOne(int balls) {
		for (int i = 0; i < balls; i++) {
			game.playerOneWonPoint();
		}
	}
	private void createScorePlayerTwo(int balls) {
		for (int i = 0; i < balls; i++) {
			game.playerTwoWonPoint();
		}
	}
	
 
}
