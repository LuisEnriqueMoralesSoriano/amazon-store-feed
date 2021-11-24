package mx.com.fahorro.apiamzstorefeed.exception;

public class ExceptionInvalidRequest extends Exception {

    public final static String CODE = "001";

    public ExceptionInvalidRequest() {
    }

    public ExceptionInvalidRequest(String message) {
        super(message);
    }

}
