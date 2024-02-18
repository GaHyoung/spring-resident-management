package com.nhnacdmemy.resident.controller;

import com.nhnacdmemy.resident.entity.FamilyRelationship;
import com.nhnacdmemy.resident.service.FamilyRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
public class FamilyRelationshipController {
    private final FamilyRelationshipService familyRelationshipService;

    @Autowired
    public FamilyRelationshipController(FamilyRelationshipService familyRelationshipService) {
        this.familyRelationshipService = familyRelationshipService;
    }

    @PostMapping("/{serialNumber}/relationship")
    public ResponseEntity<FamilyRelationship> saveFamilyRelationship(@PathVariable int serialNumber, @RequestBody FamilyRelationship familyRelationship) {
        FamilyRelationship savedFamilyRelationship = familyRelationshipService.saveFamilyRelationship(serialNumber, familyRelationship);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedFamilyRelationship);
    }


//    @PutMapping("{baseSerialNumber}/relationship/{familySerialNumber}")
//    public ResponseEntity<FamilyRelationship> updateFamilyRelationship(@PathVariable int baseSerialNumber,
//                                                                       @PathVariable int familySerialNumber,
//                                                                       @RequestBody String familyRelationshipCode) {
//        FamilyRelationship updatedFamilyRelationship = familyRelationshipService.updateFamilyRelationshipCode(baseSerialNumber, familySerialNumber, familyRelationshipCode);
//        return new ResponseEntity<>(updatedFamilyRelationship, HttpStatus.OK);
//    }
}
