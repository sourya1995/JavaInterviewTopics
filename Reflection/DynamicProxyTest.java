
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public interface MyInterface1 {

        public void someMethod1();

        public int someMethod2(String s);
    }

    public interface MyInterface2 {

        public void anotherMethod();
    }

    public static void main(String[] args) {
        Class<?> proxyClass = Proxy.getProxyClass(ClassLoader.getSystemClassLoader(), new Class[]{MyInterface1.class, MyInterface2.class});
        Constructor<?> proxyConstructor = proxyClass.getConstructor(InvocationHandler.class);
        InvocationHandler handler = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();

                if (methodName.equals("someMethod")) {
                    System.out.println("some method invoked");
                    return null;
                }

                if (methodName.equals("anotherMethod")) {
                    System.out.println("another method invoked");
                    return null;
                }

                return null;
            }
            MyInterface1 i1 = (DynamicProxyTest.MyInterface1) proxyConstructor.newInstance(handler); 
            MyInterface2 i2 = (DynamicProxyTest.MyInterface2) proxyConstructor.newInstance(handler);
            i1.someMethod1();
            i2.anotherMethod();
            

        }
            
    }
;
}
