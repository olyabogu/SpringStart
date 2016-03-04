package com.prosoft.exception.departmentException;

/**
 * User: olga
 * Date: 9/20/12
 * Time: 1:38 PM
 */
public class NullDepartmentException extends DepartmentException {

    public NullDepartmentException() {
        super("Department didn't defined");
    }
}
