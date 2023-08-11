package com.skilldistillery.blackjack.entities;

public enum Suit {
	CLUBS("Clubs"),
	SPADES("Spades"),
	HEARTS("Hearts"),
	DIAMONDS("Diamonds");
	
	private Suit(String suit) {
		this.suit = suit;
	}
	
	final private String suit;

	@Override
	public String toString() {
		return suit;
	}
	
	public String getSuit() {
		return suit;
	}
	
}
