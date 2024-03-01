package Enums;

import java.util.function.Predicate;

public class Acceptor implements Predicate<String> {

    NULL
    {

    @Override
    public boolean test(String input) {
        return input == null;
    }

},

    EMPTY{

    @Override
    public boolean test(String input) {
        return input.equals("");
    }

},

    NULL_OR_EMPTY{

    @Override
    public boolean test(String s) {
        return NULL.test(s) || EMPTY.test(s);
    }
};

}
