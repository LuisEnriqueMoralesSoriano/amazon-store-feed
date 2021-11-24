package mx.com.fahorro.apiamzstorefeed.exception;

public class ExceptionEmptyResultBD extends Exception {

    public final static String CODE = "002";

    public ExceptionEmptyResultBD() {
    }

    public ExceptionEmptyResultBD(String message) {
        super(message);
    }

}
