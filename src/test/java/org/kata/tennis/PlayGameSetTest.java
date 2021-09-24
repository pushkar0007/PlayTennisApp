package org.kata.tennis;

import org.junit.Before;
import org.junit.Test;
import org.kata.tennis.gameplay.PlayGame;
import org.kata.tennis.gameplay.PlayGameSets;
import org.kata.tennis.model.Player;
import org.kata.tennis.scoreboard.MatchScoreInformationImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayGameSetTest extends TestMain{
    MatchScoreInformationImpl displayScoresImplSystemOut ;

    PlayGameSets set ;

    List<Player> listOfTurns ;
    @Before
    public void setup(){
        displayScoresImplSystemOut = new MatchScoreInformationImpl();
        set = new PlayGameSets(player1, player2);
        listOfTurns = new ArrayList<>();
    }

    @Test
    public void testQuickestSetWithPlayer1Win(){
        listOfTurns.add(player1); // ( 15 - 0 )
        listOfTurns.add(player1); // ( 30 - 0 )
        listOfTurns.add(player1); // ( 40 - 0 )
        listOfTurns.add(player1); // => Win

        while (set.getWinner() == null) {
            set.setCurrentGame(new PlayGame(player1, player2));
            for (Player player : listOfTurns) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
                set.getCurrentGame().displayGameScore(displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
        }

        // Ensure Player1 wins the set
        assertEquals(player1, set.getWinner());
    }

    @Test
    public void testQuickestSetWithPlayer2Win(){
        listOfTurns.add(player2); // ( 15 - 0 )
        listOfTurns.add(player2); // ( 30 - 0 )
        listOfTurns.add(player2); // ( 40 - 0 )
        listOfTurns.add(player2); // => Win

        while (set.getWinner() == null) {
            set.setCurrentGame(new PlayGame(player1, player2));
            for (Player player : listOfTurns) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
                set.getCurrentGame().displayGameScore(displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
        }

        // Ensure Player2 wins the set
        assertEquals(player2, set.getWinner());
    }
}
