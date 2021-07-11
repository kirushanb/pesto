package com.pesto.nweatherapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.pesto.nweatherapi.entity.Employee;
import com.pesto.nweatherapi.entity.EmployeeList;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.asm.TypeReference;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {




    public List<Employee> getAllEmployees() throws ParseException {
        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee("1","Michael", "Schumacher",40000, new SimpleDateFormat("dd/MM/yyyy").parse("15/01/2019")));
        employees.add(new Employee("2","Sebastian ", "Vettel",80000, new SimpleDateFormat("dd/MM/yyyy").parse("12/05/2018")));
        employees.add(new Employee("3","Lewis", "Hamilton",38000, new SimpleDateFormat("dd/MM/yyyy").parse("23/04/2020")));
        employees.add(new Employee("4","Max", "Verstappen",40000, new SimpleDateFormat("dd/MM/yyyy").parse("07/10/2020")));
        employees.add(new Employee("5","Daniel", "Ricciardo",58000, new SimpleDateFormat("dd/MM/yyyy").parse("26/01/2021")));


//        Gson gson = new Gson();
//        String json = gson.toJson(employees);
//        try (FileWriter file = new FileWriter("employees.json")) {
//            //We can write any JSONArray or JSONObject instance to the file
//            file.write(json);
//            file.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        employees.stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList())
        return employees;


//        JSONParser jsonParser = new JSONParser();
//
//        try (FileReader reader = new FileReader("employees.json"))
//        {
//
//            Object obj = jsonParser.parse(reader);
//
//            JSONArray employeeList = (JSONArray) obj;
//
//            List<Employee> employeeList1=new ArrayList<>();
//            employeeList.forEach( emp ->{
//                try {
//                    Employee employee=  parseEmployeeObject( (JSONObject) emp );
//                    employeeList1.add(employee);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            }  );
//
//            return employeeList1;
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        } catch (org.json.simple.parser.ParseException e) {
//            e.printStackTrace();
//            return null;
//        }

    }

    private Employee parseEmployeeObject(JSONObject employee) throws ParseException {

        Employee employee1=new Employee();

        String id = (String) employee.get("id");
        employee1.setId(id);

        String firstName = (String) employee.get("firstName");
        employee1.setFirstName(firstName);

        String lastName = (String) employee.get("lastName");
        employee1.setLastName(lastName);

        double salary = (double) employee.get("salary");
        employee1.setSalary(salary);

        String joinDate = (String) employee.get("joinDate");
        employee1.setJoinDate(new SimpleDateFormat("dd/MM/yyyy").parse(joinDate));
       return employee1;
    }


    public List<Employee> addEmployee(Employee employee) throws ParseException {
        List<Employee> employees=getAllEmployees();
        employees.add(employee);
        return employees;
    }

    public Employee getEmployeeById(String id) throws ParseException {
        List<Employee> employeeList = getAllEmployees();
        Employee employee=employeeList.stream().filter(n->n.getId().equals(id)).findAny().get();
        return employee;
    }

    public List<Employee> getEmployeesBySalary(double salary) throws ParseException {
        List<Employee> employeeList = getAllEmployees();
        List<Employee> employeeFiltered=employeeList.stream().filter(n->n.getSalary()==salary).collect(Collectors.toList());
        return employeeFiltered;
    }

    public Employee getEmployeesByName(String name) throws ParseException {
        List<Employee> employeeList = getAllEmployees();
        Employee employee=employeeList.stream().filter(n->n.getFirstName().toLowerCase().equals(name.toLowerCase()) || n.getLastName().toLowerCase().equals(name.toLowerCase())).findAny().get();
        return employee;
    }


    public List<Employee> getEmployeesJoinBetween(String dateFrom, String dateTo) throws ParseException {
        Date startDate=new SimpleDateFormat("dd/MM/yyyy").parse(dateFrom);
        Date endDate=new SimpleDateFormat("dd/MM/yyyy").parse(dateTo);
        List<Employee> employeeList = getAllEmployees();
        List<Employee> employeeFiltered=employeeList.stream().filter(n-> (n.getJoinDate().after(startDate) || n.getJoinDate().equals(startDate)  )&& (n.getJoinDate().before(endDate) || n.getJoinDate().equals(endDate)))
                .collect(Collectors.toList());

        return employeeFiltered;
    }

    public List<Employee> editEmployee(String id, Employee employee) throws ParseException {
        List<Employee> employeeList = getAllEmployees();
        List<Employee> employeeListFiltered=employeeList.stream().filter(n-> !n.getId().equals(id)).collect(Collectors.toList());
        employeeListFiltered.add(employee);
        return employeeListFiltered;
    }

    public List<Employee> deleteEmployee(String id) throws ParseException {
        List<Employee> employeeList = getAllEmployees();
        List<Employee> employeeListFiltered=employeeList.stream().filter(n-> !n.getId().equals(id)).collect(Collectors.toList());
        return employeeListFiltered;
    }






}
