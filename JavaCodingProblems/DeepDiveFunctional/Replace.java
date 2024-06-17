package JavaCodingProblems.DeepDiveFunctional;
import java.util.ArrayList;
import java.util.List;




public class Replace {
    public static List<String> replace(List<String> list, Replacer<String> r){
        List<String> newList = new ArrayList<>();
        for(String s : list){
            newList.add(r.replace(s));
        }
        return newList;
    }
}
