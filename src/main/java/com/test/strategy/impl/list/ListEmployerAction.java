package com.test.strategy.impl.list;



import com.test.model.Employer;
import com.test.service.impl.DepartmentServiceImpl;
import com.test.service.impl.EmployerServiceImpl;
import com.test.strategy.Action;
import com.test.utils.GetterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class ListEmployerAction implements Action {

    @Autowired
    private EmployerServiceImpl employerService;

    @Autowired
    private DepartmentServiceImpl departmentService;

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Long id = GetterUtils.parseLong(req.getParameter("id"));
        req.setAttribute("idDepartment",id);
        List<Employer> allEmployers = employerService.getAll(departmentService.get(id));
        req.setAttribute("employers", allEmployers);
        String destination = "/jsp/employee/employers.jsp";
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(destination);
        rd.forward(req, resp);
    }
}

