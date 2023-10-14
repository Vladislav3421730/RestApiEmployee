package com.zaurtregulov.spring.springboot.spring_data_jpa.service;


import com.zaurtregulov.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
       return  employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployee(int id) {
        Employee employee=null;
        Optional<Employee> optional=employeeRepository.findById(id);
        if(optional.isPresent())
        {
            employee=optional.get();
        }
        return employee;
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> employeeList=employeeRepository.findAllByName(name);
        return  employeeList;
    }

    @Override
    public List<Employee> findAllBySalaryIsBetween(int min, int max) {
        List<Employee> employeeList=employeeRepository.findAllBySalaryIsBetween(min,max);
        return  employeeList;
    }

}
