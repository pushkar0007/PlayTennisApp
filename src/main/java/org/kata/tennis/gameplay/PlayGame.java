package org.kata.tennis.gameplay;

import org.kata.tennis.constants.CommonConstants;
import org.kata.tennis.model.Player;
import org.kata.tennis.scoreboard.MatchScoreInformation;
import org.kata.tennis.scoreboard.MatchScoreInformationImpl;

public class PlayGame implements CommonConstants {
    private Player player1;
    private Player player2;

    private Integer gameScorePlayer1;
    private Integer gameScorePlayer2;

    private String gameScoreTextPlayer1;
    private String gameScoreTextPlayer2;

    private Player winner;

    public PlayGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        gameScorePlayer1 = 0;
        gameScorePlayer2 = 0;
        gameScoreTextPlayer1 = "";
        gameScoreTextPlayer2 = "";
        winner = null;
    }

    public void incrementGameScorePlayer(Player player, MatchScoreInformation matchScoreInformation) {
        boolean player1Scoring = player.equals(player1);
        boolean player2Scoring = player.equals(player2);

        // Game Score with {X<40} is ( X - 40 ) or ( 40 - X ) leading to score above 40
        // => designate a winner
        if ((gameScorePlayer1.equals(FORTY_SCORE) && gameScorePlayer2 < FORTY_SCORE && player1Scoring)
                || (gameScorePlayer2.equals(FORTY_SCORE) && gameScorePlayer1 < FORTY_SCORE && player2Scoring)) {

            designateWinner(player, matchScoreInformation);
            // Game Score is ( 40 - 40 ) or above => activate deuce rule
        }else if (gameScorePlayer1 >= FORTY_SCORE && gameScorePlayer2 >= FORTY_SCORE) {
            activateDeuceRule(player, matchScoreInformation);
            // All other cases => increment scores
        }
        else {
            incrementGameScore(player, matchScoreInformation);
        }
    }

    private void activateDeuceRule(Player player, MatchScoreInformation matchScoreInformation) {
        boolean player1Scoring = player.equals(player1);
        boolean player2Scoring = player.equals(player2);

        // Game Score is ( 40 - 40 ) => increment score to ADV
        if (gameScorePlayer1.equals(FORTY_SCORE) && gameScorePlayer2.equals(FORTY_SCORE)) {

            incrementGameScore(player, matchScoreInformation);

            // Game Score is ( ADV - 40 ) or ( 40 - ADV ) leading to score above ADV =>
            // designate a winner
        } else if ((gameScorePlayer1.equals(ADVANTAGE_SCORE) && gameScorePlayer2.equals(FORTY_SCORE) && player1Scoring)
                || (gameScorePlayer2.equals(ADVANTAGE_SCORE) && gameScorePlayer1.equals(FORTY_SCORE)
                && player2Scoring)) {

            designateWinner(player, matchScoreInformation);

            // Game Score is ( ADV - 40 ) or ( 40 - ADV ) leading to score ( ADV - ADV ) =>
            // increment scores & activate deuce rule
        } else if ((gameScorePlayer1.equals(FORTY_SCORE) && gameScorePlayer2.equals(ADVANTAGE_SCORE) && player1Scoring)
                || (gameScorePlayer2.equals(FORTY_SCORE) && gameScorePlayer1.equals(ADVANTAGE_SCORE)
                && player2Scoring)) {

            incrementGameScore(player, matchScoreInformation);
            resetScoresDeuceRule(matchScoreInformation);
        }
    }

    private void resetScoresDeuceRule(MatchScoreInformation matchScoreInformation) {
        matchScoreInformation.announceDeuceRule();
        this.gameScorePlayer1 = FORTY_SCORE;
        this.gameScorePlayer2 = FORTY_SCORE;
    }

    private void designateWinner(Player player, MatchScoreInformation matchScoreInformation) {
        if (player1.equals(player)) {
            matchScoreInformation.showGamePoint(player1);
            winner = player1;
        } else {
            matchScoreInformation.showGamePoint(player2);
            winner = player2;
        }
        resetGameScores();
    }

    private void resetGameScores() {
        this.gameScorePlayer1=0;
        this.gameScorePlayer2=0;
    }

    private Integer incrementGameScore(Player player, MatchScoreInformation matchScoreInformation) {
        matchScoreInformation.showGamePoint(player);

        if (player1.equals(player)) {
            return gameScorePlayer1++;
        } else {
            return gameScorePlayer2++;
        }
    }

    public void displayGameScore(MatchScoreInformation matchScoreInformation) {
        if (winner == null) {
            matchScoreInformation.showGameScore(getScoreDescription(gameScorePlayer1),
                    getScoreDescription(gameScorePlayer2));
        } else {
            announceWinner(matchScoreInformation);
        }
    }

    private String getScoreDescription(Integer gameScore) {
        return pointsList.get(gameScore);
    }
    private void announceWinner(MatchScoreInformation matchScoreInformation) {
        matchScoreInformation.showGameWinner(winner);
    }

    public Player getWinner() {
        return winner;
    }
}
