package com.kafkaproducer.example.dto;

public class User {
    private String name;
    private String dept;
    private String message;
    private Long salary;

    public User(String name, String dept, String message, Long salary) {
        this.name = name;
        this.dept = dept;
        this.message = message;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
