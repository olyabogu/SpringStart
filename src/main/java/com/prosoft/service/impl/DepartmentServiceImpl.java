package com.prosoft.service.impl;


import com.prosoft.dao.impl.DepartmentDAOImpl;
import com.prosoft.exception.departmentException.*;
import com.prosoft.model.Department;
import com.prosoft.service.DepartmentService;
import com.prosoft.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAOImpl departmentDAO;


    public DepartmentServiceImpl(){
    }

    public Department get(Long id)  {
        return departmentDAO.get(id);
    }

    public void add(Department department) throws Exception {

        if (department == null) {
            throw new NullDepartmentException();
        }

        if (StringUtils.isEmpty(department.getNameDepartment().trim())) {
            throw new EmptyDepartmentNameException();
        }

        if (departmentDAO.isNameExists(department.getNameDepartment())) {
            throw new NameExistsDepartmentException();
        }

        try {
            departmentDAO.add(department);

        } catch (Exception e) {
            throw new DepartmentException("Can't add department", e);
        }

    }


    public void delete(Department department) throws DepartmentException {

        if (department.getIdDepartment() == null) {
            throw new NullIdDepartmentException();
        }
        try {

            departmentDAO.delete(department);

        } catch (Exception e) {

            throw new DepartmentException("Can't delete department", e);
        }

    }


    public void  edit(Department department) throws Exception {

        if (department == null) {
            throw new NullDepartmentException();
        }

        if (StringUtils.isEmpty(department.getNameDepartment().trim())) {
            throw new EmptyDepartmentNameException();
        }

        if (departmentDAO.isNameExists(department.getNameDepartment())) {
            throw new NameExistsDepartmentException();
        }

        try {

            departmentDAO.edit(department);

        } catch (Exception e) {
            throw new DepartmentException("Can't edit department", e);
        }
    }


    public List<Department> getAll()  {

        return departmentDAO.getAll();
    }



}

