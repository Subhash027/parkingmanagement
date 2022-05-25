package com.grootan.parkingmanagement.exception;

import com.grootan.parkingmanagement.model.domain.UserResponse;
import com.grootan.parkingmanagement.model.entity.ResponeDetails;
import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private String message;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @ExceptionHandler
    public void defaultException(Exception exceptionMessage) {
        log.error(exceptionMessage.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> usernameNotFoundException(UsernameNotFoundException exceptionMessage) {
        message = "Username not found";
        log.error(exceptionMessage.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> credentialException(BadCredentialsException exceptionMessage) {
        message = "Invalid Credentials";
        log.error(exceptionMessage.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> illegalArgumentException(IllegalArgumentException exceptionMessage) {
        message = "Unable to get JWT Token";
        log.error(exceptionMessage.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Object> expiredJwtException(ExpiredJwtException exceptionMessage) {
        message = "JWT Token has expired";
        log.error(exceptionMessage.getMessage());
        return ResponseEntity.status(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS).body(message);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> sqlIntegrityConstraintViolationException(DataIntegrityViolationException exceptionMessage) {
        log.warn(exceptionMessage.getMessage());
        return new ResponseEntity<>(new UserResponse("Username already Exists"), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Object> handleNoContentException(NoContentException exception) {
        message = HttpStatus.NO_CONTENT + exception.getMessage();
        String details = "there is no contant in the file!";
        ResponeDetails responeDetails = new ResponeDetails(LocalDateTime.now(), message, details, HttpStatus.NOT_ACCEPTABLE);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responeDetails);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleActorNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        message = resourceNotFoundException.getMessage();
        String details = "resource not found ";
        ResponeDetails responeDetails = new ResponeDetails(LocalDateTime.now(), message, details, HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responeDetails);
    }

    @ExceptionHandler(VehicleAlreadyCheckedInException.class)
    public ResponseEntity<Object> vehicleAlreadyCheckedInException(VehicleAlreadyCheckedInException vehicleAlreadyCheckedInException) {
        message = vehicleAlreadyCheckedInException.getMessage();
        String details = "parked person";
        ResponeDetails responeDetails = new ResponeDetails(LocalDateTime.now(), message, details, HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responeDetails);
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<Object> vehicleNotFoundException(VehicleNotFoundException exception) {
        message = exception.getMessage();
        String details = "Vehicle not found";
        ResponeDetails responeDetails = new ResponeDetails(LocalDateTime.now(), message, details, HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responeDetails);
    }

    @ExceptionHandler(VehicleAlreadyCheckedOutException.class)
    public ResponseEntity<Object> vehicleAlreadyCheckedOutException(VehicleAlreadyCheckedOutException exception) {
        message = exception.getMessage();
        String details = "already checkout";
        ResponeDetails responeDetails = new ResponeDetails(LocalDateTime.now(), message, details, HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responeDetails);
    }

    @ExceptionHandler(ParkingLotNotFoundException.class)
    public ResponseEntity<Object> parkingLotNotFoundException(ParkingLotNotFoundException exception) {
        message = exception.getMessage();
        String details = "invalid";
        ResponeDetails responeDetails = new ResponeDetails(LocalDateTime.now(), message, details, HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responeDetails);
    }

    @ExceptionHandler(ParkingRecordNotFoundException.class)
    public ResponseEntity<Object> parkingRecordNotFoundException(ParkingRecordNotFoundException exception) {
        message = exception.getMessage();
        String details = "there is no record about what you search";
        ResponeDetails responeDetails = new ResponeDetails(LocalDateTime.now(), message, details, HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responeDetails);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        message = ex.getMessage();
        String details = "MISMATCH OF TYPE";
        ResponeDetails responeDetails = new ResponeDetails(LocalDateTime.now(), message, details, status);
        return ResponseEntity.status(status).body(responeDetails);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        message = ex.getMessage();
        String details = "REQUEST PARAM IS MISSING";
        ResponeDetails responeDetails = new ResponeDetails(LocalDateTime.now(), message, details, status);
        return ResponseEntity.status(status).body(responeDetails);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        message = ex.getMessage();
        String details = "PATH VARIABLE MISSING";
        ResponeDetails responeDetails = new ResponeDetails(LocalDateTime.now(), message, details, status);
        return ResponseEntity.status(status).body(responeDetails);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        message = ex.getMessage();
        String details = "MESSAGE NOT READABLE";
        ResponeDetails responeDetails = new ResponeDetails(LocalDateTime.now(), message, details, status);
        return ResponseEntity.status(status).body(responeDetails);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        message = ex.getMessage();
        String details = "METHOD NOT SUPPORTED";
        ResponeDetails responeDetails = new ResponeDetails(LocalDateTime.now(), message, details, status);
        return ResponseEntity.status(status).body(responeDetails);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        message = ex.getMessage();
        String details = "METHOD NOT SUPPORTED";
        ResponeDetails responeDetails = new ResponeDetails(LocalDateTime.now(), message, details, status);
        return ResponseEntity.status(status).body(responeDetails);
    }
}
