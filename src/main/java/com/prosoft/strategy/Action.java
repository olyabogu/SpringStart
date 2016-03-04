package com.prosoft.strategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * User: olga
 * Date: 9/27/12
 * Time: 12:34 PM
 */
public interface Action {

    void execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException,ServletException;

}
