package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	public BlackjackHand hand;
	
	public Player() {
		hand = new BlackjackHand();
		
	}
	public boolean hit(Scanner sc) {
		System.out.println("Would you like to 1-HIT or 2-STAND");
		String choice = sc.nextLine();
		choice.toLowerCase();
		switch (choice) {
		case "1":
		case "hit":
			return true;
		case "2":
		case "stand":
			return false;
		default:
			System.out.println("Please pick a CORRECT option");
			return true;
		}

	}
	public void displayCard(BlackjackHand UserHand) {
		System.out.println("Current hand: " + UserHand);
		System.out.println("Current hand Value: " + UserHand.getHandValue());
	}
}
