package com.prosoft.dao.impl;


import com.prosoft.dao.DAO;
import com.prosoft.dao.EmployerDAO;
import com.prosoft.model.Department;
import com.prosoft.model.Employer;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployerDAOImpl extends HibernateDaoSupport implements DAO<Employer>, EmployerDAO {

    @Autowired
    public EmployerDAOImpl(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public Employer get(Long id) {
        return (Employer) getHibernateTemplate().get(Employer.class, id);
    }

    public void delete(Employer employer) {
        getHibernateTemplate().delete(employer);
    }

    public void edit(Employer employer) {
        getHibernateTemplate().update(employer);
    }

    public void add(Employer employer) {
        getHibernateTemplate().save(employer);
    }

    @SuppressWarnings("unchecked")
    public List<Employer> getAll(final Department department) {

        return getHibernateTemplate().executeFind(
                new HibernateCallback() {

                    public List<Employer> doInHibernate(Session session) throws HibernateException {
                        Query query = session.createQuery("from Employer e where e.department =:department");
                        query.setParameter("department", department);
                        return query.list();
                    }
                });

    }

    @SuppressWarnings("unchecked")
    private long selectCount(final String email, final Long id) throws Exception {
        return (Long) getHibernateTemplate().execute(
                new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {
                        Query query = session.createQuery("select count(e) from Employer e where e.emailAddress =:email and e.id != :id");
                        query.setParameter("email", email);
                        query.setParameter("id", id);
                        return query.uniqueResult();
                    }
                });

    }

    public boolean isEmailAddressExists(String email, Long id) throws Exception {
        return selectCount(email, id) > 0;
    }


    private long selectCount(final String email) throws Exception {

        return (Long) getHibernateTemplate().execute(
                new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {
                        Query query = session.createQuery("select count(e) from Employer e where e.emailAddress =:email");
                        query.setParameter("email", email);
                        return query.uniqueResult();
                    }

                });
    }

    public boolean isEmailAddressExists(String email) throws Exception {
        return selectCount(email) > 0;
    }
}
