package com.gb.Springboottoturial.service;

import com.gb.Springboottoturial.Error.DepartmentNotFoundException;
import com.gb.Springboottoturial.entity.Department;

import java.util.List;

public interface DepartmentService {
   public  Department saveDepartment(Department department);

  public  List<Department> fetchDepartmentlist();

 public  Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);
    public Department updateDepartment(Long departmentId, Department department);
    Department fetchDepartmentByName(String departmentName);
}
