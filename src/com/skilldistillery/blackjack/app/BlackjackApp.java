package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.play();
	}
	public void play(){
		Scanner sc = new Scanner(System.in);
		Dealer dealer = new Dealer();
		Player player = new Player();
		System.out.println("Welcome to the SD underground ''BlackJack'' Table.");
		System.out.println("The Dealer will now shuffle the cards");
		dealer.shuffle();
		boolean keepPlaying = true;
		do {
			boolean cardCheck = true;
			player.hand.clear();
			dealer.hand.clear();
			boolean win = true;
			boolean winDealer = true;
			boolean playerChoice = true;
			dealer.enoughCards();
			dealer.beginGame(player, dealer);
			System.out.println();
			dealer.displayHiddenHand();
			player.displayCard(player.hand);
			System.out.println();
			

				
				while (playerChoice && cardCheck) {
					if (player.hand.isBlackjack()) {
						cardCheck = dealer.checkCard(player.hand);
						break;
					}
					playerChoice = player.hit(sc);
					win = cardCheck;
					if (playerChoice) {
						dealer.deal(player.hand);
						player.displayCard(player.hand);
						dealer.displayHiddenHand();
						cardCheck = dealer.checkCard(player.hand);
						win = cardCheck;
						
					}
					
				}
				if (win = true) {
			winDealer = dealer.dealerRule(player, dealer);
				}
			winCheck(win, winDealer, player, dealer);
			
			
			keepPlaying = playAgain(sc);
		}while(keepPlaying);
		sc.close();
	}
	

public boolean playAgain(Scanner sc) {
	System.out.println("Would you like to play again? 1-Yes or 2-No");
	String choice = sc.nextLine();
	choice.toLowerCase();
	switch (choice) {
	case "1":
	case "yes":
		return true;
	case "2":
	case "no":
		return false;
	default:
		System.out.println("That is not an option... Try again.");
		return playAgain(sc);
	}
	

	
	
}
public void winCheck (boolean win, boolean winDealer, Player player, Dealer dealer) {
	
	System.out.println();
	if (player.hand.isBust()){
		System.out.println("You lost );");
	}
	else if ( player.hand.getHandValue() < 22 && player.hand.getHandValue() > dealer.hand.getHandValue() || dealer.hand.getHandValue() > 21) {
		System.out.println("You Win!");
	}
	else if (player.hand.getHandValue() == dealer.hand.getHandValue()) {
		System.out.println("Its a Tie -_-");
	}
	else {
		System.out.println("You lose );");
	}
	System.out.println("Player: ");
	player.displayCard(player.hand);
	System.out.println("Dealer: ");
	player.displayCard(dealer.hand);
}
}