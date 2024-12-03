package com.example.restapiapplication.error;

import com.example.restapiapplication.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage employeeNotFoundHandler(EmployeeNotFoundException employeeNotFoundException){
             ErrorMessage errorMessage=new ErrorMessage(HttpStatus.NOT_FOUND, employeeNotFoundException.getMessage());
    return errorMessage;
    }

    //creating a Generic Exception for All resources

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage genericExceptionHandler(Exception exception){
        ErrorMessage errorMessage=new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return errorMessage;
    }

}
