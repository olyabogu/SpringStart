package com.prosoft.strategy;


import com.prosoft.strategy.impl.add.AddDepartmentAction;
import com.prosoft.strategy.impl.add.AddEmployerAction;
import com.prosoft.strategy.impl.add.FormAddDepartmentAction;
import com.prosoft.strategy.impl.add.FormAddEmployerAction;
import com.prosoft.strategy.impl.delete.DeleteDepartmentAction;
import com.prosoft.strategy.impl.delete.DeleteEmployerAction;
import com.prosoft.strategy.impl.delete.FormDeleteDepartmentAction;
import com.prosoft.strategy.impl.delete.FormDeleteEmployerAction;
import com.prosoft.strategy.impl.edit.EditDepartmentAction;
import com.prosoft.strategy.impl.edit.EditEmployerAction;
import com.prosoft.strategy.impl.edit.FormEditDepartmentAction;
import com.prosoft.strategy.impl.edit.FormEditEmployerAction;
import com.prosoft.strategy.impl.list.ListDepartmentAction;
import com.prosoft.strategy.impl.list.ListEmployerAction;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class HibernateServlet extends HttpServlet {

    private static final Map<String, Action> MAP;

    private static final Logger logger = Logger.getLogger(HibernateServlet.class);

    private static final WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();

    static {
        MAP = new HashMap<String, Action>();

        MAP.put("list_department", context.getBean(ListDepartmentAction.class));
        MAP.put("list_employer", context.getBean(ListEmployerAction.class));
        MAP.put("form_add_department",  context.getBean(FormAddDepartmentAction.class));
        MAP.put("form_add_employer",  context.getBean(FormAddEmployerAction.class));
        MAP.put("form_edit_department",  context.getBean(FormEditDepartmentAction.class));
        MAP.put("form_edit_employer",  context.getBean(FormEditEmployerAction.class));
        MAP.put("form_delete_department",  context.getBean(FormDeleteDepartmentAction.class));
        MAP.put("form_delete_employer",  context.getBean(FormDeleteEmployerAction.class));
        MAP.put("add_department",  context.getBean(AddDepartmentAction.class));
        MAP.put("add_employer",  context.getBean(AddEmployerAction.class));
        MAP.put("edit_department",  context.getBean(EditDepartmentAction.class));
        MAP.put("edit_employer",  context.getBean(EditEmployerAction.class));
        MAP.put("delete_department",  context.getBean(DeleteDepartmentAction.class));
        MAP.put("delete_employer",  context.getBean(DeleteEmployerAction.class));
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            Action action = MAP.get(req.getParameter("action"));
            if (action == null) {
                action = MAP.get("list_department");
            }

            action.execute(req, resp);

        } catch (Exception e) {
            logger.error("Catch Exception!!!", e);
        }
    }
}