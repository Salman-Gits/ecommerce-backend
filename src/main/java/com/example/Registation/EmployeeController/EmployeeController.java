package com.example.Registation.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Registation.Dto.EmployeeDTO.EmployeeDTO;
import com.example.Registation.Dto.LoginDTO.LoginDTO;
import com.example.Registation.Service.EmployeeService;
import com.example.Registation.response.LoginResponse.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping(path = "/register")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}