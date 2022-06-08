package gar.osh.slmtest;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {HttpMediaTypeNotSupportedException.class, HttpMediaTypeNotAcceptableException.class,
        MissingPathVariableException.class, MissingServletRequestParameterException.class,
        ServletRequestBindingException.class, ConversionNotSupportedException.class,
        TypeMismatchException.class, HttpMessageNotReadableException.class, HttpMessageNotWritableException.class,
        MethodArgumentNotValidException.class, MissingServletRequestPartException.class, BindException.class,
        AsyncRequestTimeoutException.class, HttpServerErrorException.InternalServerError.class, NoHandlerFoundException.class,
        HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<Response> handleAllErrors() {
        return ResponseEntity.ok(new Response("Oops, error occured"));
    }
}
