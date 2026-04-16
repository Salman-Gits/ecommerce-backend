package com.example.Registation.Service.impl;

import com.example.Registation.Dto.EmployeeDTO.*;
import com.example.Registation.Dto.LoginDTO.*;
import com.example.Registation.Entity.Employee;
import com.example.Registation.Repo.EmployeeRepo;
import com.example.Registation.Service.EmployeeService;
import com.example.Registation.response.LoginResponse.*;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// import jakarta.annotation.Resource;
import java.util.Optional;

@Service

public class EmployeeIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee(

                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),

                this.passwordEncoder.encode(employeeDTO.getPassword()));

        employeeRepo.save(employee);

        return employee.getEmployeename();
    }

    EmployeeDTO employeeDTO;

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {

        Employee employee = employeeRepo.findByEmail(loginDTO.getEmail());

        if (employee != null) {

            String rawPassword = loginDTO.getPassword();
            String encodedPassword = employee.getPassword();

            if (passwordEncoder.matches(rawPassword, encodedPassword)) {
                return new LoginResponse("Login Success", true);
            } else {
                return new LoginResponse("Password Not Match", false);
            }

        } else {
            return new LoginResponse("Email not exits", false);
        }
    }

}