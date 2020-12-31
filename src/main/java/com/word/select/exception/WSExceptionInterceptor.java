package com.word.select.exception;

import com.word.select.exception.domain.WordSelectException;
import com.word.select.exception.domain.WordSelectExceptionSchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
 * Custom exception handler which will return a INTERNAL_SERVER_ERROR whenever there is a failure to read  data from the server
 * For example, when the words_alpha.txt file cannot be read, you will encounter the following error
 * {
 *      "message":"Error occurred while trying to read file from source",
 *      "details":"words_alpha.txt (No such file or directory)"
 * }
 * This class is defined to intercept the REST exception handler so we can present a more meaningful exception structure to the caller
 * */

@ControllerAdvice
public class WSExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WordSelectException.class)
    public final ResponseEntity<Object> handleAllExceptions(WordSelectException ex) {
        logger.debug("Calling handleAllExceptions() method in custom exception handler");
        WordSelectExceptionSchema exceptionResponse =
                new WordSelectExceptionSchema(
                        ex.getMessage(), ex.getDetails());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
