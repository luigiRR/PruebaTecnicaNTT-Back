package com.prueba.tecnicantt.Service;

import com.prueba.tecnicantt.Model.Office;
import com.prueba.tecnicantt.Repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OfficeService implements IOfficeService{

    private final OfficeRepository officeRepository;

    @Override
    public Map getOffices() throws Exception {
        Map response = new HashMap<>();
        List<Office> offices = officeRepository.findAll();
        response.put("list", offices);
        return response;
    }
}
