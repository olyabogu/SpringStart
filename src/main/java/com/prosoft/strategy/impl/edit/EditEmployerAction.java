package com.prosoft.strategy.impl.edit;


import com.prosoft.model.Department;
import com.prosoft.model.Employer;
import com.prosoft.service.impl.DepartmentServiceImpl;
import com.prosoft.service.impl.EmployerServiceImpl;
import com.prosoft.strategy.Action;
import com.prosoft.utils.GetterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@Component
public class EditEmployerAction implements Action {
    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private EmployerServiceImpl employerService;

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        Long id = GetterUtils.parseLong(req.getParameter("id"));

        Employer employer = employerService.get(id);

        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String emailAddress = req.getParameter("emailAddress");
        Long idDepartment = Long.valueOf(req.getParameter("idDepartment"));
        Department department = departmentService.get(idDepartment);
        Date hireDay = GetterUtils.parseDate(req.getParameter("hireDay"));

        Integer age = GetterUtils.parseInt(req.getParameter("age"));

        employer.setFirstName(firstName);
        employer.setLastName(lastName);
        employer.setEmailAddress(emailAddress);
        employer.setHireDay(hireDay);
        employer.setAge(age);
        employer.setDepartment(department);
        req.setAttribute("employer",employer);
        req.setAttribute("idDepartment",idDepartment);

        try {
            employerService.edit(employer);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.setAttribute("idDepartment",idDepartment);
            req.getServletContext().getRequestDispatcher("/jsp/employee/editEmployer.jsp").forward(req,resp);
            return;
        }

        List<Employer> allEmployers = employerService.getAll(department);
        req.setAttribute("employers", allEmployers);
        String destination = "/jsp/employee/employers.jsp";
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(destination);
        rd.forward(req, resp);
    }
}
