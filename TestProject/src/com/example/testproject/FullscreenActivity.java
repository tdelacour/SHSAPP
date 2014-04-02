package com.example.testproject;

import com.example.testproject.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FullscreenActivity extends Activity {

	private QuestionI curQuestion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		makeTree(); // build story tree
		setContentView(R.layout.activity_fullscreen); //XML layout 
		setViews(); //Initialize question and answer fields
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
	}

	// reaction to button click. Again can we generalize?
	public void onAnswer1(View view){
		// Update question object and XML
		curQuestion = curQuestion.getNextQuestions()[0];
		setViews();

		// Open the Feedback pop-up
		/*
		 * We need to send data over to the Feedback pop up. I think the best 
		 * way to do this is to have a series of string comments hard-coded 
		 * into each question object. That way there can be one comment associated 
		 * with each answer. Apparently the way to transmit data between activities 
		 * is through the "intent" thingy. Not sure how that works yet. - TD
		 */
		Intent intent = new Intent(FullscreenActivity.this, FeedbackActivity.class);
		FullscreenActivity.this.startActivityForResult(intent, 1);
	}

	public void onAnswer2(View view){
		curQuestion = curQuestion.getNextQuestions()[1];
		setViews();
	}

	public void onAnswer3(View view){
		curQuestion = curQuestion.getNextQuestions()[2];
		setViews();
	}

	public void onAnswer4(View view){
		curQuestion = curQuestion.getNextQuestions()[3];
		setViews();
	}

	// reset layout
	private void setViews(){
		// question
		TextView question = (TextView) findViewById(R.id.fullscreen_content);
		question.setText(curQuestion.getQuestion());

		// answers: concatenates curQuestion answers with default ("A", "B", etc)
		/* So I generalized QuestionI objects to be able to take any number 
		 * of answers, but realize here that this is sort of set by the total
		 * number of buttons we define in the XML itself. Ideas for generalizing?
		 *  -TD
		 */
		String[] strArr = curQuestion.getAnswers(); 		
		Button mButton=(Button)findViewById(R.id.answer1);
		mButton.setText(strArr[0]);
		mButton=(Button)findViewById(R.id.answer2);
		mButton.setText(strArr[1]);
		mButton=(Button)findViewById(R.id.answer3);
		mButton.setText(strArr[2]);
		mButton=(Button)findViewById(R.id.answer4);
		mButton.setText(strArr[3]);
	}

	private void makeTree(){
		// here is where we play around with different question formulations
		String question = "This is our second question";
		String[] answers2 = {"A. q2 answer1", "B. q2 answer2", "C. q2 answer3", 
		"D. q2 answer4"};
		QuestionI question2 = new Question(question, answers2);

		question = "This is our first question";
		String[] feedback = {"Good job!", "Uh-oh", "Better luck next time", "okay..."};
		String[] answers1 = {"A. q1 answer1", "B. q1 answer2", "C. q1 answer3", 
				"D. q1 answer4"};
		QuestionI[] nextQs1 = {question2, question2, question2, question2};
		QuestionI question1 = new Question(question, answers1, nextQs1, feedback);

		curQuestion = question1;	
	}
}