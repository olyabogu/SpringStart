package com.test.exception.employerException;

/**
 * User: olga
 * Date: 9/20/12
 * Time: 1:38 PM
 */
public class NullEmployerException extends EmployerException {

    public NullEmployerException() {
        super("Employer didn't defined");
    }
}
