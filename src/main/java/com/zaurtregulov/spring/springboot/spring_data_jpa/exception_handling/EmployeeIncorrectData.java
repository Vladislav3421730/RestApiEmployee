package com.zaurtregulov.spring.springboot.spring_data_jpa.exception_handling;

public class EmployeeIncorrectData {
    private String message;

    public String getInfo() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message ;
    }

    public EmployeeIncorrectData() {
    }
}
