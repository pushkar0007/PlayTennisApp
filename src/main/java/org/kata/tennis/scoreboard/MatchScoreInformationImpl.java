package org.kata.tennis.scoreboard;

import org.kata.tennis.model.Player;

public class MatchScoreInformationImpl implements MatchScoreInformation{
    @Override
    public void showGamePoint(Player player) {
        System.out.println(player.getUsername() + " has won 1 point!");
    }

    @Override
    public void showGameScore(String gameScorePlayer1, String gameScorePlayer2) {
        System.out.println("Current Game Score is: ( " + gameScorePlayer1 + " - " + gameScorePlayer2 + " )");
    }



    @Override
    public void showGameWinner(Player player) {
        System.out.println("\n\nThe winner of the game is : " + player.getUsername());
    }



    @Override
    public void showMatchScore(Integer matchScorePlayer1, Integer matchScorePlayer2) {
        System.out.println("\n\nMatch Score is: ( " + matchScorePlayer1 + " - " + matchScorePlayer2 + " )\n\n");
    }

    @Override
    public void showMatchWinner(Player player) {
        System.out.println("The winner of the Match is : " + player.getUsername());
    }

    @Override
    public void showOpeningBanner() {
        System.out.println("Game started");
    }

    @Override
    public void showClosingBanner() {
        System.out.println("Game end");
    }

    @Override
    public void announceDeuceRule() {
        System.out.println("Deuce Rule applied!");
    }
    @Override
    public void showSetScore(Integer setScorePlayer1, Integer setScorePlayer2) {
        System.out.println("Current Tie Break Score is: ( " + setScorePlayer1 + " - " + setScorePlayer2 + " )\n\n");
    }

    @Override
    public void showTieBreakScore(Integer tieBreakScorePlayer1, Integer tieBreakScorePlayer2) {
        System.out.println("Current Tie Break Score is: ( " + tieBreakScorePlayer1 + " - " + tieBreakScorePlayer2 + " )\n\n");
    }

    @Override
    public void showSetWinner(Player player) {
        System.out.println("The winner of the Set is : " + player.getUsername() + "\n\n");
    }
}
