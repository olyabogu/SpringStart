package com.prosoft.service.impl;


import com.prosoft.dao.impl.EmployerDAOImpl;
import com.prosoft.exception.employerException.*;
import com.prosoft.model.Department;
import com.prosoft.model.Employer;
import com.prosoft.service.EmployerService;
import com.prosoft.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployerServiceImpl implements EmployerService{

    @Autowired
    private EmployerDAOImpl employerDAO;




    public Employer get(Long id)  {
        return employerDAO.get(id);
    }

    public void add(Employer employer) throws Exception {

        if (employer == null) {
            throw new NullEmployerException();
        }

        if (StringUtils.isEmpty(employer.getLastName())) {
            throw new EmptyEmployerLastNameException();
        }
        if (StringUtils.isEmpty(employer.getFirstName())) {
            throw new EmptyEmployerFirstNameException();
        }
        if (!isValidEmailAddress(employer.getEmailAddress())) {
            throw new InvalidEmailAddressException();
        }

        if (employerDAO.isEmailAddressExists(employer.getEmailAddress())) {
            throw new EmailAddressExistsException();
        }

        try {
            employerDAO.add(employer);

        } catch (Exception e) {

            throw new EmployerException("Can't add employer", e);
        }

    }


    public void delete(Employer employer) throws EmployerException {

        if (employer.getId() == null) {
            throw new NullIdEmployerException();
        }
        try {

            employerDAO.delete(employer);


        } catch (Exception e) {

            throw new EmployerException("Can't delete employer", e);
        }

    }


    public void edit(Employer employer) throws Exception {

        if (employer == null) {
            throw new NullEmployerException();
        }

        if (StringUtils.isEmpty(employer.getLastName())) {
            throw new EmptyEmployerLastNameException();
        }
        if (StringUtils.isEmpty(employer.getFirstName())) {
            throw new EmptyEmployerFirstNameException();
        }
        if (!isValidEmailAddress(employer.getEmailAddress())) {
            throw new InvalidEmailAddressException();
        }

        if (employerDAO.isEmailAddressExists(employer.getEmailAddress(),employer.getId())) {
            throw new EmailAddressExistsException();
        }

        try {

            employerDAO.edit(employer);

        } catch (Exception e) {
            throw new EmployerException("Can't edit employer", e);
        }
    }


    public List<Employer> getAll(Department department) {

        return employerDAO.getAll(department);
    }

    private boolean isValidEmailAddress(String emailAddress) {
        if (StringUtils.isEmpty(emailAddress)) {
            return false;
        }
        String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Boolean b = emailAddress.matches(EMAIL_REGEX);
        return b;
    }
}

