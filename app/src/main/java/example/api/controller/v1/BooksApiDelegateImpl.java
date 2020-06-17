package example.api.controller.v1;

import example.api.dto.v1.BookDTO;
import example.api.exception.ApiException;
import example.api.exception.ErrorCodesEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/**
 * The type Books api delegate.
 */
@Service
public class BooksApiDelegateImpl implements BooksApiDelegate {

    @Override
    public ResponseEntity<BookDTO> findBookById(String bookId) {
        // test purposes:
        if (!"123".equals(bookId)) {
            throw new ApiException(ErrorCodesEnum.BOOK_NOT_FOUND);
        }

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(123L);
        bookDTO.setTitle("Book title 123 example");
        bookDTO.setSummary("Book summary 123 example");
        bookDTO.setStatus(BookDTO.StatusEnum.RESERVED);

        return ResponseEntity.ok(bookDTO);
    }
}
