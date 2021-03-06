package com.prosoft.strategy.impl.add;


import com.prosoft.strategy.Action;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * User: olga
 * Date: 9/28/12
 * Time: 2:23 PM
 */

@Component
public class FormAddDepartmentAction implements Action {

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String destination = "/jsp/department/addDepartment.jsp";
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(destination);
        rd.forward(req, resp);

    }
}
