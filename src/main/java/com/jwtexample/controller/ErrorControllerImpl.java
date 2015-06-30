package com.jwtexample.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorControllerImpl extends BaseController implements ErrorController {

    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH)
    @ExceptionHandler(value = {Exception.class})
    public String error(Exception e, HttpServletRequest request) {
        String message = e.getCause() != null? e.getCause().getMessage() : "There was an error while processing the request.";
        return buildResponse(Boolean.FALSE, message);
    }
}