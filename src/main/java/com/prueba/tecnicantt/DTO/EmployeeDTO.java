package com.prueba.tecnicantt.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Builder
@Getter @Setter
public class EmployeeDTO {
    public int id;
    public String address;
    public Date birthdate;
    public String firstName;
    public String lastName;
    public String identityNumber;
    public String phone;
    public List<Integer> selectedOffices;


}
