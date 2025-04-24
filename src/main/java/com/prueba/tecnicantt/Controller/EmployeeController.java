package com.prueba.tecnicantt.Controller;

import com.prueba.tecnicantt.DTO.EmployeeDTO;
import com.prueba.tecnicantt.Service.EmployeeService;
import com.prueba.tecnicantt.Service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @PostMapping()
    public ResponseEntity save(@RequestBody EmployeeDTO payload) throws Exception{
        ResponseEntity responseEntity;
        try {
            employeeService.saveEmployee(payload);
            responseEntity = new ResponseEntity<>("SUCCESSFULLY_SAVE_EMPLOYEE",HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(new HashMap() {{ put("error",e.getMessage()); } }, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping()
    public ResponseEntity getEmployees(@RequestParam Map params) throws Exception{
        ResponseEntity responseEntity;
        try {
            Map response = employeeService.getEmployees(params);
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(new HashMap() {{ put("error",e.getMessage()); } }, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/get-assigned-offices/{employeeId}")
    public ResponseEntity getAssignedOffices(@PathVariable int employeeId){
        ResponseEntity responseEntity;
        try {
            Map response = employeeService.getAssignedOffices(employeeId);
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(new HashMap() {{ put("error",e.getMessage()); } }, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity delete(@PathVariable int employeeId){
        ResponseEntity responseEntity;
        try {
           employeeService.deleteEmployee(employeeId);
           responseEntity = new ResponseEntity<>("EMPLOYEE_DELETED", HttpStatus.NO_CONTENT);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(new HashMap() {{ put("error",e.getMessage()); } }, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
