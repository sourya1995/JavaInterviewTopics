package DesignPatterns.Bridge;

public class QuestionManager {
    protected Question q1;
    public String catalog;
    public QuestionManager(String catalog) {
        this.catalog = catalog;
    }

    public void next() {
        q1.nextQuestion();
    }

    public void previous() {
        q1.previousQuestion();
    }

    public void newOne(String question){
        q1.newQuestion(question);
    }

    public void delete(String question){
        q1.deleteQuestion(question);
    }

    public void display(){
        q1.displayQuestion();
    }

    public void displayAll(){
        q1.displayAllQuestions();
    }
}



