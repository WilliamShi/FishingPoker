package com.fishingpoker;

import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class StartOffGame extends ActionBarActivity {
	private Game FishGame;
	private Player[] Players;
	private int iPoker;
	private int iPlayer;
	private int iNowPlayer;
	private LinkedList2d<Card> DeskCard = new LinkedList2d<Card>();
	private boolean isRunning = true;
	private Handler handler;
	private Thread gameThread;
	private boolean bPlayerClicked = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_off_game);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		// Get the message from the intent
	    Intent intent = getIntent();
	    iPoker = Integer.parseInt(intent.getStringExtra(MainActivity.POKER_NUM_MESSAGE));
	    iPlayer = Integer.parseInt(intent.getStringExtra(MainActivity.PLAYER_NUM_MESSAGE)) + 1;

	    FishGame = new Game(iPoker);
	    //FishGame.StartGame();
	    Players = new Player[iPlayer];
	    int iWhichPlayer = new Random().nextInt(iPlayer);
	    
	    for (int i=iWhichPlayer; i< (iWhichPlayer + iPlayer);i++ ){
	    	iNowPlayer = i%iPlayer;
	    	Players[iNowPlayer] = new Player();
	    	Players[iNowPlayer].unsetFished();
	    }
	    	for (int k=0; k<5; k++){
	    		for (int j=iNowPlayer;j<(iNowPlayer+iPlayer);j++){
		    		Players[j%iPlayer].HandCard[k] = new Card();
		    		Players[j%iPlayer].HandCard[k] = FishGame.RemoveOneCard();
	    		}
	    	}
	    System.out.println(FishGame.getCardPos());
	    handler = new MyHandler(Looper.getMainLooper());
	    //AutoPlaying();
	    // Create the text view
	    //TextView textView = new TextView(this);
	    //textView.setTextSize(40);
	    //textView.setText(messagepo);

	    // Set the text view as the activity layout
	    //setContentView(textView);
	    // Create the text view
	    //TextView textView2 = new TextView(this);
	    //textView2.setTextSize(40);
	    //textView2.setText(messagepl);

	    // Set the text view as the activity layout
	    //Cardss = deckstest.InitDecks(4);
	    //textView2.setText(Cardss[5].getNumber());
	    //CharSequence cs=String.valueOf(Cardss[5].getNumber());
	    //textView2.setText(cs);
	    //setContentView(textView2);
	       gameThread = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                int timer = 0;
	                while (isRunning) {
	                    try {
	                        Thread.sleep(10);
	            			if (iNowPlayer == 0){
	            				if (Players[iNowPlayer].bFished == false){
	            					if(bPlayerClicked){
	            						bPlayerClicked = false;
		            					DeskCard.add(FishGame.RemoveOneCard());
		            					System.out.println(DeskCard.getLast().getNumber());
		            					System.out.println(DeskCard.getLast().getSuit());
		            					iNowPlayer++;
		            					iNowPlayer = iNowPlayer%iPlayer;	 
	            						Message msg = Message.obtain();
	            						msg.what = Constant.UPDATE_DESKCARDS;
	            						msg.obj = DeskCard;
	            						handler.sendMessage(msg);
		            					}
	            				}
	            				else {
	            						Players[iNowPlayer].unsetFished();
		            					Players[iNowPlayer].setCard(FishGame.RemoveOneCard());
		            					DeskCard.add(FishGame.RemoveOneCard());
	            						Message msg = Message.obtain();
	            						msg.what = Constant.UPDATE_HANDCARDS;
	            						msg.obj = Players[iNowPlayer];
	            						handler.sendMessage(msg);
	            						//Message msg = Message.obtain();
	            						msg.what = Constant.UPDATE_DESKCARDS;
	            						msg.obj = DeskCard;
	            						handler.sendMessage(msg);
	            				}
	            			}
	            			else{
	            				for(int j=iNowPlayer;j<iPlayer;j++){
	            					if (Players[j].bFished == false){
	            						DeskCard.add(FishGame.RemoveOneCard());
	            						iNowPlayer++;
	            						iNowPlayer = iNowPlayer%iPlayer;
	            						try {
		            						Message msg = Message.obtain();
		            						msg.what = Constant.UPDATE_DESKCARDS;
		            						msg.obj = DeskCard;
		            						handler.sendMessage(msg);
	            						    Thread.sleep(5);
	            						} catch(InterruptedException ex) {
	            						    Thread.currentThread().interrupt();
	            						}
	            					}
	            					else{
	            						Players[j].unsetFished();
	            						Players[j].setCard(FishGame.RemoveOneCard());
	            						DeskCard.add(FishGame.RemoveOneCard());
	            						Message msg = Message.obtain();
	            						msg.what = Constant.UPDATE_DESKCARDS;
	            						msg.obj = DeskCard;
	            						handler.sendMessage(msg);
	            					}
	            				}
	            			}
	            			//setContentView(R.layout.activity_start_off_game);
	            			System.out.println(FishGame.iGamePointer);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        });

	        gameThread.start(); /* 启动线程 */	    
	}

	protected void onDestroy(){
		gameThread.stop();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_off_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_start_off_game,
					container, false);
			return rootView;
		}
	}
	public void AutoPlaying(){
		
		if (iNowPlayer != 0){
			start_real_offgame(getWindow().getDecorView());
		}
	}
	public void start_real_offgame(View v){
		if(!bPlayerClicked){
			bPlayerClicked = true;
		}
	}
	public void get_right_cards(View v){
		Players[iNowPlayer].setFished();
	}
    class MyHandler extends Handler{
    	public MyHandler(Looper looper){
    		super(looper);
    	}
    	@Override
        public void handleMessage(Message m){
            switch (m.what)
            {
            case Constant.UPDATE_DESKCARDS:
            	LinkedList2d<Card> DeskCardUpdate = (LinkedList2d<Card>)m.obj;
            	System.out.println(DeskCardUpdate.getLast().getNumber());
            case Constant.UPDATE_HANDCARDS:
            }
            super.handleMessage(m);
        }
	}
}
