package com.example.testproject;

public class Question implements QuestionI {

	private String question;
	private String[] answers;
	private QuestionI[] nextQs;
	private String[] feedback;
	private int[][] points;
	private boolean[] isFinal;
	private String pic;

	public Question (){
		// Initialize question string
		this.question = "Add a question here"; 
		
		// Initialize default of 4 answers, pointers, feedback, points
		String defaultAns = "Add answer here";
		String defaultfeed = "Well Hello!";
		this.feedback = new String[4];
		this.nextQs = new Question[4];
		this.answers = new String[4];
		this.points = new int[4][4];
		this.pic = "sticksolo";
		for (int i = 0; i < 4; i++){ 
			answers[i] = defaultAns;
			nextQs[i] = this;
			feedback[i] = defaultfeed;
			points[i][0] = 0;
			points[i][1] = 0;
			points[i][2] = 0;
			points[i][3] = 0;
		}
	}

	public Question (String q, String[] answers, QuestionI[] nextQs, 
			String[] feedback, int[][] points, boolean[] isFinal, String pic){
		this.question = q;

		int arrLen = Math.min(Math.min(answers.length, nextQs.length), feedback.length);
		
		this.answers = new String[arrLen];
		this.nextQs = new QuestionI[arrLen];
		this.feedback = new String[arrLen];
		this.points = new int[arrLen][4];
		this.isFinal = new boolean[arrLen];
		this.pic = pic;
		
		for (int i = 0; i < arrLen; i++){ 
			this.isFinal[i] = isFinal[i];
			this.answers[i] = answers[i];
			this.nextQs[i] = nextQs[i];
			this.feedback[i] = feedback[i];
			this.points[i][0] = points[i][0];
			this.points[i][1] = points[i][1];
			this.points[i][2] = points[i][2];
			this.points[i][3] = points[i][3];
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
	
	public boolean[] getFinal(){
		return isFinal;
	}
	
	public String getPic(){
		return pic;
	}
}