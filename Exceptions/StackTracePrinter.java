import java.io.PrintWriter;
import java.io.StringWriter;

public class StackTracePrinter {
    public static String stackTraceToString(Throwable throwable){
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}

//org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(Throwable) - stacktrace as String
//com.google.common.base.Throwables.getStackTraceAsString(Throwable) - stack trace as string