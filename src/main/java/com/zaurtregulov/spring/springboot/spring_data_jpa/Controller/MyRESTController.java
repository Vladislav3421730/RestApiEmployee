package com.zaurtregulov.spring.springboot.spring_data_jpa.Controller;

import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;
import com.zaurtregulov.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/emp")
    public List<Employee> showAllEmployees()
    {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/emp/{id}")
    public Employee GetEmployee(@PathVariable int id)
    {
        return employeeService.getEmployee(id);
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
    @DeleteMapping(value = "/emp/{id}",produces="application/json" )
    public String deleteEmployee(@PathVariable int id)
    {
        employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return "{\"info\": \"Employee with id "+id+" was deleted\"}";
    }
    @GetMapping("/emp/name/{name}")
    public List<Employee> GetAllEmployeeByName(@PathVariable String name)
    {
       return employeeService.findAllByName(name);
    }

    @GetMapping("/emp/salary/{salary1}/{salary2}")
    public List<Employee> GetAllEmployeeBySalaryIsBetween(@PathVariable int salary1,@PathVariable int salary2)
    {
        return employeeService.findAllBySalaryIsBetween(salary1,salary2);
    }

}
