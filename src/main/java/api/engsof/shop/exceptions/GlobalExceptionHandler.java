package api.engsof.shop.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleValidationException(ConstraintViolationException constraintViolationException) {

        Set<ConstraintViolation<?>> violationsSet = constraintViolationException.getConstraintViolations();

        List<String> violationsList = violationsSet.stream().map(ConstraintViolation::getMessage).toList();

        ApiErrorMessage errorMessage = new ApiErrorMessage(HttpStatus.BAD_REQUEST, LocalDateTime.now(), violationsList);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), errorMessage.getHttpStatus());
    }
}
