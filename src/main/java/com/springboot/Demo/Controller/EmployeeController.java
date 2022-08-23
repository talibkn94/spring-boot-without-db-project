package com.springboot.Demo.Controller;

import com.springboot.Demo.dto.EmployeeDto;
import com.springboot.Demo.entity.Employee;
import com.springboot.Demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
@Autowired
public EmployeeService employeeService;

    @GetMapping("/welcome")
    public String hello()
    {
        return "Hello SpringBoot";
    }
    @GetMapping("/list")
    public List<EmployeeDto> ls()
    {
        return this.employeeService.getLs();
    }
    @PutMapping("/update/{id}")
    public Object updateData(@PathVariable("id") Integer id, @RequestBody Employee employee){
        //String str= employeeService.updateEmployee(id,employee);
        //if (str=="update")
        //{
            //return "\n"+"Data update successfully";
            return employeeService.updateEmployee(id,employee);
        //}
        //else return "id not found";
    }
    @PostMapping("/addemp")
    public String addData(@RequestBody Employee employee)
        {
            return employeeService.addEmployee(employee);
        }
        @DeleteMapping("/remove/{id}")
    public String removeEmp(@PathVariable ("id") int id)
        {
            return employeeService.DeleteEmployee(id);

        }
    @GetMapping ("/list/{id}")
    public Employee EmpDetail(@PathVariable ("id") int id)
    {
        return employeeService.EmpDetails(id);

    }


}
