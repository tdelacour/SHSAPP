package com.example.testproject;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;


// This Activity is the feedback popup between each question
public class IntroActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		
		TextView content = (TextView) findViewById(R.id.intro_content);
		content.setText("Welcome to the SHS Sexual Health App!");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feedback, menu);
		return true;
	}

	// When continue button is clicked
	public void onPlay(View view){ 
		//Weird code that returns to previous activity
		Intent intent = new Intent(IntroActivity.this, FullscreenActivity.class);
		IntroActivity.this.startActivity(intent);
		finish();
	}

}