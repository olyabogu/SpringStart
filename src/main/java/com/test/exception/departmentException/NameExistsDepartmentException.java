package com.test.exception.departmentException;

/**
 * User: olga
 * Date: 9/20/12
 * Time: 1:39 PM
 */
public class NameExistsDepartmentException extends DepartmentException{

    public NameExistsDepartmentException() {
        super("Department name is already existed");
    }
}
