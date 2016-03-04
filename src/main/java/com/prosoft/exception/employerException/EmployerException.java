package com.prosoft.exception.employerException;

/**
 * User: olga
 * Date: 9/20/12
 * Time: 1:43 PM
 */
public class EmployerException extends Exception {

    public EmployerException(String message) {
        super(message);
    }

    public EmployerException(String message, Throwable cause) {
        super(message, cause);
    }
}
