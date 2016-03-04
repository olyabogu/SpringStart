package com.test.exception.departmentException;

/**
 * User: olga
 * Date: 9/20/12
 * Time: 1:38 PM
 */
public class NullIdDepartmentException extends DepartmentException {

    public NullIdDepartmentException() {
        super("Department id is null");
    }
}
