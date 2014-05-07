package com.fishingpoker;
import java.util.Random;

public class Decks {
	Card[] DeckCards;
	public Decks(int sets) {
		// TODO Auto-generated constructor stub
		DeckCards = new Card[sets*54];
		for(int poker=0; poker<sets; poker++){
			for (int i =0; i< 13; i++){
				for (int j=0; j<4; j++){
					DeckCards[poker*54+i*4+j] = new Card(i+1,j+1);
					if (((poker*54+i*4+j+1)%54)%52 == 0){
						DeckCards[poker*54+i*4+j+1] = new Card(14,10);
						DeckCards[poker*54+i*4+j+2] = new Card(15,20);
					}
				}
			}
		}
		for (int j=0; j<50000; j++){
			int cardnum1 = new Random().nextInt(sets*54);
			int cardnum2 = new Random().nextInt(sets*54);
			int temp = DeckCards[cardnum1].getNumber();
			DeckCards[cardnum1].setNumber(DeckCards[cardnum2].getNumber());
			DeckCards[cardnum2].setNumber(temp);
			temp = DeckCards[cardnum1].getSuit();
			DeckCards[cardnum1].setSuit(DeckCards[cardnum2].getSuit());
			DeckCards[cardnum2].setSuit(temp);
		}
	}
}
