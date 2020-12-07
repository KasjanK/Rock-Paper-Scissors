package rps;

import java.util.Scanner;

public class rps {
	// checks if the input is a string, and if it is, assigns the string to the corresponding choice
	static int string(String s) { 
		int stringChoice = 0;
		try {
			stringChoice = Integer.parseInt(s);

		} catch (NumberFormatException e) { 
			switch (s) {
			case "rock":
				stringChoice = 1;
				break;
			case "paper":
				stringChoice = 2;
				break;
			case "scissor":
				stringChoice = 3;
				break;
			default:
				System.out.println("Error, invalid player input. Please enter 1, 2, 3 or rock, paper or scissors.");
				stringChoice = 0;
			}
		}
		
		// player input must be between 1 and 3
		if (stringChoice < 1 || stringChoice > 3) { 
			System.out.println("Error, invalid player input. Please enter 1, 2, 3 or rock, paper or scissors.");
			stringChoice = 0;
		}

		return stringChoice;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int round = 1; 
		
		int player1 = 0;
		int player1Score = 0;
		int player2 = 0;
		int player2Score = 0;
		
		int rock = 1;
		int paper = 2;
		int scissors = 3;
		
		System.out.println("Welcome to rock, paper, scissors! Let's begin.");
		
		while (round <= 3) {
			System.out.println("Round: " + round);
			System.out.println("Player 1, choose!");
			String player1input = scanner.nextLine();
			
			// checks if the player input is a string
			player1 = string(player1input); 
			
			System.out.println("Player 2, choose!");
			String player2input = scanner.nextLine();
			
			// checks if the player input is a string
			player2 = string(player2input); 
			
			// rock paper scissors rules
			if ((player1 == rock && player2 == scissors) || (player1 == paper && player2 == rock) || (player1 == scissors && player2 == paper)) {
				System.out.println("Player 1 wins!");
				player1Score++;
			} else if ((player1 == rock && player2 == paper) || (player1 == paper && player2 == scissors) || (player1 == scissors && player2 == rock)) {
				System.out.println("Player 2 wins!");
				player2Score++;
			} else if (player1 == player2) {
				System.out.println("It's a tie!");
			}
			round++;
		}
		
		// endgame
		System.out.println("The game is now over and the score was:");
		System.out.println("Player 1: " + player1Score);
		System.out.println("Player 2: " + player2Score);
	}

}
