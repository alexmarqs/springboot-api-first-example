package example.api.exception;

import example.api.dto.v1.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Global exception handler.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * Handle api exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorDTO> handleApiException(ApiException ex) {
        log.error("API Exception Handler", ex);
        return buildErrorResponseEntity(ex.getCode(), ex.getStatus(), ex.getMessage());
    }

    /**
     * Handle method argument not valid exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("Validation Exception Handler", ex);
        return buildErrorResponseEntity(ErrorCodesEnum.REQUEST_VALIDATION_ERROR.name(), ErrorCodesEnum.REQUEST_VALIDATION_ERROR.getStatus(), ErrorCodesEnum.REQUEST_VALIDATION_ERROR.getMessage());
    }

    /**
     * Handle default exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleDefaultException(Exception ex) {
        log.error("Generic Exception Handler", ex);
        return buildErrorResponseEntity(ErrorCodesEnum.INTERNAL_ERROR.name(), ErrorCodesEnum.INTERNAL_ERROR.getStatus(), ErrorCodesEnum.INTERNAL_ERROR.getMessage());
    }

    /**
     * Build error response entity response entity.
     *
     * @param code    the code
     * @param status  the status
     * @param message the message
     * @return the response entity
     */
    private ResponseEntity<ErrorDTO> buildErrorResponseEntity(String code, HttpStatus status, String message) {
        ErrorDTO errorDTO = new ErrorDTO()
                .error(message)
                .code(code);
        return new ResponseEntity<>(errorDTO, status);
    }

}
