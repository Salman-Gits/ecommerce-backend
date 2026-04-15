package com.example.Registation.Service;
import com.example.Registation.Dto.EmployeeDTO.*;
import com.example.Registation.Dto.LoginDTO.*;
import com.example.Registation.response.LoginResponse.*;
public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);
    LoginResponse loginEmployee(LoginDTO loginDTO);
}