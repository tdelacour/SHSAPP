package com.example.testproject;

public class Question implements QuestionI {

	private String question;
	private String[] answers;
	private QuestionI[] nextQs;
	private String[] feedback;
	private int[][] points;
	private boolean isFinal = false;

	public Question (){
		// Initialize question string
		this.question = "Add a question here"; 
		
		// Initialize default of 4 answers, pointers, feedback, points
		String defaultAns = "Add answer here";
		String defaultfeed = "Well Hello!";
		this.feedback = new String[4];
		this.nextQs = new Question[4];
		this.answers = new String[4];
		this.points = new int[4][3];
		for (int i = 0; i < 4; i++){ 
			answers[i] = defaultAns;
			nextQs[i] = this;
			feedback[i] = defaultfeed;
			points[i][0] = 0;
			points[i][1] = 0;
			points[i][2] = 0;
		}
	}

	public Question (String q, String[] answers, QuestionI[] nextQs, String[] feedback, int[][] points){
		this.question = q;

		int arrLen = Math.min(Math.min(answers.length, nextQs.length), feedback.length);
		
		this.answers = new String[arrLen];
		this.nextQs = new QuestionI[arrLen];
		this.feedback = new String[arrLen];
		this.points = new int[arrLen][3];
		for (int i = 0; i < arrLen; i++){ 
			this.answers[i] = answers[i];
			this.nextQs[i] = nextQs[i];
			this.feedback[i] = feedback[i];
			this.points[i][0] = points[i][0];
			this.points[i][1] = points[i][1];
		}
	}

	public Question (String q, String[] answers, String[] feedback, int[][]points, boolean isFinal){
		this.question = q;
		this.isFinal = isFinal;

		this.answers = new String[answers.length];
		this.nextQs = new QuestionI[answers.length];
		this.feedback = new String[4];
		this.points = new int[answers.length][3];
		for (int i = 0; i < answers.length; i++){ 
			this.answers[i] = answers[i];
			this.nextQs[i] = this;
			this.feedback[i] = feedback[i];
			this.points[i][0] = points[i][0];
			this.points[i][1] = points[i][1];
		}
	}

	public String getQuestion(){
		return question;
	}

	public String[] getAnswers(){
		return this.answers;
	}

	public QuestionI[] getNextQuestions(){
		return this.nextQs;
	}
	
	public String getFeedback(int i){
		i--;
		if (i >= 0 && i < feedback.length){
			return feedback[i];
		}
		else throw new IndexOutOfBoundsException();
	}
	
	public int[] getPoints(int i){
		i--;
		if (i >= 0 && i < points.length){
			return points[i];
		}
		else throw new IndexOutOfBoundsException();
	}
	
	public boolean getFinal(){
		return isFinal;
	}

}