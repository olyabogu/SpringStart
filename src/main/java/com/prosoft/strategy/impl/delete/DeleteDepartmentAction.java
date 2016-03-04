package com.prosoft.strategy.impl.delete;

import com.prosoft.model.Department;
import com.prosoft.service.impl.DepartmentServiceImpl;
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
public class DeleteDepartmentAction implements Action {
    @Autowired
    private DepartmentServiceImpl departmentService;

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long id = GetterUtils.parseLong(req.getParameter("id"));

        Department department = departmentService.get(id);

        req.setAttribute("department", department);

        try {
            departmentService.delete(department);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getServletContext().getRequestDispatcher("/jsp/department/deleteDepartment.jsp");
            return;
        }

        List<Department> allDep = departmentService.getAll();
        req.setAttribute("departments", allDep);
        String destination = "/jsp/department/departments.jsp";
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(destination);
        rd.forward(req, resp);

    }
}
