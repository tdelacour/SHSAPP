package com.example.testproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FullscreenActivity extends Activity {

	private QuestionI curQuestion;
	private HealthView health;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		makeTree(); // build story tree
		setContentView(R.layout.activity_fullscreen); //XML layout 
		health = (HealthView) findViewById(R.id.healthView);
		
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		health.setDimension(size);
		
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
		
		// Update score
		health.updateAll(curQuestion.getPoints(1));
		
		// Open the Feedback pop-up or end screen
		if (curQuestion.getFinal()){
			Intent intent = new Intent(FullscreenActivity.this, EndScreenActivity.class);
			FullscreenActivity.this.startActivity(intent);
			finish();
		}
		else{
			curQuestion = curQuestion.getNextQuestions()[0];
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
	}

	public void onAnswer2(View view){
		String feedback = curQuestion.getFeedback(2);
		health.updateAll(curQuestion.getPoints(2));
		if (curQuestion.getFinal()){
			Intent intent = new Intent(FullscreenActivity.this, EndScreenActivity.class);
			FullscreenActivity.this.startActivity(intent);
			finish();
		}
		else{
			curQuestion = curQuestion.getNextQuestions()[1];
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
	}

	public void onAnswer3(View view){
		String feedback = curQuestion.getFeedback(3);
		health.updateAll(curQuestion.getPoints(3));
		if (curQuestion.getFinal()){
			Intent intent = new Intent(FullscreenActivity.this, EndScreenActivity.class);
			FullscreenActivity.this.startActivity(intent);
			finish();
		}
		else{
			curQuestion = curQuestion.getNextQuestions()[2];
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
	}

	public void onAnswer4(View view){
		String feedback = curQuestion.getFeedback(4);
		health.updateAll(curQuestion.getPoints(4));
		if (curQuestion.getFinal()){
			Intent intent = new Intent(FullscreenActivity.this, EndScreenActivity.class);
			FullscreenActivity.this.startActivity(intent);
			finish();
		}
		else{
			curQuestion = curQuestion.getNextQuestions()[3];
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
	}

	// reset layout
	private void setViews(){
		//question
		TextView question = (TextView) findViewById(R.id.fullscreen_content);
		question.setText(curQuestion.getQuestion());

		//answers
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
		
		QuestionI question1 = makeQuestion1();
		QuestionI question2 = makeQuestion2();
		QuestionI question3 = makeQuestion3();
		QuestionI question4 = makeQuestion4();
		QuestionI question5 = makeQuestion5();
		QuestionI question6 = makeQuestion6();
		QuestionI question15 = makeQuestion15();
		QuestionI question16 = makeQuestion16();
		QuestionI question18 = makeQuestion18();
		QuestionI question19 = makeQuestion19();
		
		//Connect everything
		question1.getNextQuestions()[0] = question2;
		question1.getNextQuestions()[1] = question2;
		question1.getNextQuestions()[2] = question3;
		question1.getNextQuestions()[3] = question3;
		
		question2.getNextQuestions()[0] = question3;
		question2.getNextQuestions()[1] = question3;
		question2.getNextQuestions()[2] = question3;
		question2.getNextQuestions()[3] = question3;
		
		question3.getNextQuestions()[0] = question6;
		question3.getNextQuestions()[1] = question6;
		question3.getNextQuestions()[2] = question6;
		question3.getNextQuestions()[3] = question6;
		
		question6.getNextQuestions()[0] = question4;
		question6.getNextQuestions()[1] = question4;
		question6.getNextQuestions()[2] = question4;
		question6.getNextQuestions()[3] = question4;
		
		question4.getNextQuestions()[0] = question15;
		question4.getNextQuestions()[1] = question15;
		question4.getNextQuestions()[2] = question5;
		question4.getNextQuestions()[3] = question15;//update
		
		question5.getNextQuestions()[0] = question1;
		question5.getNextQuestions()[1] = question1;
		question5.getNextQuestions()[2] = question15;//update
		question5.getNextQuestions()[3] = question1;
		
		question15.getNextQuestions()[0] = question16;
		question15.getNextQuestions()[1] = question16;
		question15.getNextQuestions()[2] = question15;
		question15.getNextQuestions()[3] = question15;
		
		question16.getNextQuestions()[0] = question18;
		question16.getNextQuestions()[1] = question18;
		question16.getNextQuestions()[2] = question18;
		question16.getNextQuestions()[3] = question18;
		
		question18.getNextQuestions()[0] = question19;
		question18.getNextQuestions()[1] = question19;
		question18.getNextQuestions()[2] = question19;
		question18.getNextQuestions()[3] = question19;
		curQuestion = question1;
	}
	
	private QuestionI makeQuestion1(){
		String questionS = "You are going out tonight. What do you want to bring?";
		String[] answers = {"A. Condoms", "B. A friend", "C. Extra pants", "D. Your cool new flask"};
		String feed1 = "Great! Here are some other forms birth control:\n Male condom\n Female condom\n Pill\n PatchShot\n Diaphragm\n NuvaRing	\nSpermicide \nCervical cap\n IUD\n Vasectomy\n Female sterilization\n  Contraceptive film\n Implant ";
		String feed2 = "Maybe you should have went with some birth control... here is a list for you:\n Male condom\n Female condom\n Pill\n PatchShot\n Diaphragm\n NuvaRing	\nSpermicide \nCervical cap\n IUD\n Vasectomy\n Female sterilization\n  Contraceptive film\n Implant";
		String[] feedback = {feed1, feed1, feed2, feed2};
		int[][] point = {{10, 0, 10}, {-5, 10, -5}, {-10, -5, -10}, {-10, -10, -10}};
		QuestionI[] nextQs = new QuestionI[4];
		return new Question(questionS, answers, nextQs, feedback, point);
	}
	private QuestionI makeQuestion2(){
		String questionS = "Oh no! You’re broke... but you still want to be safe. Where can you get free condoms?";
		String[] answers = {"A. SHS", "B. 7 Eleven", "C. CHOP", "D. Your friend’s room"};
		String feed1 = "Good job! SHS offers free condoms for all Penn students";
		String feed2 = "You can buy them here.. but they are not free! Go to SHS for free condoms.";
		String feed3 = "Can't buy them here... goto SHS for free condoms";
		String feed4 = "You probably shouldn't steal your friend's condoms... get free condoms at SHS!";
		String[] feedback = {feed1, feed2, feed3, feed4};
		int[][] point = {{10, 0, 10}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		return new Question(questionS, answers, nextQs1, feedback, point);
	}
	
	private QuestionI makeQuestion3(){
		String questionS = "You go to the party. What do you want to watch out for?";
		String[] answers = {"A. Accepting drinks from strangers", "B. All the hotties", "C. That random person trying to make out with you", "D. Getting an embarrassing picture taken of you."};
		String feed1 = "Yes, that is very important!";
		String feed2 = "Maybe this is not as important as accepting drinks from strangers or avoiding creepers...";
		String[] feedback = {feed1, feed2, feed1, feed2};
		int[][] point = {{5, 5, 5}, {0, 10, 0}, {-5, -5, -5}, {-5, -5, -5}};
		QuestionI[] nextQs1 = new QuestionI[4];
		return new Question(questionS, answers, nextQs1, feedback, point);
	}
	private QuestionI makeQuestion4(){
		String questionS = "You are getting really drunk. What should you do now?";
		String[] answers = {"A. Switch to beer. You can’t get drunk off beer.", "B. MORE SHOTS!!!", "C. Drink some water", "D. Ooooh, dannnggg who that over there?"};
		String feed1 = "umm... no you can definitely get drunk off beer. Water would be better.";
		String feed2 = "You're going to feel it tomorrow...";
		String feed3 = "That is a great choice! Water will help rehydrate you and you will not get any more drunk.";
		String feed4 = "You go over and work your magic...";
		String[] feedback = {feed1, feed2, feed3, feed4};
		int[][] point = {{-25, -25, -25}, {-25, -25, -25}, {0, 0, 0}, {0, 0, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		return new Question(questionS, answers, nextQs1, feedback, point);
	}
	private QuestionI makeQuestion5(){
		String questionS = "As you’re enjoying a nice, cold glass of water, some person comes up to you and starts talking… and they’re soooo hawt!";
		String[] answers = {"A. Drop the pants right meow", "B. I’m too drunk to even talk to people right now. I should go home", "C. Lesgo go home", "D. Attractive people are scary. Play dead and maybe they’ll leave you alone."};
		String feed1 = "For some reason that didn't work...I guess you're going hom alone tonight. Let's play again!";
		String feed2 = "I guess you are done for the night...Let's play again!";
		String feed3 = "Here we go...";
		String[] feedback = {feed1, feed2, feed3, feed1};
		int[][] point = {{0, 0, 0}, {100, 100, 100}, {0, 0, 0}, {0, 0, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		return new Question(questionS, answers, nextQs1, feedback, point);
	}
	private QuestionI makeQuestion6(){
		String questionS = "Someone comes up to you and hands you a strange purple drank.";
		String[] answers = {"A. Sip it... DRANK... faded... DRANK", "B. chug it!", "C. Pretend to drink it.", "D. Refuse to drink it."};
		String feed1 = "GLUGLUGLUGLUG...Let's hope there were no roofies in there!";
		String feed2 = "Good job! There might have been some roofies in there.";
		String[] feedback = {feed1, feed1, feed2, feed2};
		int[][] point = {{-10, -20, 10}, {-10, -20, -10}, {5, 5, 5}, {5, 5, 5}};
		QuestionI[] nextQs1 = new QuestionI[4];
		return new Question(questionS, answers, nextQs1, feedback, point);
	}
	private QuestionI makeQuestion15(){
		String questionS = "You wake up having no idea where you with a random naked person next to you. Oh no! You think you might not have used a condom";
		String[] answers = {"A. Who cares! If I leave now, I can still make it to brunch at hill.", "B. We should probably get some emergency contraception", "C. Ugh, maybe if I just go back to sleep, this whole situation will resolve itself.", "D. Why is there a whole in my pants?"};
		String feed1 = "There is a huge risk of an STD or pregnancy! You should probably get that checked out.";
		String feed2 = "That's a great choice! Let's get some...";
		String feed3 = "After you wake up the situation does not change...";
		String feed4 = "Focus on the situation!";
		String[] feedback = {feed1, feed2, feed3, feed4};
		int[][] point = {{-10, 0, -10}, {10, 0, 10}, {0, 0, 0}, {0, 0, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		return new Question(questionS, answers, nextQs1, feedback, point);
	}
	private QuestionI makeQuestion16(){
		String questionS = "Where can we get some emergency contraception?";
		String[] answers = {"A. SHS", "B. Drugstores", "C. Planned Parenthood", "D. All of the above"};
		String feed1 = "Good job! You can get emergency concraception at any of the answers";
		String[] feedback = {feed1, feed1, feed1, feed1};
		int[][] point = {{0, 0, 10}, {0, 0, 10}, {0, 0, 10}, {0, 0, 20}};
		QuestionI[] nextQs1 = new QuestionI[4];
		return new Question(questionS, answers, nextQs1, feedback, point);
	}
	private QuestionI makeQuestion17(){
		String questionS = "Oh no! You’re broke... but you still want to be safe. Where can you get free condoms?";
		String[] answers = {"A. SHS", "B. 7 Eleven", "C. CHOP", "D. Your friend’s room"};
		String feed1 = "Good job! SHS offers free condoms for all Penn students";
		String feed2 = "You can buy them here.. but they are not free! Go to SHS for free comdoms.";
		String feed3 = "Can't buy them here... goto SHS for free condoms";
		String feed4 = "You probably shouldn't steal your friend's condoms... get free condoms at SHS!";
		String[] feedback = {feed1, feed2, feed3, feed4};
		int[][] point = {{10, 0, 10}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		return new Question(questionS, answers, nextQs1, feedback, point);
	}
	private QuestionI makeQuestion18(){
		String questionS = "What if I got an STI?";
		String[] answers = {"A. Let's go to SHS to get a low-cost STI test.", "B. STI? I used spermicide. There's no way of getting STI's with spermicide.", "C. I don't think so...", "D. No way, I have no symptoms of any disease."};
		String feed1 = "Good job! A STI test at the SHS is the best way to help prevent the spread of STI's and to help cure STI's.";
		String feed2 = "That is false! Spermicide only helps with preventing pregnancy, not with preventing STI's. You should probably get an STI test.";
		String feed3 = "That is very irresponsible! Go get a test!";
		String feed4 = "That is a poor choice! Most people who have STI's show no symptoms.";
		String[] feedback = {feed1, feed2, feed3, feed4};
		int[][] point = {{20, 0, 0}, {-10, 0, 0}, {-10, 0, 0}, {-10, 0, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		return new Question(questionS, answers, nextQs1, feedback, point);
	}
	private QuestionI makeQuestion19(){
		String questionS = "Which of the following is an STI?";
		int rand = (int) Math.round(Math.random() * 4);
		String s1, s2, s3, s4;
		if (rand == 0 || rand == 4){
			s1 = "Pubic lice (crabs)";
			s2 = "Trichomoniasis (trich)";
			s3 = "Scabies ";
			s4 = "Syphilis";
		}
		else if(rand == 1){
			s1 = "Pelvic inflammatory disease (PID) ";
			s2 = "Molluscum contagiosum";
			s3 = "Human papillomavirus (HPV)";
			s4 = "HIV/AIDS";
		}
		else if(rand == 2){
			s1 = "Herpes";
			s2 = "Gonorrhea";
			s3 = "Genital Warts";
			s4 = "Cytomegalovirus (CMV) ";
		}
		else{
			s1 = "Chlamydia";
			s2 = "Chancroid";
			s3 = "Human papillomavirus (HPV)";
			s4 = "Syphilis";
		}
		String[] answers = {s1, s2, s3, s4};
		//String feed1 = "Good job! All of these choices are STI's!";
		//String[] feedback = {feed1, feed1, feed1, feed1};
		//int[][] point = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		//QuestionI[] nextQs1 = new QuestionI[4];
		return new Question(questionS, answers, true);
	}
}