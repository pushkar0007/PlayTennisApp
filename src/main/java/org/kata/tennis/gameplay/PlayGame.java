package org.kata.tennis.gameplay;

import org.kata.tennis.model.Player;

public class PlayGame {
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
}
