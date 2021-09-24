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

    List<Player> testQuickestGameWinP1 ;
    @Before
    public void setup(){
        displayScoresImplSystemOut = new MatchScoreInformationImpl();
        game = new PlayGame(player1, player2);
        testQuickestGameWinP1 = new ArrayList<>();
    }

    @Test
    public void testWhenPlayer1WinsWith40Points() { 
        // Sought game result ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player1); // ( 30 - 0 )
        testQuickestGameWinP1.add(player1); // ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // => Win

        for (Player player : testQuickestGameWinP1) {
            game.incrementGameScorePlayer(player, displayScoresImplSystemOut);
            game.displayGameScore(displayScoresImplSystemOut);
        }

        // Ensure Player1 wins the game
        assertEquals(player1, game.getWinner());
    }

    @Test
    public void testWhenPlayer2WinsWith40Points() {
        testQuickestGameWinP1.add(player2); // ( 15 - 0 )
        testQuickestGameWinP1.add(player2); // ( 30 - 0 )
        testQuickestGameWinP1.add(player2); // ( 40 - 0 )
        testQuickestGameWinP1.add(player2); // => Win

        for (Player player : testQuickestGameWinP1) {
            game.incrementGameScorePlayer(player, displayScoresImplSystemOut);
            game.displayGameScore(displayScoresImplSystemOut);
        }

        // Ensure Player1 wins the game
        assertEquals(player2, game.getWinner());
    }

    @Test
    public void testHighestScorePlayerWins() { // Sought game result ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player1); // ( 30 - 0 )
        testQuickestGameWinP1.add(player2); // ( 15 - 0 )
        testQuickestGameWinP1.add(player2); // ( 30 - 0 )
        testQuickestGameWinP1.add(player2); // ( 40 - 0 )
        testQuickestGameWinP1.add(player2); // => Win
        for (Player player : testQuickestGameWinP1) {
            game.incrementGameScorePlayer(player, displayScoresImplSystemOut);
            game.displayGameScore(displayScoresImplSystemOut);
        }

        // Ensure Player1 wins the game
        assertEquals(player2, game.getWinner());
    }
    @Test
    public void testDueceAndAdvPlayerWins() { // Sought game result ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player2); // ( 15 - 15 )
        testQuickestGameWinP1.add(player1); // ( 30 - 15 )
        testQuickestGameWinP1.add(player2); // ( 30 - 30 )
        testQuickestGameWinP1.add(player1); // ( 40 - 30 )
        testQuickestGameWinP1.add(player2); // ( 40 - 40 )
        testQuickestGameWinP1.add(player1); // ( ADV - 40 )
        testQuickestGameWinP1.add(player1); // => Player1 Wins
        for (Player player : testQuickestGameWinP1) {
            game.incrementGameScorePlayer(player, displayScoresImplSystemOut);
            game.displayGameScore(displayScoresImplSystemOut);
        }

        // Ensure Player1 wins the game
        assertEquals(player1, game.getWinner());
    }
}
