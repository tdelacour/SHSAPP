package com.example.testproject;

public interface QuestionI {

	public String getQuestion();	
	public String[] getAnswers();
	public QuestionI[] getNextQuestions();
}