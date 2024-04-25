package DesignPatterns.Bridge;

public class BridgePatternDemo {

    public static void main(String[] args) {
        QuestionFormat questions = new QuestionFormat("Java ");
        questions.q1 = new JavaQuestions();
        questions.delete("what is the class?");
        questions.display();
        questions.newOne("What is the inheritance? ");

        questions.newOne(
        "How many types of the inheritance 
are there in java ?
        ");  
   questions.displayAll();

    }
}
