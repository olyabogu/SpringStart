package com.prosoft.exception.employerException;

/**
 * User: olga
 * Date: 9/24/12
 * Time: 4:14 PM
 */
public class EmptyEmployerFirstNameException extends EmployerException {

    public EmptyEmployerFirstNameException() {
        super("Employer's first name is null");
    }

}
