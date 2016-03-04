package com.prosoft.strategy.impl.delete;

import com.prosoft.model.Department;
import com.prosoft.model.Employer;
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
import java.util.List;
@Component
public class DeleteEmployerAction implements Action {
    @Autowired
    private EmployerServiceImpl employerService;

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long id = GetterUtils.parseLong(req.getParameter("id"));
        Employer employer = employerService.get(id);
        req.setAttribute("employer", employer);

        try {
            employerService.delete(employer);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getServletContext().getRequestDispatcher("/jsp/employee/deleteEmployer.jsp");
            return;
        }
        Department department = employer.getDepartment();
        req.setAttribute("idDepartment", employer.getDepartment().getIdDepartment());

        List<Employer> allEmployers = employerService.getAll(department);
        req.setAttribute("employers", allEmployers);
        String destination = "/jsp/employee/employers.jsp";
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(destination);
        rd.forward(req, resp);
    }
}
