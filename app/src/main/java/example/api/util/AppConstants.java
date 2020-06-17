package example.api.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * The type App constants.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppConstants {

    /**
     * The constant INTERNAL_ERROR_MESSAGE.
     */
    public static final String INTERNAL_ERROR_MESSAGE = "An unexpected error has occurred";

    /**
     * The constant VALIDATION_ERROR_MESSAGE.
     */
    public static final String VALIDATION_ERROR_MESSAGE = "There are validation errors";

    /**
     * The constant BOOK_NOT_FOUND_MESSAGE.
     */
    public static final String BOOK_NOT_FOUND_MESSAGE = "The book was not found";

}
