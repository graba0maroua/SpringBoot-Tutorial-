package com.gb.Springboottoturial.Controller;

import com.gb.Springboottoturial.Error.DepartmentNotFoundException;
import com.gb.Springboottoturial.entity.Department;
import com.gb.Springboottoturial.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import java.util.List;
import org.slf4j.LoggerFactory;

/*In Spring MVC framework, a Controller is a class that handles user requests and returns an appropriate response.
 It is responsible for processing user input, performing business logic, and returning a view or JSON response.

A Controller typically consists of methods annotated with @RequestMapping, which maps a request URL and method to a specific method in
 the controller. The method then processes the request, performs necessary actions, and returns a response, which could be a view or a JSONresponse.*/
@RestController
public class DepartmentController {
    @Autowired
private DepartmentService departmentService ;
    /*By doing this, we can call methods defined in the DepartmentService interface from the DepartmentController class,
     without having to instantiate an object of DepartmentServiceImpl or implement the methods ourselves.
     This is because Spring provides an implementation of the DepartmentService interface at runtime, which it can then inject into the departmentService field.*/
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

@PostMapping("/departments")
    public Department saveDepartment (@Valid @RequestBody Department department) {
    LOGGER.info("inside saveDepartment of DepartmentController ");
/*The @RequestBody annotation on the Department parameter tells Spring to deserialize the JSON request body into a Department object.
In other words, when a client sends a POST request with a JSON payload containing a Department object,
Spring will automatically deserialize the JSON payload into a Department object and pass it to the saveDepartment() method as a parameter.*/
return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
public List<Department> fetchDepartmentlist(){

        LOGGER.info("inside fetchDepartment of DepartmentController ");
    return departmentService.fetchDepartmentlist();
}

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }
 @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
    departmentService.deleteDepartmentById(departmentId);
    return "deleted ";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
