package com.prosoft.exception.employerException;

/**
 * User: olga
 * Date: 9/20/12
 * Time: 1:38 PM
 */
public class NullIdEmployerException extends EmployerException {

    public NullIdEmployerException() {
        super("Employer id is null");
    }
}
