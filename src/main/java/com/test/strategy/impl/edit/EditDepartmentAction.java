package com.test.strategy.impl.edit;



import com.test.model.Department;
import com.test.service.impl.DepartmentServiceImpl;
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
public class EditDepartmentAction implements Action {

    @Autowired
    private DepartmentServiceImpl departmentService;


    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("nameDepartment");
        Long id = GetterUtils.parseLong(req.getParameter("id"));

        Department department = departmentService.get(id);
        department.setNameDepartment(name);
        req.setAttribute("department", department);

        try {
            departmentService.edit(department);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getServletContext().getRequestDispatcher("/jsp/department/editDepartment.jsp").forward(req,resp);
            return;
        }

        List<Department> allDep = departmentService.getAll();
        req.setAttribute("departments", allDep);
        String destination = "/jsp/department/departments.jsp";
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(destination);
        rd.forward(req, resp);

    }
}
