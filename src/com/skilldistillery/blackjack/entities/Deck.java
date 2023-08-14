package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private ArrayList<Card> cards = new ArrayList<>();

	public Deck() {

		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				cards.add(new Card(rank, suit));
			}

		}
	}

	public int cardsLeftInDeck() {
		return cards.size();
	}
	
	public Card dealCard() {
		return cards.remove(0);
	}
	public void shuffle() {
		Collections.shuffle(cards);
	}
	public int size(){
		return cards.size();
		
	}
	public Card getCard(int i) {
		return cards.get(i);
	}
}
