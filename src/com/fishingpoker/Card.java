package com.fishingpoker;

public class Card {
	public static final int SPADE = 4;
	public static final int HEART = 3;
	public static final int CLUB = 2;
	public static final int DIAMOND = 1;
	public static final int NOSUITLJ = 10;
	public static final int NOSUITBJ = 20;
	
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int LJOKER = 14;
    public static final int BJOKER = 15;
	
	
	private int number;
	private int suit;
	private boolean face;
	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(int i,int color) {
		this.number=i;
		this.suit=color;
		this.face=false;
		// TODO Auto-generated constructor stub
	}
	public int getSuit(){
		return suit;
	}
	public int getNumber(){
		return number;
	}
	public void setSuit(int i){
		suit = i;
	}
	public void setNumber(int i){
		number = i;
	}
	public int getScore(){
		return suit;
	}
	public void setFaceOff(){
		face=false;
	}
	public void setFaceOn(){
		face=true;
	}

}
