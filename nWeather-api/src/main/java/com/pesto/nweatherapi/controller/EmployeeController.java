package com.pesto.nweatherapi.controller;

import com.pesto.nweatherapi.entity.Employee;
import com.pesto.nweatherapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public List<Employee> getAllEmployees() throws ParseException {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<List<Employee>> addEmployee(@RequestBody Employee employee)  {
        try {
            List<Employee> employeeList = employeeService.addEmployee(employee);
            return new ResponseEntity(employeeList, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) throws ParseException {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/salary")
    public List<Employee> getEmployeesBySalary(@RequestParam double salary) throws ParseException {
        return employeeService.getEmployeesBySalary(salary);
    }

    @GetMapping("/name")
    public Employee getEmployeesByName(@RequestParam String name) throws ParseException {
        return employeeService.getEmployeesByName(name);
    }


    @GetMapping("/date")
    public List<Employee> getEmployeesJoinBetween(@RequestParam String dateFrom, @RequestParam String dateTo) throws ParseException {
        return employeeService.getEmployeesJoinBetween(dateFrom, dateTo);
    }

    @PutMapping("/{id}")
    public List<Employee> editEmployee(@PathVariable String id,@RequestBody Employee employee) throws ParseException {
        return employeeService.editEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public List<Employee> deleteEmployee(@PathVariable String id) throws ParseException {
        return employeeService.deleteEmployee(id);
    }



//    @PostMapping("/tutorials")
//    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
//
//    }
//
//    @PutMapping("/tutorials/{id}")
//    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") String id, @RequestBody Tutorial tutorial) {
//
//    }
//
//    @DeleteMapping("/tutorials/{id}")
//    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
//
//    }
}
