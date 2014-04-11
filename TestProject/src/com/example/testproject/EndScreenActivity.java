package com.example.testproject;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;


// This Activity is the feedback popup between each question
public class EndScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end_screen);
		
		TextView content = (TextView) findViewById(R.id.feedback_content);
		content.setTextSize(20);
		content.setPadding(0, 100, 0, 0);
		content.setText("Here will be our final screen with feedback about "
				+ "the user's performance in the game as a whole");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feedback, menu);
		return true;
	}

	// When replay button is clicked
	public void onPlayAgain(View view){ 
		Intent intent = new Intent(EndScreenActivity.this, FullscreenActivity.class);
		EndScreenActivity.this.startActivity(intent);
		finish();
	}
	
	//To exit
	public void onExit(View view){
		finish();
	}
}