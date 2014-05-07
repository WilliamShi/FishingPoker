package com.fishingpoker;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	public final static String POKER_NUM_MESSAGE = "com.hwshi.fishingpoker.MESSAGE";
	public final static String PLAYER_NUM_MESSAGE = "com.hwshi.fishingpoker.MESSAGE";
	private TextView viewtextpk;
	private TextView viewtextpl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		

		viewtextpk = (TextView) findViewById(R.id.poker_text);
		Spinner spinner = (Spinner) findViewById(R.id.poker_spinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.poker_number, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new SpinnerSelectedListener());

		viewtextpl = (TextView) findViewById(R.id.player_text);
		Spinner spinner2 = (Spinner) findViewById(R.id.player_spinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
		        R.array.player_number, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner2.setAdapter(adapter2);
		spinner2.setOnItemSelectedListener(new SpinnerSelectedListener2());
		
//		if (savedInstanceState == null) {
//			getSupportFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
//		if (savedInstanceState == null) {
//			getSupportFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	public class SpinnerSelectedListener extends Activity implements OnItemSelectedListener{		
		public void onItemSelected(AdapterView<?> parent, View view, 
	            int pos, long id) {
			//pokerprompt.setText ("you selected: " + adapterpoker.getItem(pos));
			//spinner.setPrompt ("you selected: " + parent.getItemAtPosition(pos));
			viewtextpk.setText ("How many Sets of Poker: "+ parent.getItemAtPosition(pos));
	        // An item was selected. You can retrieve the selected item using
	        // parent.getItemAtPosition(pos)
	    }

	    public void onNothingSelected(AdapterView<?> parent) {
	        // Another interface callback
	    }
	}
	public class SpinnerSelectedListener2 extends Activity implements OnItemSelectedListener{		
		public void onItemSelected(AdapterView<?> parent, View view, 
	            int pos, long id) {
			//pokerprompt.setText ("you selected: " + adapterpoker.getItem(pos));
			//spinner.setPrompt ("you selected: " + parent.getItemAtPosition(pos));
			viewtextpl.setText ("How many Computer Player: "+ parent.getItemAtPosition(pos));
	        // An item was selected. You can retrieve the selected item using
	        // parent.getItemAtPosition(pos)
	    }

	    public void onNothingSelected(AdapterView<?> parent) {
	        // Another interface callback
	    }
	}
	/** Called when the user clicks the Send button */
	public void startOffGame(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, StartOffGame.class);
		Spinner spinnerpo = (Spinner) findViewById(R.id.poker_spinner);
		String pokernum = spinnerpo.getSelectedItem().toString();
		Spinner spinnerpl = (Spinner) findViewById(R.id.player_spinner);
		String playernum = spinnerpl.getSelectedItem().toString();
		intent.putExtra(POKER_NUM_MESSAGE, pokernum);
		intent.putExtra(PLAYER_NUM_MESSAGE, playernum);
		startActivity(intent);
	}
}
