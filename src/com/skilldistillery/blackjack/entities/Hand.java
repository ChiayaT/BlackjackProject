package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	protected ArrayList<Card> numberOfCards;
	
	Hand(){
		
	}
	
	void addCard(Card card) {
		numberOfCards.add(card);
	}
	
	public void clear() {
		numberOfCards.removeAll(numberOfCards);
	}
	
	abstract int getHandValue();
	
	public String toString() {
		String hand = "";
		for (Card card : numberOfCards) {
			if (card == numberOfCards.get(numberOfCards.size() - 1)) {
				hand += card.toString();
				return hand;
			}
			hand += card.toString() + ", ";
		}
		return "";
	}
	
}
