package org.kata.tennis.scoreboard;

import org.kata.tennis.model.Player;

public interface MatchScoreInformation {
	void showOpeningBanner();
	void showClosingBanner();
	void showGamePoint(Player player);
	void showGameScore(String gameScorePlayer1, String gameScorePlayer2);
	void showGameWinner(Player player);
	void showMatchScore(Integer matchScorePlayer1, Integer matchScorePlayer2);
	void showMatchWinner(Player player);
	void announceDeuceRule();

}