package DesignPatterns.Bridge;

import java.util.List;
import java.util.ArrayList;

public class JavaQuestions implements Question {

    private List<String> questions = new ArrayList<String>();
    private int current = 0;

    public JavaQuestions() {
        questions.add("What is a class? ");
        questions.add("What is an interface? ");
        questions.add("What is abstraction? ");
        questions.add(
        "How multiple polymorphism is 
    achieved in java
        ? ");  
        questions.add(
        "How many types of 
    exception handling are there in java ? ");  
        questions.add(
        "Define keyword final for 
    the variable, method, and class in java? ");  
        questions.add("What is an abstract class? ");  
        questions.add("What is multi-threading? ");
    }

    @Override
    public void nextQuestion() {
       if(current <= questions.size() - 1){
            current++;
            System.out.println(current);
       }
    }

    @Override
    public void previousQuestion() {
       if(current > 0){
        current--;
       }
    }

    @Override
    public void newQuestion(String q) {
       
       questions.add(q);
    }

    @Override
    public void deleteQuestion(String q) {
       questions.remove(q);
    }

    @Override
    public void displayQuestion() {
       System.out.println(questions.get(current)); 
       
    }

    @Override
    public void displayAllQuestions() {
       for(String q : questions){
        System.out.println(q);
       }
    }

}
