package com.gb.Springboottoturial.Error;
import com.gb.Springboottoturial.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
/*
@ControllerAdvice is an annotation used to define a class as a global exception handler for all controllers.
It allows the handling of exceptions in a centralized way, reducing code duplication and making it easier to maintain.
In this specific case, the class RestResponseEntityExceptionHandler is defined as a global exception handler that catches
DepartmentNotFoundException exceptions.

In this specific case, the class RestResponseEntityExceptionHandler is defined as a global exception handler
 that catches DepartmentNotFoundException exceptions.

The @ExceptionHandler annotation is used to specify which exception(s) should be handled by the method. In this case,
the departmentNotFoundException method is called when a DepartmentNotFoundException is thrown.

The departmentNotFoundException method receives two parameters: the DepartmentNotFoundException object,
and a WebRequest object. It creates a custom error message using the ErrorMessage class, which is a custom class that contains
 the error message and the HTTP status code. The method then returns a ResponseEntity object, which is a Spring class that represents
 the entire HTTP response, including the status code, headers, and body.

Overall, this code is used to handle the DepartmentNotFoundException in a centralized way and return a custom error message
with an appropriate HTTP status code.

 */
@ResponseStatus
/*@ResponseStatus:
This annotation is used to specify the HTTP status code that should be returned when an exception is thrown by a controller method.
In this case, it is used to specify that a DepartmentNotFoundException should result in an HTTP 404 (NOT_FOUND) response.
*/
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    /*@ExceptionHandler:
This annotation is used to indicate that a method should handle exceptions of a particular type.
In this case, the @ExceptionHandler annotation is used to indicate that the departmentNotFoundException method should handle exceptions
of type DepartmentNotFoundException.*/
public ResponseEntity<ErrorMessage>  departmentNotFoundException(DepartmentNotFoundException exception, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,
                exception.getMessage());
        /*By using the HttpStatus.NOT_FOUND status code and returning a ResponseEntity with that status code,
        we are indicating that the requested resource (in this case, a department) was not found.*/

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        /*ResponseEntity:

This is a Spring class that represents an HTTP response, including the status code, headers, and body.
It is used in this class to create a response entity that contains the ErrorMessage object and the HTTP status code to be returned in the response.*/
}

}
