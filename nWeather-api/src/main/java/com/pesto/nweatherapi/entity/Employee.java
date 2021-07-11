package com.pesto.nweatherapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "employees")
@Getter
@Setter
public class Employee {
    @Id
    public String id;

    public String firstName;
    public String lastName;
    public double  salary;
    public Date joinDate;



    public Employee() {}

    public Employee(String id, String firstName, String lastName,double  salary,Date joinDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
