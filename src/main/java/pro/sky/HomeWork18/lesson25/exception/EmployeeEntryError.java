package pro.sky.HomeWork18.lesson25.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeEntryError extends RuntimeException{
    public EmployeeEntryError() {
    }

    public EmployeeEntryError(String message) {
        super(message);
    }

    public EmployeeEntryError(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeEntryError(Throwable cause) {
        super(cause);
    }

    public EmployeeEntryError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
