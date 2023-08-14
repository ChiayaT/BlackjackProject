package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;

public class BlackjackHand extends Hand {
	private int total = 0;
	public BlackjackHand() {
		numberOfCards = new ArrayList<>();
	}

	@Override
	public
	int getHandValue() {
		total = 0;
		for (Card card : numberOfCards) {
			total += card.getValue();
		}
		return total;
	}
	
	public boolean isBlackjack() {
		total = 0;
		for (Card card : numberOfCards) {
			total += card.getValue();
		}
		return (total == 21);
	}
	
	public boolean isBust() {
		total = 0;
		for (Card card : numberOfCards) {
			total += card.getValue();
		}
		return (total > 21);
	}
	
	

}
