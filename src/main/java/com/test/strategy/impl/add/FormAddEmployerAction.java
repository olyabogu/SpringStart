package com.test.strategy.impl.add;

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
public class FormAddEmployerAction implements Action {

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        Long idDepartment = GetterUtils.parseLong(req.getParameter("id"));

        if (idDepartment != null) {
            req.setAttribute("idDepartment", idDepartment);
        }

        String destination = "/jsp/employee/addEmployer.jsp";
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(destination);
        rd.forward(req, resp);
    }
}
