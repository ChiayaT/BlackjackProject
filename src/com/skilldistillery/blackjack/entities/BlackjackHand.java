package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;

public class BlackjackHand extends Hand {
	private int total = 0;
	public BlackjackHand() {
		numberOfCards = new ArrayList<>();
	}

	@Override
	int getHandValue() {
		for (Card card : numberOfCards) {
			total += card.getValue();
		}
		return total;
	}
	
	public boolean isBlackjack() {
		return (total == 21);
	}
	
	public boolean isBust() {
		return (total > 21);
	}
	
	

}
