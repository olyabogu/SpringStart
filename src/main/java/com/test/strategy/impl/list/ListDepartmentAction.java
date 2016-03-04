package com.test.strategy.impl.list;

import com.test.model.Department;
import com.test.service.impl.DepartmentServiceImpl;
import com.test.strategy.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Component
public class ListDepartmentAction implements Action {

    @Autowired
    private DepartmentServiceImpl departmentService;

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {

        List<Department> allDep = departmentService.getAll();
        req.setAttribute("departments", allDep);
        String destination = "/jsp/department/departments.jsp";
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(destination);
        rd.forward(req, resp);
    }
}
