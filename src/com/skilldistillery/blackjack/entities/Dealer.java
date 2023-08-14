package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {
	protected Deck deck;
	public ArrayList<String> hiddenHand;

	public Dealer() {
		hand = new BlackjackHand();
		this.deck = new Deck();

	}

	public void beginGame(Player player, Dealer dealer) {


		System.out.println("The Dealer will now deal the cards");
		dealer.hand.addCard(deck.dealCard());
		player.hand.addCard(deck.dealCard());
		dealer.hand.addCard(deck.dealCard());
		player.hand.addCard(deck.dealCard());
		hiddenHand = new ArrayList<>();
		hiddenHand.add("Hidden");
		hiddenHand.add(dealer.hand.numberOfCards.get(1).toString());
	}

	public void deal(Hand hand) {
		hand.addCard(deck.dealCard());
	}

	public String hiddenHandtoString() {
		String hand = "";
		for (String string : hiddenHand) {
			if (string == hiddenHand.get(hiddenHand.size() - 1)) {
				hand += string.toString();
				return hand;
			}
			hand += string.toString() + ", ";
		}
		return "";
	}

	public boolean dealerRule(Player user , Dealer dealer) {
		System.out.println("It is now time for the dealer to draw...");
		while (hand.getHandValue() < 17) {
			hand.addCard(deck.dealCard());
			System.out.println();
			System.out.println("Dealer Hand:");
			System.out.println(dealer.hand);
			System.out.println(dealer.hand.getHandValue());
			System.out.println("~");
			System.out.println("User Hand:");
			System.out.println(user.hand);
			System.out.println(user.hand.getHandValue());
			System.out.println();
			if (this.hand.isBust()) {
				return false;
			}
		}
		return true;
	}

	public Deck enoughCards() {
		if (deck.size() < 15) {
			System.out.println("The cards are running low, the dealer is getting a new deck.");
			deck = new Deck();
		}
		return deck;
	}

	public boolean checkCard(BlackjackHand player) {
		if (player.isBust()) {
			return false;
		} else if (player.isBlackjack()) {
			return false;
		}
		return true;
	}

	public void displayHiddenHand() {
		System.out.println("Dealer Hand: " + hiddenHand);
		System.out.println("Dealer Hand Value: Unknown");
	}
	public void shuffle() {
		deck.shuffle();
	}
}
