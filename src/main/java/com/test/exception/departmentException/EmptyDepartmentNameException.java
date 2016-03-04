package com.test.exception.departmentException;

/**
 * User: olga
 * Date: 9/20/12
 * Time: 1:46 PM
 */
public class EmptyDepartmentNameException extends DepartmentException {


    public EmptyDepartmentNameException() {
        super("Department name is null");
    }
}
