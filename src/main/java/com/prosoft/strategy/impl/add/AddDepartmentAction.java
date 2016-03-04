package com.prosoft.strategy.impl.add;


import com.prosoft.model.Department;
import com.prosoft.service.impl.DepartmentServiceImpl;
import com.prosoft.strategy.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class AddDepartmentAction implements Action {

    @Autowired
    private DepartmentServiceImpl departmentService;

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{

            String name = req.getParameter("nameDepartment");
            Department department = new Department(name);

            req.setAttribute("department", department);

            try {
                departmentService.add(department);
            } catch (Exception e) {
                req.setAttribute("error", e.getMessage());
                req.getServletContext().getRequestDispatcher("/jsp/department/addDepartment.jsp").forward(req, resp);
                return;
            }

            req.setAttribute("message", "Department was added successful");
            List<Department> allDep = departmentService.getAll();
            req.setAttribute("departments", allDep);
            String destination = "/jsp/department/departments.jsp";
            RequestDispatcher rd = req.getServletContext().getRequestDispatcher(destination);
            rd.forward(req, resp);
        }
    }


