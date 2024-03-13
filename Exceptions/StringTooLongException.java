public class StringTooLongException extends RuntimeException {
   public final String value;
   public final int maximumLength;

   public StringTooLongException(String value, int maximumLength) {
      super("String value '" + value + "' is too long. Maximum length is " + maximumLength);
      this.value = value;
      this.maximumLength = maximumLength;
   }

}
