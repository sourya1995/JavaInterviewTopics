package JavaCodingProblems.FunctionalStyleProgramming;

public class GasMelonPredicate implements MelonPredicate{

    @Override
    public boolean test(Melon melon) {
        return "gac".equalsIgnoreCase(melon.getType());
    }
    
}
