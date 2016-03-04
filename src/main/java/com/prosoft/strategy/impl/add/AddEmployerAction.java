package com.prosoft.strategy.impl.add;

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
public class AddEmployerAction implements Action {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private EmployerServiceImpl employerService;


    public void execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        Long idDepartment = GetterUtils.parseLong(req.getParameter("idDepartment"));
        Department department = departmentService.get(idDepartment);
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String emailAddress = req.getParameter("emailAddress");

        Date hireDay = GetterUtils.parseDate(req.getParameter("hireDay"));

        Integer age = GetterUtils.parseInt(req.getParameter("age"));
        Employer employer = new Employer();
        employer.setDepartment(department);
        employer.setFirstName(firstName);
        employer.setAge(age);
        employer.setEmailAddress(emailAddress);
        employer.setLastName(lastName);
        employer.setHireDay(hireDay);

        req.setAttribute("employer", employer);

        try {
            employerService.add(employer);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.setAttribute("idDepartment", idDepartment);
            req.getRequestDispatcher("/jsp/employee/addEmployer.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("message", "Employer was added successful");
        req.setAttribute("idDepartment", idDepartment);
        List<Employer> allEmployers = employerService.getAll(department);
        req.setAttribute("employers", allEmployers);
        String destination = "/jsp/employee/employers.jsp";
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(destination);
        rd.forward(req, resp);

    }
}
