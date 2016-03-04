package com.test.exception.employerException;

/**
 * User: olga
 * Date: 9/20/12
 * Time: 1:46 PM
 */
public class EmptyEmployerLastNameException extends EmployerException {


    public EmptyEmployerLastNameException() {
        super("Employer's last name is null");
    }
}
