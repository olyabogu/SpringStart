package com.test.exception.departmentException;

/**
 * User: olga
 * Date: 9/20/12
 * Time: 1:43 PM
 */
public class DepartmentException extends Exception {


    public DepartmentException(String message) {
        super(message);
    }

    public DepartmentException(String message, Throwable cause) {
        super(message, cause);
    }
}
