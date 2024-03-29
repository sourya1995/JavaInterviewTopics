import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

public class GenericTest {
    public static void main(String[] args) {
        final Method method = GenericTest.class.getMethod("TestMethod", Map.class);
        final Field field = GenericTest.class.getField("field");
        

        final Type paramType = method.getGenericParameterTypes()[0];
        final Type returnType = method.getGenericReturnType();
        final Type fieldType = field.getGenericType();

    }
}
