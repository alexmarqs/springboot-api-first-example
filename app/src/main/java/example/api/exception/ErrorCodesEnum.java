package example.api.exception;

import example.api.util.AppConstants;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * The enum Error codes enum.
 */
@Getter
public enum ErrorCodesEnum {
    /**
     * Internal error error codes enum.
     */
    INTERNAL_ERROR(AppConstants.INTERNAL_ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR),
    /**
     * Book not found error codes enum.
     */
    BOOK_NOT_FOUND(AppConstants.BOOK_NOT_FOUND_MESSAGE, HttpStatus.NOT_FOUND),
    /**
     * Request validation error error codes enum.
     */
    REQUEST_VALIDATION_ERROR(AppConstants.VALIDATION_ERROR_MESSAGE, HttpStatus.BAD_REQUEST);

    /**
     * The Message.
     */
    private String message;

    /**
     * The Status.
     */
    private HttpStatus status;

    /**
     * Instantiates a new Error codes enum.
     *
     * @param message the message
     * @param status  the status
     */
    ErrorCodesEnum(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

}
