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
/**
 * @author pushkar
 * PlayGameSetTest class is to test functionality of PlayGameSets
 * */
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

    @Test
    public void testQuickestSetWinPlayer1(){
        List<Player> testQuickestGameWinP1 = new ArrayList<>();
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player1); // ( 30 - 0 )
        testQuickestGameWinP1.add(player1); // ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // => Win

        List<Player> testQuickestGameWinP2 = new ArrayList<>();
        testQuickestGameWinP2.add(player2); // ( 0 - 15 )
        testQuickestGameWinP2.add(player2); // ( 0 - 30 )
        testQuickestGameWinP2.add(player2); // ( 0 - 40 )
        testQuickestGameWinP2.add(player2); // => Win

        Integer setIndex = 0;
        while (set.getWinner() == null) {
            set.setCurrentGame(new PlayGame(player1, player2));
            for (Player player : testQuickestGameWinP1) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
                set.getCurrentGame().displayGameScore(displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            // We stop incrementing set scores when player2 reaches score 5
            if (setIndex < 5) {
                set.setCurrentGame(new PlayGame(player1, player2));
                for (Player player : testQuickestGameWinP2) {
                    set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
                    set.getCurrentGame().displayGameScore(displayScoresImplSystemOut);
                }
                set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            }
            setIndex++;
            set.displaySetScore(displayScoresImplSystemOut);
        }

        // Ensure Player1 wins the set
        assertEquals(player1, set.getWinner());
    }

    @Test
    public void testQuickestSetWinPlayer1WithTieBreak(){
        List<Player> testQuickestGameWinP1 = new ArrayList<>();
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player1); // ( 30 - 0 )
        testQuickestGameWinP1.add(player1); // ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // => Win

        List<Player> testQuickestGameWinP2 = new ArrayList<>();
        testQuickestGameWinP2.add(player2); // ( 0 - 15 )
        testQuickestGameWinP2.add(player2); // ( 0 - 30 )
        testQuickestGameWinP2.add(player2); // ( 0 - 40 )
        testQuickestGameWinP2.add(player2); // => Win

        List<Player> testTieBreakP1 = new ArrayList<>();
        testTieBreakP1.add(player1); // ( 1 - 0 )
        testTieBreakP1.add(player1); // ( 2 - 0 )
        testTieBreakP1.add(player1); // ( 3 - 0 )
        testTieBreakP1.add(player1); // ( 4 - 0 )
        testTieBreakP1.add(player1); // ( 5 - 0 )
        testTieBreakP1.add(player1); // ( 6 - 0 )
        testTieBreakP1.add(player1); // ( 7 - 0 ) => Win

        Integer setIndex = 0;
        // We stop incrementing set scores when scores reach score ( 6 - 6)
        while (set.getWinner() == null && setIndex < 6) {
            set.setCurrentGame(new PlayGame(player1, player2));
            for (Player player : testQuickestGameWinP1) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            set.setCurrentGame(new PlayGame(player1, player2));
            for (Player player : testQuickestGameWinP2) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            setIndex++;
        }

        // Play Tie Break game
        for (Player player : testTieBreakP1) {
            set.incrementSetScorePlayer(player);
        }

        // Ensure Player 1 wins the set
        assertEquals(player1, set.getWinner());
    }

    @Test
    public void testQuickestSetWinPlayer1WithTieBreakAndExtended(){
        List<Player> testQuickestGameWinP1 = new ArrayList<>();
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player1); // ( 30 - 0 )
        testQuickestGameWinP1.add(player1); // ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // => Win

        List<Player> testQuickestGameWinP2 = new ArrayList<>();
        testQuickestGameWinP2.add(player2); // ( 0 - 15 )
        testQuickestGameWinP2.add(player2); // ( 0 - 30 )
        testQuickestGameWinP2.add(player2); // ( 0 - 40 )
        testQuickestGameWinP2.add(player2); // => Win

        List<Player> testTieBreakP1 = new ArrayList<>();
        testTieBreakP1.add(player1); // ( 1 - 0 )
        testTieBreakP1.add(player2); // ( 1 - 1 )
        testTieBreakP1.add(player1); // ( 2 - 1 )
        testTieBreakP1.add(player2); // ( 2 - 2 )
        testTieBreakP1.add(player1); // ( 3 - 2 )
        testTieBreakP1.add(player2); // ( 3 - 3 )
        testTieBreakP1.add(player1); // ( 4 - 3 )
        testTieBreakP1.add(player2); // ( 4 - 4 )
        testTieBreakP1.add(player1); // ( 5 - 4 )
        testTieBreakP1.add(player2); // ( 5 - 5 )
        testTieBreakP1.add(player1); // ( 6 - 5 )
        testTieBreakP1.add(player2); // ( 6 - 6 )
        testTieBreakP1.add(player1); // ( 7 - 6 )
        testTieBreakP1.add(player2); // ( 7 - 7 )
        testTieBreakP1.add(player1); // ( 8 - 7 )
        testTieBreakP1.add(player1); // ( 9 - 7 ) => Win

        Integer setIndex = 0;
        // We stop incrementing set scores when scores reach score ( 6 - 6)
        while (set.getWinner() == null && setIndex < 6) {
            set.setCurrentGame(new PlayGame(player1, player2));
            for (Player player : testQuickestGameWinP1) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            set.setCurrentGame(new PlayGame(player1, player2));
            for (Player player : testQuickestGameWinP2) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            setIndex++;
        }

        // Play Tie Break game
        for (Player player : testTieBreakP1) {
            set.incrementSetScorePlayer(player);
        }

        // Ensure Player1 wins the set
        assertEquals(player1, set.getWinner());
    }
}
