package com.example.testproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FullscreenActivity extends Activity {

	private QuestionI curQuestion;
	private HealthView health;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		makeTree(); // build story tree
		setContentView(R.layout.activity_fullscreen); //XML layout 
		health = (HealthView) findViewById(R.id.healthView);
		setViews(); //Initialize question and answer fields
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
	}

	// reaction to button click. Again can we generalize?
	public void onAnswer1(View view){
		// Update question object and XML
		String feedback = curQuestion.getFeedback(1);
		curQuestion = curQuestion.getNextQuestions()[0];
		
		// Update score
		health.updateAll(curQuestion.getPoints(1));
		
		// Open the Feedback pop-up
		Intent intent = new Intent(FullscreenActivity.this, FeedbackActivity.class);
		intent.putExtra("feedback", feedback);
		FullscreenActivity.this.startActivityForResult(intent, 1);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setViews();
	}

	public void onAnswer2(View view){
		String feedback = curQuestion.getFeedback(2);
		curQuestion = curQuestion.getNextQuestions()[1];
		health.updateAll(curQuestion.getPoints(2));
		Intent intent = new Intent(FullscreenActivity.this, FeedbackActivity.class);
		intent.putExtra("feedback", feedback);
		FullscreenActivity.this.startActivityForResult(intent, 1);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setViews();
	}

	public void onAnswer3(View view){
		String feedback = curQuestion.getFeedback(3);
		curQuestion = curQuestion.getNextQuestions()[2];
		health.updateAll(curQuestion.getPoints(3));
		Intent intent = new Intent(FullscreenActivity.this, FeedbackActivity.class);
		intent.putExtra("feedback", feedback);
		FullscreenActivity.this.startActivityForResult(intent, 1);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setViews();
	}

	public void onAnswer4(View view){
		String feedback = curQuestion.getFeedback(4);
		curQuestion = curQuestion.getNextQuestions()[3];
		health.updateAll(curQuestion.getPoints(4));
		Intent intent = new Intent(FullscreenActivity.this, FeedbackActivity.class);
		intent.putExtra("feedback", feedback);
		FullscreenActivity.this.startActivityForResult(intent, 1);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setViews();
	}

	// reset layout
	private void setViews(){
		// question
		TextView question = (TextView) findViewById(R.id.fullscreen_content);
		question.setText(curQuestion.getQuestion());

		// answers: concatenates curQuestion answers with default ("A", "B", etc)
		/* 
		 * So I generalized QuestionI objects to be able to take any number 
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
		String questionS5ab = "You wake up having no idea where you with a random naked person next to you. Oh no! You think you might not have used a condom";
		String[] answers5ab = {"A. Who cares! If I leave now, I can still make it to brunch at hill.", "B. We should probably get some emergency contraception", "C. Ugh, maybe if I just go back to sleep, this whole situation will resolve itself.", "D. Why is there a whole in my pants?"};
		QuestionI question5ab = new Question(questionS5ab, answers5ab, true);
		
		String questionS5c = "As you're enjoying a nice, cold glass of water, some person comes up to you and starts talking and they're soooo hawt!";
		String[] answers5c = {"A. Drop the pants right meow", "B. I'm too drunk to even talk to people right now. I should go home", "C. Lesgo go home", "D. Attractive people are scary. Play dead and maybe they'll leave you alone."};
		QuestionI question5c = new Question(questionS5c, answers5c, true);
		
		String questionS4 = "You are getting really drunk. What should you do now?";
		String[] answers4 = {"A. Switch to beer. You can't get drunk off beer.", "B. MORE SHOTS!!!", "C. Drink some water", "D. Ooooh, dammmn who that over there?"};
		String[] feedback4 = {"Good job!", "Good job!", "no", "no"};
		int[][] point4 = {{-10, -10, -10}, {5, 5, 5}, {-10, -10, -10}, {10, 10, 10}};
		QuestionI[] nextQs4 = {question5ab, question5ab, question5c, question5c};
		QuestionI question4 = new Question(questionS4, answers4, nextQs4, feedback4, point4);
		
		String questionS3 = "You go to the party. What do you want to watch out for?";
		String[] answers3 = {"A. Accepting drinks from strangers", "B. Getting raped", "C. Making out with that random person", "D. Getting an embarrassing picture taken of you."};
		String[] feedback3 = {"Good job!", "Good job!", "no", "no"};
		int[][] point3 = {{5, 5, 5}, {2, 10, 2}, {0, 2, 2}, {0, 0, 0}};
		QuestionI[] nextQs3 = {question4, question4, question4, question4};
		QuestionI question3 = new Question(questionS3, answers3, nextQs3, feedback3, point3);
		
		String questionS2 = "Oh no! You're broke... but you still want to be safe. Where can you get free condoms?";
		String[] answers2 = {"A. SHS", "B. 7 Eleven", "C. CHOP", "D. Your friend's room"};
		String[] feedback2 = {"Good job!", "no", "no", "no"};
		int[][] point2 = {{10, 0, 10}, {-5, 0, -5}, {-5, 0, -5}, {5, 0, 5}};
		QuestionI[] nextQs2 = {question3, question3, question3, question3};
		QuestionI question2 = new Question(questionS2, answers2, nextQs2, feedback2, point2);

		String questionS1 = "You are going out tonight. What do you want to bring?";
		String[] feedback1 = {"Good job!", "Good job!", "okay...", "okay..."};
		String[] answers1 = {"A. Condoms", "B. A friend", "C. Extra pants", "D. Your cool new flask"};
		int[][] point1 = {{10, 0, 10}, {-5, 10, -5}, {-10, -5, -10}, {-10, -10, -10}};
		QuestionI[] nextQs1 = {question2, question2, question2, question2};
		QuestionI question1 = new Question(questionS1, answers1, nextQs1, feedback1, point1);

		curQuestion = question1;	
	}
}