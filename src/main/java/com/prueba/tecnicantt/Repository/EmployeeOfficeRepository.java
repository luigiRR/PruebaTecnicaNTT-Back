package com.prueba.tecnicantt.Repository;

import com.prueba.tecnicantt.Model.EmployeeOffice;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeOfficeRepository extends JpaRepository<EmployeeOffice, Integer> {

    @Query(value = " SELECT eo.employee_id,eo.office_id " +
            "FROM employee_offices eo WHERE eo.employee_id = :employeeId",
            nativeQuery = true)
    List<Map<String, Object>> findAssignedOfficesByEmployeeId(@Param("employeeId") int employeeId);

    @Modifying
    @Transactional
    void deleteByEmployeeId(int employeeId);
}
