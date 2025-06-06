package com.prueba.tecnicantt.Service;

import com.prueba.tecnicantt.DTO.EmployeeDTO;
import com.prueba.tecnicantt.Model.*;
import com.prueba.tecnicantt.Repository.EmployeeOfficeRepository;
import com.prueba.tecnicantt.Repository.OfficeRepository;
import com.prueba.tecnicantt.Repository.UserRepository;
import com.prueba.tecnicantt.Util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final OfficeRepository officeRepository;
    private final UserRepository userRepository;
    private final EmployeeOfficeRepository employeeOfficeRepository;

    @Override
    public void save(EmployeeDTO payload) throws Exception {
        Role role = new Role(Util.EMPLOYEE_ROLE);
        Status status = new Status(Util.CREATED_STATE);
        User user = User.builder()
                .firstName(payload.getFirstName())
                .lastName(payload.getLastName())
                .phone(payload.getPhone())
                .birthdate(payload.getBirthdate())
                .identitynumber(payload.identityNumber)
                .address(payload.address)
                .role(role)
                .status(status)
                .build();
        userRepository.save(user);

        this.assignEmployeeOffice(user, payload.getSelectedOffices(),false);
    }

    @Override
    public Map employees(Map params) throws Exception{
        int roleId = Integer.parseInt(params.get("roleId").toString());
        Map response = new HashMap<>();
        List<Map> users = userRepository.findByRoleId(roleId);
        response.put("list", users);
        return response;
    }

    @Override
    public Map getAssignedOffices(int employeeId) throws Exception {
        Map response = new HashMap<>();
        List<Map<String, Object>> offices = employeeOfficeRepository.findAssignedOfficesByEmployeeId(employeeId);
        List<Integer> officesId = offices.stream()
                .map(m -> m.get("office_id"))
                .filter(Objects::nonNull)
                .map(Object::toString)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        response.put("list", officesId);
        return response;
    }

    @Override
    public void delete(int employeeId) throws Exception{
        Status status = new Status(Util.DELETED_STATE);
        Optional<User> entity = userRepository.findById(employeeId);
        if(entity.isPresent()){
            User user = entity.get();
            user.setStatus(status);
            userRepository.save(user);
        }

        employeeOfficeRepository.deleteByEmployeeId(employeeId);
    }

    @Override
    public void edit(int employeeId, EmployeeDTO payload) throws Exception{
        Optional<User> optionalUser = userRepository.findById(employeeId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            user.setFirstName(payload.getFirstName());
            user.setLastName(payload.getLastName());
            user.setPhone(payload.getPhone());
            user.setBirthdate(payload.getBirthdate());
            user.setIdentitynumber(payload.getIdentityNumber());
            user.setAddress(payload.getAddress());
            userRepository.save(user);

            this.assignEmployeeOffice(user, payload.getSelectedOffices(),true);
        }
    }

    private void assignEmployeeOffice(User user, List<Integer> selectedOffices, boolean isEdit) throws Exception {
        if(isEdit){
            employeeOfficeRepository.deleteByEmployeeId(user.getId());
        }

        for (Integer officeId : selectedOffices) {
            officeRepository.findById(officeId).ifPresent(office -> {
                EmployeeOffice eo = EmployeeOffice.builder()
                        .employee(user)
                        .office(office)
                        .build();
                employeeOfficeRepository.save(eo);
            });
        }

    }
}
