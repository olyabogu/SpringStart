package com.prosoft.service;


import com.prosoft.model.Department;

import java.util.List;

/**
 * User: olga
 * Date: 9/24/12
 * Time: 2:10 PM
 */
public interface DepartmentService extends Service<Department> {

    List<Department> getAll();

}
