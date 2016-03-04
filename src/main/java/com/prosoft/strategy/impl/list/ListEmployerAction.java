package com.prosoft.strategy.impl.list;



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

