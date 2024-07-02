package com.zaurtregulov.spring.springboot.spring_data_jpa.service;


import com.zaurtregulov.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;
import com.zaurtregulov.spring.springboot.spring_data_jpa.exception_handling.NoSuchEmployeeException;
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
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).
                orElseThrow(()->new NoSuchEmployeeException("Employee with id"+id+" not found"));
    }

    public void deleteEmployee(int id) {
      employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        return employeeRepository.findAllByName(name);
    }

    @Override
    public List<Employee> findAllBySalaryIsBetween(int min, int max) {
        return employeeRepository.findAllBySalaryIsBetween(min,max);
    }

}
