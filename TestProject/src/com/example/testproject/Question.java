package com.example.testproject;

public class Question implements QuestionI {

	private String question;
	private String[] answers;
	private QuestionI[] nextQs;
	private String[] feedback;

	public Question (){
		// Initialize question string
		this.question = "Add a question here"; 

		// initialize answer strings
		String defaultAns = "Add answer here";
		this.answers = new String[4];
		for (int i = 0; i < 4; i++) 
			answers[i] = defaultAns;

		// initialize question pointers to the current object
		nextQs = new Question[4];
		for (int i = 0; i < 4; i++)
			nextQs[i] = this;
		
		// initialize feedback
		String defaultfeed = "Well Hello!";
		feedback = new String[4];
		for (int i = 0; i < 4; i++)
			feedback[i] = defaultfeed;
	}

	public Question (String q, String[] answers, QuestionI[] nextQs, String[] feedback){
		// initialize question string
		this.question = q;

		int arrLen = Math.min(Math.min(answers.length, nextQs.length), feedback.length);
		// initialize answer strings
		this.answers = new String[arrLen];
		for (int i = 0; i < arrLen; i++) 
			this.answers[i] = answers[i];

		// initialize question pointers
		this.nextQs = new QuestionI[arrLen];
		for (int i = 0; i < arrLen; i++) 
			this.nextQs[i] = nextQs[i];
		
		// initialize feedback
		this.feedback = new String[arrLen];
		for (int i = 0; i < arrLen; i++)
			this.feedback[i] = feedback[i];
	}

	public Question (String q, String[] answers){
		// initialize question string
		this.question = q;

		// initialize answer strings
		this.answers = new String[answers.length];
		for (int i = 0; i < answers.length; i++) 
			this.answers[i] = answers[i];

		// initialize question pointers
		this.nextQs = new QuestionI[answers.length];
		for (int i = 0; i < answers.length; i++) 
			this.nextQs[i] = this;
		
		// initialize feedback
		String defaultfeed = "Well Hello!";
		feedback = new String[4];
		for (int i = 0; i < 4; i++)
			feedback[i] = defaultfeed;
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

}