package com.example.testproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FullscreenActivity extends Activity {

	private QuestionI curQuestion;
	private HealthView health;
	private Point dimension;
	private int std = 0;
	private int prego = 0;
	private int rape = 0;

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
		dimension = size;

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
		this.std += curQuestion.getPoints(1)[1];
		this.prego += curQuestion.getPoints(1)[2];
		this.rape += curQuestion.getPoints(1)[3];
		
		int[] sexual = curQuestion.getPoints(1);

		// Open the Feedback pop-up or end screen
		if (curQuestion.getFinal()[0]){
			Intent intent = new Intent(FullscreenActivity.this, FeedbackActivity.class);
			intent.putExtra("isFinal", curQuestion.getFinal()[0]);
			intent.putExtra("feedback", feedback);
			intent.putExtra("alcohol", sexual[0]);
			intent.putExtra("sexual", sexual[1] + sexual[2] + sexual[3]);
			FullscreenActivity.this.startActivity(intent);
			finish();
		}
		else{
			curQuestion = curQuestion.getNextQuestions()[0];
			Intent intent = new Intent(FullscreenActivity.this, FeedbackActivity.class);
			intent.putExtra("feedback", feedback);
			intent.putExtra("alcohol", sexual[0]);
			intent.putExtra("sexual", sexual[1] + sexual[2] + sexual[3]);
			FullscreenActivity.this.startActivityForResult(intent, 1);
		}
	}

	public void onAnswer2(View view){
		String feedback = curQuestion.getFeedback(2);
		health.updateAll(curQuestion.getPoints(2));
		int[] sexual = curQuestion.getPoints(2);
		
		this.std += curQuestion.getPoints(2)[1];
		this.prego += curQuestion.getPoints(2)[2];
		this.rape += curQuestion.getPoints(2)[3];
		if (curQuestion.getFinal()[1]){
			Intent intent = new Intent(FullscreenActivity.this, FeedbackActivity.class);
			intent.putExtra("isFinal", curQuestion.getFinal()[1]);
			intent.putExtra("feedback", feedback);
			intent.putExtra("alcohol", sexual[0]);
			intent.putExtra("sexual", sexual[1] + sexual[2] + sexual[3]);
			FullscreenActivity.this.startActivity(intent);
			finish();
		}
		else{
			curQuestion = curQuestion.getNextQuestions()[1];
			Intent intent = new Intent(FullscreenActivity.this, FeedbackActivity.class);
			intent.putExtra("feedback", feedback);
			intent.putExtra("alcohol", sexual[0]);
			intent.putExtra("sexual", sexual[1] + sexual[2] + sexual[3]);
			FullscreenActivity.this.startActivityForResult(intent, 1);
		}
	}

	public void onAnswer3(View view){
		String feedback = curQuestion.getFeedback(3);
		health.updateAll(curQuestion.getPoints(3));
		int[] sexual = curQuestion.getPoints(3);
		
		this.std += curQuestion.getPoints(3)[1];
		this.prego += curQuestion.getPoints(3)[2];
		this.rape += curQuestion.getPoints(3)[3];
		if (curQuestion.getFinal()[2]){
			Intent intent = new Intent(FullscreenActivity.this, FeedbackActivity.class);
			intent.putExtra("isFinal", curQuestion.getFinal()[2]);
			intent.putExtra("feedback", feedback);
			intent.putExtra("alcohol", sexual[0]);
			intent.putExtra("sexual", sexual[1] + sexual[2] + sexual[3]);
			FullscreenActivity.this.startActivity(intent);
			finish();
		}
		else{
			curQuestion = curQuestion.getNextQuestions()[2];
			Intent intent = new Intent(FullscreenActivity.this, FeedbackActivity.class);
			intent.putExtra("feedback", feedback);
			intent.putExtra("alcohol", sexual[0]);
			intent.putExtra("sexual", sexual[1] + sexual[2] + sexual[3]);
			FullscreenActivity.this.startActivityForResult(intent, 1);
		}
	}

	public void onAnswer4(View view){
		String feedback = curQuestion.getFeedback(4);
		health.updateAll(curQuestion.getPoints(4));
		int[] sexual = curQuestion.getPoints(4);
		
		this.std += curQuestion.getPoints(4)[1];
		this.prego += curQuestion.getPoints(4)[2];
		this.rape += curQuestion.getPoints(4)[3];
		if (curQuestion.getFinal()[3]){
			Intent intent = new Intent(FullscreenActivity.this, FeedbackActivity.class);
			intent.putExtra("isFinal", curQuestion.getFinal()[3]);
			intent.putExtra("feedback", feedback);
			intent.putExtra("alcohol", sexual[0]);
			intent.putExtra("sexual", sexual[1] + sexual[2] + sexual[3]);
			FullscreenActivity.this.startActivity(intent);
			finish();
		}
		else{
			curQuestion = curQuestion.getNextQuestions()[3];
			Intent intent = new Intent(FullscreenActivity.this, FeedbackActivity.class);
			intent.putExtra("feedback", feedback);
			intent.putExtra("alcohol", sexual[0]);
			intent.putExtra("sexual", sexual[1] + sexual[2] + sexual[3]);
			FullscreenActivity.this.startActivityForResult(intent, 1);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		setViews();
	}

	// reset layout
	private void setViews(){
		//textview reference
		TextView question = (TextView) findViewById(R.id.fullscreen_content);
		String nextq = curQuestion.getQuestion();
		int len = nextq.length();

		//Calculate text size
		if (dimension.x > 2400 && dimension.y > 1450){
			if (len > 140){
				question.setTextSize(107);
			}
			else if (len > 120){
				question.setTextSize(120);
			}
			else if (len > 100){
				question.setTextSize(134);
			}
			else if (len > 80){
				question.setTextSize(150);
			}
			else if (len > 60){
				question.setTextSize(168);
			}
			else {
				question.setTextSize(190);
			}	
		}
		else if (dimension.x > 1050 && dimension.y > 1800){
			if (len > 140){
				question.setTextSize(57);
			}
			else if (len > 120){
				question.setTextSize(61);
			}
			else if (len > 100){
				question.setTextSize(66);
			}
			else if (len > 80){
				question.setTextSize(72);
			}
			else if (len > 60){
				question.setTextSize(79);
			}
			else {
				question.setTextSize(88);
			}		
		}
		else if (dimension.x > 700 && dimension.y > 1150){
			if (len > 160){
				question.setTextSize(25);
			}
			else if (len > 140){
				question.setTextSize(27);
			}
			else if (len > 120){
				question.setTextSize(29);
			}
			else if (len > 100){
				question.setTextSize(32);
			}
			else if (len > 80){
				question.setTextSize(35);
			}
			else if (len > 60){
				question.setTextSize(39);
			}
			else {
				question.setTextSize(44);
			}	
		}
		else if (dimension.x > 450 && dimension.y > 750){
			if (len > 140){
				question.setTextSize(14);
			}
			else if (len > 120){
				question.setTextSize(15);
			}
			else if (len > 100){
				question.setTextSize(16);
			}
			else if (len > 80){
				question.setTextSize(18);
			}
			else if (len > 60){
				question.setTextSize(20);
			}
			else {
				question.setTextSize(22);
			}		
		}
		else {
			if (len > 140){
				question.setTextSize(5);
			}
			else if (len > 120){
				question.setTextSize(6);
			}
			else if (len > 100){
				question.setTextSize(7);
			}
			else if (len > 80){
				question.setTextSize(8);
			}
			else if (len > 60){
				question.setTextSize(9);
			}
			else {
				question.setTextSize(10);
			}		
		}

		//question
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

		//image
		ImageView iv= (ImageView)findViewById(R.id.stickImage);
		iv.setImageResource(getResources().getIdentifier(curQuestion.getPic(), 
				"drawable", getPackageName()));
	}

	private void makeTree(){

		QuestionI question1  = makeQuestion1();
	    QuestionI question2  = makeQuestion2();
	    QuestionI question3  = makeQuestion3();
	    QuestionI question4  = makeQuestion4();
	    QuestionI question5  = makeQuestion5();
	    QuestionI question6  = makeQuestion6();
	    QuestionI question7  = makeQuestion7();
	    QuestionI question8  = makeQuestion8();
	    QuestionI question9  = makeQuestion9();
	    QuestionI question10 = makeQuestion10();
	    QuestionI question11 = makeQuestion11();
	    QuestionI question12 = makeQuestion12();
	    QuestionI question13 = makeQuestion13();
	    QuestionI question14 = makeQuestion14();
	    QuestionI question15 = makeQuestion15();
	    QuestionI question16 = makeQuestion16();
	    QuestionI question17 = makeQuestion17();
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
	    question4.getNextQuestions()[3] = question7;//update
	    
	    question5.getNextQuestions()[0] = question1;
	    question5.getNextQuestions()[1] = question1;
	    question5.getNextQuestions()[2] = question7;//update
	    question5.getNextQuestions()[3] = question7;

	    question7.getNextQuestions()[0] = question14;
	    question7.getNextQuestions()[1] = question8;
	    question7.getNextQuestions()[2] = question9;
	    question7.getNextQuestions()[3] = question9;

	    question8.getNextQuestions()[0] = question10;
	    question8.getNextQuestions()[1] = question9;
	    question8.getNextQuestions()[2] = question10;
	    question8.getNextQuestions()[3] = question10;

	    question9.getNextQuestions()[0] = question10;
	    question9.getNextQuestions()[1] = question10;
	    question9.getNextQuestions()[2] = question10;
	    question9.getNextQuestions()[3] = question10;

	    question10.getNextQuestions()[0] = question11;
	    question10.getNextQuestions()[1] = question11;
	    question10.getNextQuestions()[2] = question11;
	    question10.getNextQuestions()[3] = question11;

	    question11.getNextQuestions()[0] = question12;
	    question11.getNextQuestions()[1] = question12;
	    question11.getNextQuestions()[2] = question12;
	    question11.getNextQuestions()[3] = question12;

	    question12.getNextQuestions()[0] = question14;
	    question12.getNextQuestions()[1] = question13;
	    question12.getNextQuestions()[2] = question14;
	    question12.getNextQuestions()[3] = question13;

	    question13.getNextQuestions()[0] = question14;
	    question13.getNextQuestions()[1] = question14;
	    question13.getNextQuestions()[2] = question14;
	    question13.getNextQuestions()[3] = question14;

	    question14.getNextQuestions()[0] = question17;
	    question14.getNextQuestions()[1] = question17;
	    question14.getNextQuestions()[2] = question17;
	    question14.getNextQuestions()[3] = question17;
	    
	    question15.getNextQuestions()[0] = question16;
	    question15.getNextQuestions()[1] = question16;
	    question15.getNextQuestions()[2] = question15;
	    question15.getNextQuestions()[3] = question15;
	    
	    question16.getNextQuestions()[0] = question18;
	    question16.getNextQuestions()[1] = question18;
	    question16.getNextQuestions()[2] = question18;
	    question16.getNextQuestions()[3] = question18;
	    
	    question17.getNextQuestions()[0] = question18;
	    question17.getNextQuestions()[1] = question18;
	    question17.getNextQuestions()[2] = question18;
	    question17.getNextQuestions()[3] = question18;
	    
	    question18.getNextQuestions()[0] = question19;
	    question18.getNextQuestions()[1] = question19;
	    question18.getNextQuestions()[2] = question19;
	    question18.getNextQuestions()[3] = question19;
	    curQuestion = question1;
	}

	private QuestionI makeQuestion1(){
		String questionS = "You are going out tonight. What do you want to bring?";
		String[] answers = {"A. Condoms", "B. A friend", "C. Extra pants", "D. Your cool new flask"};
		String feed1 = "Great! Here are some other forms of birth control:\n -Male condom\n -Female condom\n -The pill\n -Contraceptive patch\n -Birth control shot\n -Diaphragm\n -NuvaRing \n -Spermicide \n -Cervical cap\n -Intrauterine Device (IUD)\n -Vasectomy\n -Female sterilization\n -Contraceptive film or implant ";
		String feed2 = "Maybe you should have went with some birth control... here's a list of possible contraceptives:\n -Male condom\n -Female condom\n -The pill\n -Contraceptive patch\n -Birth control shot\n -Diaphragm\n -NuvaRing \n -Spermicide \n -Cervical cap\n -Intrauterine Device (IUD)\n -Vasectomy\n -Female sterilization\n -Contraceptive film or implant";
		String[] feedback = {feed1, feed1, feed2, feed2};
		int[][] point = {{0, 5, 5, 0}, {5, 0, 0, 7}, {-5, -1, -1, -1}, {-15, -2, -2, -6}};
		QuestionI[] nextQs = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs, feedback, point, isFinal, "sticksolo");
	}

	private QuestionI makeQuestion2() {
		String questionS = "Oh no! You're broke... but you still want to be safe. Where can you get free condoms?";
		String[] answers = {"A. SHS", "B. CVS", "C. CHOP", "D. Your friend's room"};
		String feed1 = "Good job! SHS offers 6 free condoms per visit for all Penn students";
		String feed2 = "You can buy them here.. but they are not free! Go to SHS for free condoms.";
		String feed3 = "Can't buy them here... goto SHS for free condoms";
		String feed4 = "You probably shouldn't steal your friend's condoms... get free condoms at SHS!";
		String[] feedback = {feed1, feed2, feed3, feed4};
		int[][] point = {{0, 3, 2, 0}, {0, -3, -2, 0}, {0, -5, -2, 0}, {0, -3, -2, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "sticksolo");
	}

	private QuestionI makeQuestion3(){
		String questionS = "You head out to the party. What do you want to watch out for?";
		String[] answers = {"A. Accepting drinks from strangers", "B. All the hotties", "C. That random person trying to make out with you", "D. Getting an embarrassing picture taken of yourself."};
		String feed1 = "Yes, that is very important!";
		String feed2 = "Maybe this is not as important as watching out for drug-laced drinks or avoiding creepers...";
		String[] feedback = {feed1, feed2, feed1, feed2};
		int[][] point = {{15, 0, 0, 10}, {0, -3, -3, -4}, {0, 0, 0, 5}, {-10, -1, -1, -3}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "party1");
	}
	private QuestionI makeQuestion4(){
		String questionS = "You are getting REALLY drunk. What should you do now?";
		String[] answers = {"A. Switch to beer. You can't get drunk off beer.", "B. MORE SHOTS!!!", "C. Drink some water", "D. Ooooh, dannnggg who that over there?"};
		String feed1 = "Umm... no you can definitely get drunk off beer. Although it is a common misconception that you can't become drunk purely off of beer, one twelve ounce can has the same alcohol content of a shot of vodka or a glass of wine. Water would probably be a better choice.";
		String feed2 = "You're going to feel it tomorrow...";
		String feed3 = "That is a great choice! Water will help rehydrate you and will dilute any alcohol left in your stomach. You might not feel better immediately, but this'll help both your liver and your hangover.";
		String feed4 = "Maybe you shoulda drunk some water. But you go over and work your magic...";
		String[] feedback = {feed1, feed2, feed3, feed4};
		int[][] point = {{-10, 0, 0, 0}, {-15, 0, 0, 0}, {10, 0, 0, 0}, {-1, 0, 0, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "party3");
	}

	private QuestionI makeQuestion5(){
		String questionS = "As you're enjoying a nice, cold glass of water, someone comes up to you and starts talking and they're soooo hawt! What do you do!?!";
		String[] answers = {"A. Drop the pants right meow", "B. I'm too drunk to even talk to people right now. I should go home", "C. Let's take 'em home!", "D. Time to get yo flirt on"};
		String feed1 = "For some reason that didn't work...I guess you're going home alone tonight. Let's play again!";
		String feed2 = "I guess you are done for the night...Let's play again!";
		String feed3 = "Here we go...";
		String feed4 = "They're really into you and offer to walk home with you. They seem cool so you agree.";
		String[] feedback = {feed1, feed2, feed3, feed4};
		int[][] point = {{0, -10, -10, -10}, {20, 10, 10, 10}, {0, 0, 0, -10}, {0, 0, 0, 5}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {true, true, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "partyapproach");
	}

	private QuestionI makeQuestion6(){
		String questionS = "Someone comes up to you and hands you a strange purple drank.";
		String[] answers = {"A. Sip it... DRANK... faded... DRANK", "B. chug it!", "C. Pretend to drink it.", "D. Refuse to drink it."};
		String feed1 = "You'd better hope there were no roofies in there! The drug Rohypnol can cause anything from amnesia and extreme sedation to seizures, respiratory failure and death. Be careful!";
		String feed2 = "Good job! There might have been some roofies in there. The drug Rohypnol can cause anything from amnesia and extreme sedation to seizures, respiratory failure and death. Congrats on not getting roofied!!!";
		String[] feedback = {feed1, feed1, feed2, feed2};
		int[][] point = {{-15, 0, 0, -15}, {-15, 0, 0, -15}, {15, 0, 0, 5}, {15, 0, 0, 5}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "party2");
	}

	private QuestionI makeQuestion7(){
		String questionS = "So you guys get back and things are getting steamy! They look very uncomfortable though...";
		String[] answers = {"A. Who cares! Let's raw-dog it and bail!", "B.  Ask them if they are okay", "C. Meh they aren't saying anything so I guess it's a green light for me!", "D. Let's try to convince them that they will have an unforgettable night."};
		String feed1 = "This is a horrible decision! Not only is it immoral to take advantage of someone who is uncomfortable, but you can also go to jail because this might be condsidered rape. You can also get some crazy STDs and some potentially crazy and/or disturbed children.";
		String feed2 = "How considerate of you! It is good to pause and talk whenever you are not sure what the other person wants, you feel like you're getting mixed signals, or your partner is not responsive.";
		String feed3 = "You should not be trying to pressure them into sex! Whenever you are unsure of your partner's intentions you guys should pause and talk.";
		String[] feedback = {feed1, feed2, feed1, feed3};
		int[][] point = {{0, -5, -5, -5}, {0, 0, 0, 10}, {0, 0, 0, -15}, {0, 0, 0, -5}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "aftersex");
	}
	private QuestionI makeQuestion8(){
		String questionS = "It's a good thing that you asked!  They are 100% down for sex, but ask you to use protection...";
		String[] answers = {"A. Sexy sex time! Let's skip the awkward condom fumbling", "B. Ok great! Time to put on a condom!", "C. They probably told that to previous partners so forget protection", "D. Naw, protection is optional... it feels better without it anyways..."};
		String feed1 = "That is a poor decision! It is very important that you listen to your partner before and during sex. You should use protection even if they claim it's not neccesary because you never know what STD they might have and preventing unwanted pregnancies is very important.";
		String feed2 = "That is a great decision! It is very important that you listen to your partner before and during sex. You should use protection even if they do not say so because you never know what STD they might have and preventing unwanted pregnancies is very important.";
		String[] feedback = {feed1, feed2, feed1, feed1};
		int[][] point = {{0, -8, -7, 0}, {0, 8, 7, 0}, {0, -8, -7, 0}, {0, -8, -7, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "durex");
	}
	private QuestionI makeQuestion9(){
		String questionS = "When you go to put on the condom, what is the first thing that you do?";
		String[] answers = {"A. Try to put the condom on as fast as possible!", "B.  I can't find one so I'll just use a Snickers wrapper...", "C. I can't seem to open the wrapper... I guess I'll just go without it...", "D. Make sure the condom is not expired."};
		String feed1 = "You should check the expiration date first! An expired condom does not protect against STDs and pregnancy as well as unexpired ones.";
		String feed2 = "Surely you must be joking... As delicious as that might sound right now, a Snickers wrapper cannot replace a condom. If you did have condoms, you should have checked the expiration date because they are not a effective after they expire.";
		String feed3 = "You are exposing yourself to the risk of STDs and unwanted pregnancy. It would have been better to find another condom that you could open.";
		String feed4 = "Good job! Checking the expiration date is the first thing that you should do because expired condoms do not work as well as unexpired ones.";
		String[] feedback = {feed1, feed2, feed3, feed4};
		int[][] point = {{0, -3, -2, 0}, {0, -5, -5, 0}, {0, -5, -5, 0}, {0, 5, 5, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "durex");
	}
	private QuestionI makeQuestion10(){
		String questionS = "Oh no! Erectile Dysfunction!";
		String[] answers = {"A. That is impossible! We didnt even drink that much!", "B. This is so embarrassing!", "C. It's probably just stress...", "D. Maybe the two of you are too drunk."};
		String feed1 = "Even though alcohol can cause erectile dysfunction, most cases of erectile dysfunction in college-aged males are caused by stress.";
		String feed2 = "No need to be emarassed. Most cases of erectile dysfunction in college-aged males are caused by stress, not alcohol.";
		String feed3 = "You are correct. Most cases of erectile dysfunction in college-aged males are caused by stress, not alcohol.";
		String feed4 = "That is possible, but most cases of erectile dysfunction in college-aged males are caused by stress.";
		String[] feedback = {feed1, feed2, feed3, feed4};
		int[][] point = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {5, 3, 3, 4}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "sticksolo");
	}
	private QuestionI makeQuestion11(){
		String questionS = "Time for some random sexual trivia! What percentage of people infected with HIV do not know they have it?";
		String[] answers = {"A. 20%", "B. 40%", "C. 100%", "D. 10%"};
		String feed1 = "Good job! It is indeed 20%. This is why it is important to use protection even though your partners says that they don't have HIV.";
		String feed2 = "It is actually 20%. It is important to use protection even if your partner says that they don't have HIV.";
		String[] feedback = {feed1, feed2, feed2, feed2};
		int[][] point = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "sticksolo");
	}
	private QuestionI makeQuestion12(){
		String questionS = "It's your lucky day! Your partner seems very satisfied and wants to try anal sex.";
		String[] answers = {"A. No thanks, we just went to Taco Bell... that CAN'T be a good idea.", "B. Yay! I've always wanted to try anal!", "C. Taco Bell aside, I feel uncomfortable with anal.", "D. I don't want to do it, but I feel pressured so I will. "};
		String feed1 = "That is fine. You should only do things that you are comfortable with.";
		String feed2 = "That is fine. 44% of heterosexual men and 36% of heterosexual women have had anal sex.";
		String feed3 = "That is the wrong reason to do something that you're uncomfortable with. Your partner should not be pressuring you and you should not give into this pressure if they do.";
		String[] feedback = {feed1, feed2, feed1, feed3};
		int[][] point = {{0, 0, 5, 0}, {0, 0, 0, 0}, {0, 0, 5, 0}, {0, 0, -5, -5}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "durex");
	}
	private QuestionI makeQuestion13(){
		String questionS = "You are about to get started. What should you use?";
		String[] answers = {"A. Lubricant and a condom", "B. Lubricant and two condoms", "C. Just a condom, who needs lubricant?", "D. Nutella"};
		String feed1 = "Excellent choice! Lubricant has many benefits, including decreased chance of condom rippage, reduced rate of disease transmission during anal sex, and increased pleasure.";
		String feed2 = "Lubricant has many benefits, including decreased chance of condom rippage, reduced rate of disease transmission during anal sex, and increased pleasure. However, two condoms are less effective that one because they produce friction and increase the chance of condom rippage.";
		String feed3 = "Actually, lubricant has many benefits, including decreased chance of condom rippage, reduced rate of disease transmission during anal sex, and increased pleasure.";
		String feed4 = "Although it is a delicious, nutritious alternative to chocolate sauce, Nutella is probably not what you're looking for in this instance. Condoms and lubricants have many benefits, including decreased chance of condom rippage, reduced rate of disease transmission during anal sex, and increased pleasure.";
		String[] feedback = {feed1, feed2, feed3, feed4};
		int[][] point = {{0, 0, 10, 0}, {0, 0, -5, 0}, {0, 0, -5, 0}, {0, 0, -10, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "nutella");
	}
	private QuestionI makeQuestion14(){
		String questionS = "You two fall on the bed, exhausted from your raucous love-making. What should you do before going to sleep?";
		String[] answers = {"A. Drink some water", "B. Make yourself a nice, post-sex sandwich", "C. Pass out IMMEDIATELY", "D. Go pee"};
		String feed1 = "Good job! Water will help rehydrate you and reduce tomorrow's impending hangover";
		String feed2 = "You should have probably drunk some water. Water will help rehydrate you and reduce tomorrow's impending hangover";
		String feed3 = "Peeing after sex is a good choice. It can reduce the chance of urinary tract infection.";
		String[] feedback = {feed1, feed2, feed2, feed3};
		int[][] point = {{15, 0, 0, 0}, {0, 0, -5, 0}, {0, 0, -5, 0}, {0, 0, 5, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "sticksolo");
	}


	private QuestionI makeQuestion15(){
		String questionS = "You wake up having no idea where you are and with a random naked person next to you. Oh no! You think you might not have used a condom";
		String[] answers = {"A. Who cares! If I leave now, I can still make it to brunch at Hill.", "B. We should probably get some emergency contraception", "C. Ugh, maybe if I just go back to sleep, this whole situation will resolve itself.", "D. Why is there a hole in my pants?"};
		String feed1 = "You should care! There is a huge risk of an STD or pregnancy! You should probably get that checked out.";
		String feed2 = "That's a great choice! Let's get some...";
		String feed3 = "After you wake up the situation does not change...";
		String feed4 = "Focus on the situation!";
		String[] feedback = {feed1, feed2, feed3, feed4};
		int[][] point = {{0, -7, -8, 0}, {0, 15, -5, 0}, {0, -2, -3, 0}, {0, 0, 0, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "remorse");
	}
	private QuestionI makeQuestion16(){
		String questionS = "Where can we get some emergency contraception?";
		String[] answers = {"A. SHS", "B. CVS", "C. Planned Parenthood", "D. All of the above"};
		String feed1 = "Good job! You can get emergency concraception at any of the answers. ";
		String[] feedback = {feed1, feed1, feed1, feed1};
		int[][] point = {{0, 0, 5, 0}, {0, 0, 5, 0}, {0, 0, 5, 0}, {0, 0, 10, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "sticksolo");
	}
	private QuestionI makeQuestion17(){
	    String questionS = "Oh no! You realized that your condom broke last night! Where can we get some emergency contraception?";
	    String[] answers = {"A. SHS", "B. CVS", "C. Planned Parenthood", "D. All of the above"};
	    String feed1 = "Good job! You can get emergency concraception at any of the answers. ";
	    String[] feedback = {feed1, feed1, feed1, feed1};
	    int[][] point = {{0, 0, 5, 0}, {0, 0, 5, 0}, {0, 0, 5, 0}, {0, 0, 10, 0}};
	    QuestionI[] nextQs1 = new QuestionI[4];
	    boolean[] isFinal = {false, false, false, false};
	    return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "sticksolo");
	  }
	private QuestionI makeQuestion18(){
		String questionS = "What if I got an STI?";
		String[] answers = {"A. Let's go to SHS to get a low-cost STI test.", "B. STI? I used spermicide. There's no way of getting STIs with spermicide.", "C. I don't think so...", "D. No way, I have no symptoms of any disease."};
		String feed1 = "Good job! A STI test at the SHS is the best way to help prevent the spread of STIs and to help cure STIs.";
		String feed2 = "That is false! Spermicide only helps with preventing pregnancy, not with preventing STIs. Condoms are the only method of contraception that help prevent STIs too. You should probably get an STI test.";
		String feed3 = "That is very irresponsible! Go get a test!";
		String feed4 = "That is a poor choice! Most people who have STIs show no symptoms.";
		String[] feedback = {feed1, feed2, feed3, feed4};
		int[][] point = {{0, 0, 10, 0}, {0, 0, -10, 0}, {0, 0, -10, 0}, {0, 0, -10, 0}};
		QuestionI[] nextQs1 = new QuestionI[4];
		boolean[] isFinal = {false, false, false, false};
		return new Question(questionS, answers, nextQs1, feedback, point, isFinal, "sticksolo");
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
		String feed1 = "Good job! All of these choices are STIs!";
		String[] feedback = {feed1, feed1, feed1, feed1};
		int[][] point = {{0, 0, 5, 0}, {0, 0, 5, 0}, {0, 0, 5, 0}, {0, 0, 5, 0}};
		QuestionI[] nextq = {null, null, null, null};
		boolean[] isFinal = {true, true, true, true};
		return new Question(questionS, answers, nextq, feedback, point, isFinal, "sticksolo");
	}
}