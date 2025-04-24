package com.prueba.tecnicantt.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="employee_offices")
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private User employee;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;
}
