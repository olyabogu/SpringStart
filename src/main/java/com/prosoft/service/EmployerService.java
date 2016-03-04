package com.prosoft.service;

import com.prosoft.exception.employerException.EmployerException;
import com.prosoft.model.Department;
import com.prosoft.model.Employer;

import java.util.List;

public interface EmployerService extends Service<Employer> {
    List<Employer> getAll(Department department) throws EmployerException;

}
