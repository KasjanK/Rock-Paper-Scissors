package rps;

import java.util.Scanner;
import java.util.Random;

public class rpsAI {
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
			case "scissors":
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
		
		int player = 0;
		int playerScore = 0;
		int comp = 0;
		int compScore = 0;
		
		int rock = 1;
		int paper = 2;
		int scissors = 3;
		
		
		while (round <=3) {
			System.out.println("Round: " + round);
			System.out.println("Player, choose!");
			String playerInput = scanner.nextLine();
			
			// checks if the player input is a string
			player = string(playerInput);
		
			// random computer choice
			Random computer = new Random();
			int compNum = computer.nextInt(3) + 1;
			
			// rock paper scissors rules
			if ((player == rock && compNum == scissors) || (player == paper && compNum == rock) || (player == scissors && compNum == paper)) {
				
				System.out.println("Player wins!");
				playerScore++;
			} else if ((player == rock && compNum == paper) || (player == paper && compNum == scissors) || (player == scissors && compNum == rock)) {
				System.out.println("Computer wins!");
				compScore++;
			} else if (player == compNum) {
				System.out.println("It's a tie!");
			}
			round++;
		}
		
		// endgame
		System.out.println("The game is now over and the score was:");
		System.out.println("Player 1: " + playerScore);
		System.out.println("Computer: " + compScore);
	}
}
