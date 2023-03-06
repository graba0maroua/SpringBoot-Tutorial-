package com.gb.Springboottoturial.Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//ctrl alt o : to remove all unused imports
@Component //Class a component of spring whenever the app is started this class is added to the spring container
//it will be in the springs radar
/*We aren't creating any api we are creating a RESTful api so for that we need to use A RESTcontroller not any one*/
@RestController
public class HeyController {
    //method

    /* @RequestMapping annotation is used to map HTTP requests to specific controller methods in a RESTful web service. The @RequestMapping annotation can be used at the class level and/or the method level, and allows developers to define URL patterns and HTTP methods for the mapped requests.
In addition to the basic @RequestMapping annotation, Spring Boot also provides several other annotations that can be used to handle specific types of requests or responses. Some of these annotations include:
- @GetMapping: Used to map HTTP GET requests to a specific controller method.

- @PostMapping: Used to map HTTP POST requests to a specific controller method.

- @PutMapping: Used to map HTTP PUT requests to a specific controller method.

- @DeleteMapping: Used to map HTTP DELETE requests to a specific controller method.

@PatchMapping: Used to map HTTP PATCH requests to a specific controller method.*/
    /* @RequestMapping parameters include:

value or path: Specifies the URL pattern or path that the request mapping should match.

method: Specifies the HTTP method that the request mapping should match, such as GET, POST, PUT, or DELETE.

produces: Specifies the content type of the response produced by the request mapping, such as "text/plain" or "application/json".

consumes: Specifies the content type of the request sent by the client, such as "application/json" or "application/xml".

params: Specifies the request parameters that must be present for the request mapping to be applied.*/
   // instead of writing this => @RequestMapping(value = "/",method = RequestMethod.GET )<= its long asf we do
    @GetMapping("/")
    //whenever we hit the endpoint (/) well get this string in return
    public String helloWorld(){
        return "I LOVE MY LIFE HAHA!!! OOOO";
        /*RESTful's endpoints provide a standardized way for client applications to access and manipulate resources over the internet using HTTP methods such as GET, POST, PUT, and DELETE.*/
    }



}
