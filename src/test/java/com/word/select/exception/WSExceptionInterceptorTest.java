package com.word.select.exception;


import com.word.select.exception.domain.WordSelectException;
import com.word.select.exception.domain.WordSelectExceptionSchema;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class WSExceptionInterceptorTest {

    private WordSelectException customException =
            new WordSelectException(
                    "A message", "Some details");

    @InjectMocks WSExceptionInterceptor wsExceptionInterceptor;

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void handleAllExceptionsTest() {
        ResponseEntity<Object> response = wsExceptionInterceptor.handleAllExceptions(customException);
        WordSelectExceptionSchema exceptionResponse =
                new WordSelectExceptionSchema(
                        "A message", "Some details");
        ResponseEntity<Object> expected =
                new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        WordSelectExceptionSchema wordSelectExceptionSchema = (WordSelectExceptionSchema)response.getBody();
        WordSelectExceptionSchema wordSelectExceptionSchemaExpected = (WordSelectExceptionSchema)expected.getBody();


        assertNotNull(response.getBody());
        assertEquals(wordSelectExceptionSchema.getMessage(), wordSelectExceptionSchemaExpected.getMessage());
        assertEquals(wordSelectExceptionSchema.getDetails(), wordSelectExceptionSchemaExpected.getDetails());


    }
}
