package com.cernelea.employeeModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeData {

    private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
            .buildSessionFactory();

    private static EmployeeData instance = new EmployeeData();

    private EmployeeData() {

    }

    public static EmployeeData getInstance() {
        return instance;
    }

    public void addEmployee(Employee employee) {

        if (employee != null) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            session.close();

        }

    }

    public void removeEmployee(Employee employee) {

        Session session = factory.getCurrentSession();
        if (employee != null) {
            session.beginTransaction();
            session.remove(employee);
            session.getTransaction().commit();
            session.close();

        }

    }

    public void updateEmployee(Employee newEmployee) {

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Employee oldEmployee = session.get(Employee.class, newEmployee.getId());
        oldEmployee.setName(newEmployee.getName());
        oldEmployee.setSalary(newEmployee.getSalary());
        oldEmployee.setJob(newEmployee.getJob());
        oldEmployee.setBirthday(newEmployee.getBirthday());

        session.getTransaction().commit();

        session.close();

    }

    public ObservableList<Employee> employeeList(int sortOrder) {

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<Employee> theEmployees;

        ObservableList<Employee> employeesList = FXCollections.observableArrayList();
        if (sortOrder == 1) {

            theEmployees = session.createQuery("from Employee").list();

            theEmployees.forEach(employee -> {
                employeesList.add(employee);

            });
        } else if (sortOrder == 2) {

            theEmployees = session.createQuery("from Employee order by name asc").list();

            theEmployees.forEach(employee -> {
                employeesList.add(employee);

            });
        } else {

            theEmployees = session.createQuery("from Employee order by name desc").list();

            theEmployees.forEach(employee -> {
                employeesList.add(employee);

            });

        }

        session.close();
        return employeesList;

    }
}
