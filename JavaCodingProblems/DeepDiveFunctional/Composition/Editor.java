package JavaCodingProblems.DeepDiveFunctional.Composition;

import java.util.function.Function;

public class Editor {
    private Editor(){
        throw new AssertionError("Cannot instantiate Editor");
    }

    public static String addIntroduction(String article){
        String articleIntroduction = article + "Introduction ...";
        return articleIntroduction;
    }

    public static String addBody(String article){
        String articleBody = article + "Body ...";
        return articleBody;
    }

    public static String addConclusion(String article){
        String articleConclusion = article + "Conclusion.."; 
        return articleConclusion;
    }

    public static void main(String[] args) {
        Function<String, String> addIntroduction = Editor::addIntroduction;
        Function<String, String> editor = addIntroduction.andThen(Editor::addBody).andThen(Editor::addConclusion);
        String article = editor.apply("Java");
        System.out.println(article);

    }
}
