package com.fishingpoker;

public class Game {
	public int iPokerSets = 0;
	public int iGamePointer = 0;
	public Decks Board;
	//Card[] GameCards;
	public Game(int i) {
		iGamePointer = i*54-1;
		iPokerSets = i;
		Board = new Decks(i);
		// TODO Auto-generated constructor stub
	}
//	public void StartGame(){
//		GameCards = new Card[iGamePointer];
//		GameCards = Board.DeckCards(iPokerSets);
//	}
	public Card RemoveOneCard(){
		Card tmpCard = new Card();
		tmpCard.setNumber(Board.DeckCards[iGamePointer].getNumber());
		tmpCard.setSuit(Board.DeckCards[iGamePointer].getSuit());
		tmpCard.setFaceOff();
		iGamePointer--;
		return tmpCard;
	}
	public int getCardPos(){
		return iGamePointer;
	}
}
