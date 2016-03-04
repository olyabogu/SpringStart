package com.test.strategy.impl.edit;

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

@Component
public class FormEditDepartmentAction implements Action {

    @Autowired
    private DepartmentServiceImpl departmentService;

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        Long id = GetterUtils.parseLong(req.getParameter("id"));

        try {

            if (id != null) {
                req.setAttribute("department", departmentService.get(id));
            }
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getServletContext().getRequestDispatcher("/jsp/department/editDepartment.jsp").forward(req, resp);
            return;
        }
        String destination = "/jsp/department/editDepartment.jsp";
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(destination);
        rd.forward(req, resp);
    }

}
