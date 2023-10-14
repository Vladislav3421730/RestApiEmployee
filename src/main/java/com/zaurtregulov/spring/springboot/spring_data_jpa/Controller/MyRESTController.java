package com.zaurtregulov.spring.springboot.spring_data_jpa.Controller;

import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;
import com.zaurtregulov.spring.springboot.spring_data_jpa.exception_handling.EmployeeIncorrectData;
import com.zaurtregulov.spring.springboot.spring_data_jpa.exception_handling.NoSuchEmployeeException;
import com.zaurtregulov.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp")
    public List<Employee> showAllEmployees()
    {
        List<Employee> allEmployees=employeeService.getAllEmployees();
        return  allEmployees;
    }
    @GetMapping("/emp/{id}")
    public Employee GetEmployee(@PathVariable int id)
    {
        Employee employee=employeeService.getEmployee(id);
        if(employee==null) throw new NoSuchEmployeeException("Employee with id"+id+"not found");
        return  employee;
    }

    @PostMapping("/emp")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        employeeService.saveEmployee(employee);
        return employee;
    }
   @PutMapping("/emp")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        Employee employee=employeeService.getEmployee(id);
        if(employee==null) throw new NoSuchEmployeeException("Employee with id"+id+"not found");
        employeeService.deleteEmployee(id);
        return "Employee with id "+id+" was deleted";
    }
    @GetMapping("/emp/name/{name}")
    public  List<Employee> GetAllEmployeeByName(@PathVariable String name)
    {
        List<Employee> list=employeeService.findAllByName(name);
        return  list;
    }

    @GetMapping("/emp/salary/{salary1}/{salary2}")
    public List<Employee> GetAllEmployeeBySalaryIsBetween(@PathVariable int salary1,@PathVariable int salary2)
    {
        List<Employee> list=employeeService.findAllBySalaryIsBetween(salary1,salary2);
        if(list.isEmpty()) throw new NoSuchEmployeeException("Нет работников с таким диапазоном зарплат");
        return list;
    }

}
