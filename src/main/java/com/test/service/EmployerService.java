package com.test.service;

import com.test.exception.employerException.EmployerException;
import com.test.model.Department;
import com.test.model.Employer;

import java.util.List;

public interface EmployerService extends Service<Employer> {
    List<Employer> getAll(Department department) throws EmployerException;

}
