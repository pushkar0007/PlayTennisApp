package org.kata.tennis;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.kata.tennis.gameplay.PlayGame;
import org.kata.tennis.model.Player;
import org.kata.tennis.scoreboard.MatchScoreInformationImpl;

import java.util.ArrayList;
import java.util.List;

public class PlayGameTest extends TestMain {
    MatchScoreInformationImpl displayScoresImplSystemOut ;

    PlayGame game ;

    List<Player> listOfTurns ;
    @Before
    public void setup(){
        displayScoresImplSystemOut = new MatchScoreInformationImpl();
        game = new PlayGame(player1, player2);
        listOfTurns = new ArrayList<>();
    }

    @Test
    public void testWhenPlayer1WinsWith40Points() { 
        // Sought game result ( 40 - 0 )
        listOfTurns.add(player1); // ( 15 - 0 )
        listOfTurns.add(player1); // ( 30 - 0 )
        listOfTurns.add(player1); // ( 40 - 0 )
        listOfTurns.add(player1); // => Win
        playGame();
        // Ensure Player1 wins the game
        assertEquals(player1, game.getWinner());
    }

    @Test
    public void testWhenPlayer2WinsWith40Points() {
        listOfTurns.add(player2); // ( 15 - 0 )
        listOfTurns.add(player2); // ( 30 - 0 )
        listOfTurns.add(player2); // ( 40 - 0 )
        listOfTurns.add(player2); // => Win
        playGame();
        // Ensure Player2 wins the game
        assertEquals(player2, game.getWinner());
    }

    @Test
    public void testHighestScorePlayerWins() { // Sought game result ( 40 - 0 )
        listOfTurns.add(player1); // ( 15 - 0 )
        listOfTurns.add(player1); // ( 30 - 0 )
        listOfTurns.add(player2); // ( 15 - 0 )
        listOfTurns.add(player2); // ( 30 - 0 )
        listOfTurns.add(player2); // ( 40 - 0 )
        listOfTurns.add(player2); // => Win
        playGame();
        // Ensure Player2 wins the game
        assertEquals(player2, game.getWinner());
    }

    private void playGame() {
        for (Player player : listOfTurns) {
            game.incrementGameScorePlayer(player, displayScoresImplSystemOut);
            game.displayGameScore(displayScoresImplSystemOut);
        }
    }

    @Test
    public void testDueceAndAdvPlayerWins() { // Sought game result ( 40 - 0 )
        listOfTurns.add(player1); // ( 15 - 0 )
        listOfTurns.add(player2); // ( 15 - 15 )
        listOfTurns.add(player1); // ( 30 - 15 )
        listOfTurns.add(player2); // ( 30 - 30 )
        listOfTurns.add(player1); // ( 40 - 30 )
        listOfTurns.add(player2); // ( 40 - 40 )
        listOfTurns.add(player1); // ( ADV - 40 )
        listOfTurns.add(player1); // => Player1 Wins
        playGame();
        // Ensure Player1 wins the game
        assertEquals(player1, game.getWinner());
    }

    @Test
    public void testDoubleDueceAndAdvPlayerWins() { // Sought game result ( 40 - 0 )
        listOfTurns.add(player1); // ( 15 - 0 )
        listOfTurns.add(player2); // ( 15 - 15 )
        listOfTurns.add(player1); // ( 30 - 15 )
        listOfTurns.add(player2); // ( 30 - 30 )
        listOfTurns.add(player1); // ( 40 - 30 )
        listOfTurns.add(player2); // ( 40 - 40 )
        listOfTurns.add(player2); // ( 40 - ADV )
        listOfTurns.add(player1); // ( 40 - 40 )
        listOfTurns.add(player2); // ( 40 - ADV )
        listOfTurns.add(player1); // ( 40 - 40 )
        listOfTurns.add(player2); // ( 40 - ADV )
        listOfTurns.add(player2); // => Player2 Wins
        playGame();
        // Ensure Player2 wins the game
        assertEquals(player2, game.getWinner());
    }
}
