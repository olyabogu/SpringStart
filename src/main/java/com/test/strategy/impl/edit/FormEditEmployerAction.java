package com.test.strategy.impl.edit;


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
import java.sql.SQLException;

@Component
public class FormEditEmployerAction implements Action {
    @Autowired
    private EmployerServiceImpl employerService;

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {

        Long id = GetterUtils.parseLong(req.getParameter("id"));

        try {
            if (id != null) {
                req.setAttribute("employer", employerService.get(id));
            }
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getServletContext().getRequestDispatcher("/jsp/employee/editEmployer.jsp").forward(req,resp);
            return;
        }
        String destination = "/jsp/employee/editEmployer.jsp";
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(destination);
        rd.forward(req, resp);
    }
}
