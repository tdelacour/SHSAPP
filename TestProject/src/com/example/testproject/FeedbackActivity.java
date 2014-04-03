package com.example.testproject;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;


// This Activity is the feedback popup between each question
public class FeedbackActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		
		Intent intent = getIntent();
		String feedback = intent.getStringExtra("feedback");
		TextView content = (TextView) findViewById(R.id.feedback_content);
		content.setText(feedback);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feedback, menu);
		return true;
	}

	// When continue button is clicked
	public void onContinue(View view){ 
		//Weird code that returns to previous activity
		Intent returnIntent = new Intent();
		setResult(RESULT_CANCELED, returnIntent);        
		finish();
	}

}