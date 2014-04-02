package com.example.testproject;
import com.example.testproject.util.QuestionI;

public class Question implements QuestionI {
	
	private String question;
	private String[] answers;
	private QuestionI[] nextQs;
	
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
	}
	
	public Question (String q, String[] answers, QuestionI[] nextQs){
		// initialize question string
		this.question = q;
		
		int arrLen = Math.min(answers.length, nextQs.length);
		// initialize answer strings
		this.answers = new String[arrLen];
		for (int i = 0; i < arrLen; i++) 
			this.answers[i] = answers[i];
		
		// initialize question pointers
		this.nextQs = new QuestionI[arrLen];
		for (int i = 0; i < arrLen; i++) 
			this.nextQs[i] = nextQs[i];
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

}
