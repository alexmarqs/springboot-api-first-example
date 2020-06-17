package example.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * The type Api exception.
 */
@Getter
public class ApiException extends RuntimeException {

    /**
     * The Code.
     */
    private String code;

    /**
     * The Status.
     */
    private HttpStatus status;

    /**
     * Instantiates a new Api exception.
     *
     * @param errorCodesEnum the error codes enum
     */
    public ApiException(ErrorCodesEnum errorCodesEnum) {
        super(errorCodesEnum.getMessage());
        this.code = errorCodesEnum.name();
        this.status = errorCodesEnum.getStatus();
    }
}
