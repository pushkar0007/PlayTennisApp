package org.kata.tennis;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.kata.tennis.gameplay.PlayGame;
import org.kata.tennis.model.Player;
import org.kata.tennis.scoreboard.MatchScoreInformationImpl;

import java.util.ArrayList;
import java.util.List;

public class PlayGameTest extends TestMain {

    @Test
    public void testWhenPlayer1WinsWith40Points() { // Sought game result ( 40 - 0 )

        MatchScoreInformationImpl displayScoresImplSystemOut = new MatchScoreInformationImpl();

        PlayGame game = new PlayGame(player1, player2);

        List<Player> testQuickestGameWinP1 = new ArrayList<>();
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
}
