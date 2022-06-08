package com.example.retrofitclient.controller.entity;

public class Department {

    private Long departmentId;
    private String departmentName;
    private String departmentAddy;

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddy='" + departmentAddy + '\'' +
                '}';
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddy() {
        return departmentAddy;
    }

    public void setDepartmentAddy(String departmentAddy) {
        this.departmentAddy = departmentAddy;
    }
}
