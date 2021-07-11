package com.pesto.nweatherapi;

import com.pesto.nweatherapi.entity.Employee;
import com.pesto.nweatherapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class NweatherapiApplication {
    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(  NweatherapiApplication.class, args);
    }

//    @PostConstruct
//    private void init() throws ParseException {
//        employeeRepository.deleteAll();
//
//        // save a couple of customers
//        employeeRepository.save(new Employee("1","Michael", "Schumacher",40000, new SimpleDateFormat("dd/MM/yyyy").parse("15/01/2019")));
//        employeeRepository.save(new Employee("2","Sebastian ", "Vettel",80000, new SimpleDateFormat("dd/MM/yyyy").parse("12/05/2018")));
//
//        // fetch all customers
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (Employee employee : employeeRepository.findAll()) {
//            System.out.println(employee);
//        }
//        System.out.println();
//
//        // fetch an individual customer
//        System.out.println("Customer found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(employeeRepository.findByFirstName("Alice"));
//
//        System.out.println("Customers found with findByLastName('Smith'):");
//        System.out.println("--------------------------------");
//        for (Employee employee : employeeRepository.findByLastName("Smith")) {
//            System.out.println(employee);
//        }

//    }


}

