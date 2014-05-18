package com.fishingpoker;

public class Player {
	public boolean bFished = false;
	public int iFishPos = 0;
	Card[] HandCard = new Card[5];
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public void setCard(int i,Card SingleCard){
		HandCard[i] = new Card();
		HandCard[i]=SingleCard;
	}
	public void setCard(Card SingleCard){
		HandCard[iFishPos]=SingleCard;
	}
	public Card getCard(int i){
		return HandCard[i];
	}
	public void setFished(){
		bFished = true;
	}
	public void unsetFished(){
		bFished = false;
	}
}
