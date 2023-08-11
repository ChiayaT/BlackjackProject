package com.skilldistillery.enums.drills.cards;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class Dealing {
	public static void main(String[] args) {
		int numberOfCards;
		Deck deck = new Deck();
		Scanner sc = new Scanner(System.in);
		deck.shuffle();

		System.out.println("How many cards would you like");
		
		while (true) {
			try {
				numberOfCards = sc.nextInt();
				sc.nextLine();
				if (numberOfCards > deck.cardsLeftInDeck()) {
					System.err.println("There are not enough cards in the deck");
					System.err.println("Please enter a valid number");
					continue;
				}
				else {
					for (int i = 1; i <= numberOfCards; i++) {
						Card currentCard = deck.dealCard();
						System.out.print(currentCard + ": ");
						System.out.println(currentCard.getValue());
					}
					System.out.println(deck.cardsLeftInDeck());
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Please enter a valid number");
				continue;

			}
		}
		sc.close();
	}
}
