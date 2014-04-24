package com.example.testproject;

import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;


// This Activity is the feedback popup between each question
public class FeedbackActivity extends Activity {

	private boolean isFinal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);

		Intent intent = getIntent();
		String feedback = intent.getStringExtra("feedback");
		isFinal = intent.getBooleanExtra("isFinal", false);
		int alcohol = intent.getIntExtra("alcohol", 0);
		int sexual = intent.getIntExtra("sexual", 0);
		setView(feedback, alcohol, sexual);
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
		if (isFinal){
			Intent intent = new Intent(FeedbackActivity.this, EndScreenActivity.class);
			FeedbackActivity.this.startActivity(intent);
			finish();
		}
		else{
			Intent returnIntent = new Intent();
			setResult(RESULT_CANCELED, returnIntent);        
			finish();
		}
	}

	@SuppressLint("NewApi")
	private void setView(String feedback, int alcohol, int sexual){
		//deal with points
		TextView contentPts = (TextView) findViewById(R.id.feedback_points);
		String text = "";
		if (alcohol < 0){
			contentPts.setTextColor(Color.rgb(175, 0, 0));
		}
		else {
			text += "+";
			contentPts.setTextColor(Color.rgb(0, 125, 0));
		}
		text += Integer.toString(alcohol) + " points Alcohol Safety!\n";
		if (sexual < 0){
			contentPts.setTextColor(Color.rgb(175, 0, 0));
		}
		else {
			text += "+";
			contentPts.setTextColor(Color.rgb(0, 125, 0));
		}
		text += Integer.toString(sexual) + " points Sexual Health!\n";
		
		contentPts.setText(text);
		
		//deal with feedback content
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);

		TextView content = (TextView) findViewById(R.id.feedback_content);
		content.setText(feedback);
		int len = feedback.length();

		//Calculate text size
		//Only 700 x 1150 is actually calibrated
		if (size.x > 2400 && size.y > 1450){
			if (len > 140){
				content.setTextSize(107);
			}
			else if (len > 120){
				content.setTextSize(120);
			}
			else if (len > 100){
				content.setTextSize(134);
			}
			else if (len > 80){
				content.setTextSize(150);
			}
			else if (len > 60){
				content.setTextSize(168);
			}
			else {
				content.setTextSize(190);
			}	
		}
		else if (size.x > 1050 && size.y > 1800){
			if (len > 140){
				content.setTextSize(57);
			}
			else if (len > 120){
				content.setTextSize(61);
			}
			else if (len > 100){
				content.setTextSize(66);
			}
			else if (len > 80){
				content.setTextSize(72);
			}
			else if (len > 60){
				content.setTextSize(79);
			}
			else {
				content.setTextSize(88);
			}		
		}
		else if (size.x > 700 && size.y > 1150){
			if (len > 250){
				content.setTextSize(20);
			}
			else if (len > 200){
				content.setTextSize(25);
			}
			else if (len > 150){
				content.setTextSize(30);
			}
			else {
				content.setTextSize(35);
			}
		}
		else if (size.x > 450 && size.y > 750){
			if (len > 140){
				content.setTextSize(14);
			}
			else if (len > 120){
				content.setTextSize(15);
			}
			else if (len > 100){
				content.setTextSize(16);
			}
			else if (len > 80){
				content.setTextSize(18);
			}
			else if (len > 60){
				content.setTextSize(20);
			}
			else {
				content.setTextSize(22);
			}		
		}
		else {
			if (len > 140){
				content.setTextSize(5);
			}
			else if (len > 120){
				content.setTextSize(6);
			}
			else if (len > 100){
				content.setTextSize(7);
			}
			else if (len > 80){
				content.setTextSize(8);
			}
			else if (len > 60){
				content.setTextSize(9);
			}
			else {
				content.setTextSize(10);
			}		
		}
	}
}