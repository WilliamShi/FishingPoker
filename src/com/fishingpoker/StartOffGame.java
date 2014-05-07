package com.fishingpoker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class StartOffGame extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_off_game);

//		if (savedInstanceState == null) {
//			getSupportFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
		// Get the message from the intent
	    Intent intent = getIntent();
	    int iPoker = Integer.parseInt(intent.getStringExtra(MainActivity.POKER_NUM_MESSAGE));
	    int iPlayer = Integer.parseInt(intent.getStringExtra(MainActivity.PLAYER_NUM_MESSAGE)) + 1;

	    Game FishGame = new Game(iPoker);
	    //FishGame.StartGame();
	    Player[] Players = new Player[iPlayer];
	    for (int i=0; i<iPlayer;i++ ){
	    	Players[i] = new Player();
	    	Players[i].unsetFished();
	    	for (int j=0; j<5; j++){
	    		Players[i].HandCard[j] = new Card();
	    		Players[i].HandCard[j] = FishGame.RemoveOneCard();
	    	}
	    }
	    System.out.println(FishGame.getCardPos());
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
	public void start_real_offgame(){
		//HandCardss[0] = Cardss[0];
	}
}
