package com.test.dao;


import com.test.model.Department;
import com.test.model.Employer;

import java.util.List;

/**
 * User: olga
 * Date: 9/24/12
 * Time: 2:06 PM
 */
public interface EmployerDAO {
    List<Employer> getAll(Department department);

}
