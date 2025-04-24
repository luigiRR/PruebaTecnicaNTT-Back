package com.prueba.tecnicantt.Service;

import com.prueba.tecnicantt.DTO.EmployeeDTO;

import java.util.Map;

public interface IEmployeeService {

    void save(EmployeeDTO payload) throws Exception;

    Map employees(Map params) throws Exception;

    Map getAssignedOffices(int employeeId) throws Exception;

    void delete(int employeeId) throws Exception;

    void edit(int employeeId, EmployeeDTO payload) throws Exception;
}
