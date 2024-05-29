package dio.loja.services.exceptions;

public class UserNotFoundExc extends RuntimeException{

    public UserNotFoundExc(String msg) {
        super(msg);
    }
}
