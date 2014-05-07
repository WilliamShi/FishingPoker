package com.fishingpoker;

import java.util.Random;

public class HandCard extends Card{
	private int number;
	private int suit;
	private boolean face;

	public HandCard() {
		// TODO Auto-generated constructor stub
	}
	public Card[] InitHandCards(int num){
		Card[] HandCards = new Card[num];
		for(int poker=0; poker<num; poker++){
			HandCards[poker] = new Card(0,0);
			HandCards[poker].setFaceOff();
		}
	return HandCards;
	}

}
