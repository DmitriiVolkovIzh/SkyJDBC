package sky.project.exceptions;

public class NotFoundInDataBaseException extends RuntimeException {

    public NotFoundInDataBaseException(String msg){
        super(msg);
    }
}
