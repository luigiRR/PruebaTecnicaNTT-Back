package com.prueba.tecnicantt.Service;

import com.prueba.tecnicantt.DTO.EmployeeDTO;

import java.util.Map;

public interface IEmployeeService {

    void saveEmployee(EmployeeDTO payload) throws Exception;

    Map getEmployees(Map params) throws Exception;

    Map getAssignedOffices(int employeeId) throws Exception;

    void deleteEmployee(int employeeId) throws Exception;
}
