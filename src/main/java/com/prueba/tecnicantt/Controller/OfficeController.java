package com.prueba.tecnicantt.Controller;

import com.prueba.tecnicantt.Service.IOfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/office")
@RequiredArgsConstructor
public class OfficeController {

    private final IOfficeService officeService;

    @GetMapping("")
    public ResponseEntity getOffices(){
        ResponseEntity responseEntity;
        try {
            Map response = officeService.getOffices();
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(new HashMap() {{ put("error",e.getMessage()); } }, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  responseEntity;
    }
}
