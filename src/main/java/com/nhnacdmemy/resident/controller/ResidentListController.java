package com.nhnacdmemy.resident.controller;

import com.nhnacdmemy.resident.entity.Resident;
import com.nhnacdmemy.resident.service.impl.ResidentListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/residents")
public class ResidentListController {

    private final ResidentListServiceImpl residentListService;

    @Autowired
    public ResidentListController(ResidentListServiceImpl residentListService) {
        this.residentListService = residentListService;
    }

    @GetMapping
    public ModelAndView getAllResidents() {
        ModelAndView modelAndView = new ModelAndView("residents");
        List<Resident> residents = residentListService.getAllResidents();
        modelAndView.addObject("residents", residents);
        return modelAndView;
    }

    //@RequestBody를 사용하여 요청 본문의 JSON 데이터를 Resident 객체로 매핑
    @PostMapping
    public ResponseEntity<Resident> saveResident(@RequestBody Resident resident) {
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

    @DeleteMapping("/{serialNumber}")
    public ResponseEntity<String> deleteResident(@PathVariable int serialNumber) {
        residentListService.deleteResident(serialNumber);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(serialNumber + "deleted!");
    }

}
