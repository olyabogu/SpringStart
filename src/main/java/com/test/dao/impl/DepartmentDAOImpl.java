package com.test.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Query;
import org.hibernate.Session;
import com.test.dao.DAO;
import com.test.dao.DepartmentDAO;
import com.test.model.Department;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentDAOImpl extends HibernateDaoSupport implements DAO<Department>, DepartmentDAO {

    @Autowired
    public DepartmentDAOImpl(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }


    public Department get(Long id) {
        return  getHibernateTemplate().get(Department.class, id);
    }

    public void add(Department department) {
        getHibernateTemplate().save(department);
    }

    public void edit(Department department) {
        getHibernateTemplate().update(department);
    }


    public void delete(Department department) {
        getHibernateTemplate().delete(department);
    }
    @SuppressWarnings("unchecked")
    public List<Department> getAll() {
        return getHibernateTemplate().find("from Department");
    }
    @SuppressWarnings("unchecked")
    private long selectCount(final String name) throws Exception {

        return  (Long)getHibernateTemplate().execute(
                new HibernateCallback() {

                    public Object doInHibernate(Session session) throws HibernateException {
                        Query query = session.createQuery("select count(d) from Department d where d.nameDepartment =:name");
                        query.setParameter("name", name);
                        return  query.uniqueResult();
                    }
                });

    }

    public boolean isNameExists(String name) throws Exception {
        return selectCount(name) > 0;
    }

}
