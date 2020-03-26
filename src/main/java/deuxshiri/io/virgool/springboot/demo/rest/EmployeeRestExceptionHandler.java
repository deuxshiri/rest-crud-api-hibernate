package deuxshiri.io.virgool.springboot.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

  // Add an exception handler for CustomerNotFoundException
  @ExceptionHandler
  public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc) {
    var error = new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  // Add another exception handler ... to catch any exception (catch all)
  @ExceptionHandler
  public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc) {
    var error = new EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}
