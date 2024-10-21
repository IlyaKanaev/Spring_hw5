package org.example.controllers;


import lombok.Data;

@Data
public class TimesheetPageDto {

    private String projectId;
    private String projectName;
    private String id;
    private String minutes;
    private String createdAt;

    public void setEmployeeLastName(String lastName) {
        this.setEmployeeLastName(lastName);
    }

    public void setEmployeeFirstName(String firstName) {
        this.setEmployeeFirstName(firstName);
    }

    public void setEmployeeId(String s) {
        this.setEmployeeId(s);
    }
}
