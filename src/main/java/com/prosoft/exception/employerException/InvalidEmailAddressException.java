package com.prosoft.exception.employerException;

/**
 * User: olga
 * Date: 9/24/12
 * Time: 4:49 PM
 */
public class InvalidEmailAddressException extends EmployerException {

    public InvalidEmailAddressException() {
        super("Employer's email address is invalid");
    }
}
