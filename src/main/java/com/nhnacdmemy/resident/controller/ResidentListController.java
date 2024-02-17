package com.nhnacdmemy.resident.controller;

import com.nhnacdmemy.resident.entity.Resident;
import com.nhnacdmemy.resident.service.ResidentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
public class ResidentListController {

    private final ResidentListService residentListService;

    @Autowired
    public ResidentListController(ResidentListService residentListService) {
        this.residentListService = residentListService;
    }

    //@RequestBody를 사용하여 요청 본문의 JSON 데이터를 Resident 객체로 매핑
    @PostMapping
    public ResponseEntity<Resident> createResident(@RequestBody Resident resident) {
        Resident savedResident = residentListService.saveResident(resident);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedResident);
    }

    @PutMapping("/{serialNumber}")
    public ResponseEntity<Resident> updateResident(@PathVariable int serialNumber, @RequestBody Resident resident) {
        Resident updatedResident = residentListService.updateResident(serialNumber, resident);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedResident);
    }

}
