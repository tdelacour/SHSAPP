package com.example.testproject;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
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
		
		Intent intent = getIntent();
		
		TextView content = (TextView) findViewById(R.id.feedback_content);
		content.setTextSize(20);
		content.setPadding(0, 100, 0, 0);
		content.setMovementMethod(LinkMovementMethod.getInstance());
		
		TextView finalFeed = (TextView) findViewById(R.id.finalFeedback);
		
		if (intent.getIntExtra("std", 0) < intent.getIntExtra("prego", 0) && 
				intent.getIntExtra("std", 0) < intent.getIntExtra("rape", 0) 
				&& intent.getIntExtra("std", 0) < 0){
			finalFeed.setText("Uh oh! It seems like you made some irresponsible decisions, "
					+ "particularly when it came to protecting yourself from STDs. The use of protective "
					+ "contraceptive devices is crucial to ensuring a safe, enjoyable experience "
					+ "for you and your partner. If you need access to or more information about any "
					+ "of these tools, Student Health Services is an excellent resource.");
		}
		else if (intent.getIntExtra("prego", 0) < intent.getIntExtra("std", 0) && 
				intent.getIntExtra("prego", 0) < intent.getIntExtra("rape", 0)
				&& intent.getIntExtra("prego", 0) < 0){
			finalFeed.setText("Uh oh! It seems like you made some irresponsible decisions, "
					+ "particularly when it came to protecting yourself from unplanned pregnancy. "
					+ "The use of protective contraceptive devices is crucial to ensuring a safe, "
					+ "enjoyable experience for you and your partner. If you need access to or more "
					+ "information about any of these tools, Student Health Services is an excellent resource.");
		}
		else if (intent.getIntExtra("rape", 0) <= intent.getIntExtra("std", 0) && 
				intent.getIntExtra("rape", 0) <= intent.getIntExtra("prego", 0)
				&& intent.getIntExtra("rape", 0) < 0){
			finalFeed.setText("Uh oh! It seems like you made some irresponsible decisions, particularly when it "
					+ "came to protecting yourself or your partner from sexual assault. Communication "
					+ "is crucial to ensuring a safe, enjoyable experience and no one should be pressured "
					+ "into participating in something that makes them uncomfortable. If you need more information "
					+ "about the UniversityÕs policy on sexual assault or would like to speak to a healthcare "
					+ "professional for any reason, Student Health Services is an excellent resource.");
		}
		else {
			finalFeed.setText("Congratulations! You survived your night out. You mostly made "
					+ "the right choices to keep yourself and those around you safe. Remember though, "
					+ "these situations are not always within your control. If you ever need assistance or "
					+ "more information related to a sexual health or an alcohol issue, Student Health Services "
					+ "is an excellent resource.");
		}
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