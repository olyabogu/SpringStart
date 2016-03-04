package com.prosoft.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "department")
public class Department {

    @Column(name = "name_department")
    private String nameDepartment;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_department")
    private Long idDepartment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="department")
    private List<Employer> employersList;

    public Department() {
    }

    public Department(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + nameDepartment + '\'' +
                ", id=" + idDepartment +
                '}';
    }

    public List<Employer> getEmployersList() {
        return employersList;
    }

    public void setEmployersList(List<Employer> employersList) {
        this.employersList = employersList;
    }
}
