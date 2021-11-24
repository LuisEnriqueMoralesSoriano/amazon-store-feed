package mx.com.fahorro.apiamzstorefeed.exception;

public class ExceptionConnectionWebService extends Exception {

    public final static String CODE = "003";

    public ExceptionConnectionWebService() {
    }

    public ExceptionConnectionWebService(String message) {
        super(message);
    }


}
