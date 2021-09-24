package org.kata.tennis.gameplay;

import org.kata.tennis.constants.CommonConstants;
import org.kata.tennis.model.Player;
import org.kata.tennis.scoreboard.MatchScoreInformation;
/**
 * @author pushkar
 * Abstract Game class
 * */
public class AbstractGame implements CommonConstants {
    protected Player player1;
    protected Player player2;

    protected Integer gameScorePlayer1;
    protected Integer gameScorePlayer2;

    protected String gameScoreTextPlayer1;
    protected String gameScoreTextPlayer2;

    protected Player winner;

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Integer getGameScorePlayer1() {
        return gameScorePlayer1;
    }

    public void setGameScorePlayer1(Integer gameScorePlayer1) {
        this.gameScorePlayer1 = gameScorePlayer1;
    }

    public Integer getGameScorePlayer2() {
        return gameScorePlayer2;
    }

    public void setGameScorePlayer2(Integer gameScorePlayer2) {
        this.gameScorePlayer2 = gameScorePlayer2;
    }

    public String getGameScoreTextPlayer1() {
        return gameScoreTextPlayer1;
    }

    public void setGameScoreTextPlayer1(String gameScoreTextPlayer1) {
        this.gameScoreTextPlayer1 = gameScoreTextPlayer1;
    }

    public String getGameScoreTextPlayer2() {
        return gameScoreTextPlayer2;
    }

    public void setGameScoreTextPlayer2(String gameScoreTextPlayer2) {
        this.gameScoreTextPlayer2 = gameScoreTextPlayer2;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    protected String getScoreDescription(Integer gameScore) {
        return pointsList.get(gameScore);
    }
    protected void announceWinner(MatchScoreInformation matchScoreInformation) {
        matchScoreInformation.showGameWinner(winner);
    }

    public Player getWinner() {
        return winner;
    }


}
