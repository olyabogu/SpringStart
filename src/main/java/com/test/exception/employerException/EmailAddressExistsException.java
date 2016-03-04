package com.test.exception.employerException;

/**
 * User: olga
 * Date: 9/24/12
 * Time: 4:18 PM
 */
public class EmailAddressExistsException extends EmployerException {
    public EmailAddressExistsException() {
        super("Email address is already existed");
    }
}
