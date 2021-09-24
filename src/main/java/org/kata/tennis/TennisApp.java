package org.kata.tennis;

import org.kata.tennis.gameplay.PlayGame;
import org.kata.tennis.model.Player;
import org.kata.tennis.scoreboard.MatchScoreInformationImpl;

import java.util.Scanner;
/**
 * @author pushkar
 * Main App to start the Game
 * */
public class TennisApp {
    public static void main(String[] args) {
        MatchScoreInformationImpl displayScoresImplSystemOut = new MatchScoreInformationImpl();
        displayScoresImplSystemOut.showOpeningBanner();
        System.out.println("Welcome to Tennis App");
        Scanner scannerInPlayer1 = new Scanner(System.in);
        System.out.print("Please enter a username for player1: ");
        String player1Username = scannerInPlayer1.nextLine();
        Player player1 = new Player(player1Username);

        // Player2 Instantiation
        Scanner scannerInPlayer2 = new Scanner(System.in);
        System.out.print("Please enter a username for player2: ");
        String player2Username = scannerInPlayer2.nextLine();
        Player player2 = new Player(player2Username);

        PlayGame game = new PlayGame(player1,player2);
        game.play(displayScoresImplSystemOut);
        displayScoresImplSystemOut.showClosingBanner();

    }
}
