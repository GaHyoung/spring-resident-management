package com.nhnacdmemy.resident.controller;

import com.nhnacdmemy.resident.domain.FamilyRelationshipRegisterRequest;
import com.nhnacdmemy.resident.domain.FamilyRelationshipUpdateRequest;
import com.nhnacdmemy.resident.entity.FamilyRelationship;
import com.nhnacdmemy.resident.service.FamilyRelationshipService;
import com.nhnacdmemy.resident.service.impl.ResidentListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/residents")
public class FamilyRelationshipController {
    private final FamilyRelationshipService familyRelationshipService;

    @Autowired
    public FamilyRelationshipController(FamilyRelationshipService familyRelationshipService) {
        this.familyRelationshipService = familyRelationshipService;
    }

    @PostMapping("/{serialNumber}/relationship")
    public ResponseEntity<FamilyRelationship> saveFamilyRelationship(@PathVariable Integer serialNumber, @RequestBody FamilyRelationshipRegisterRequest familyRelationshipRequest) {

        FamilyRelationship savedFamilyRelationship = familyRelationshipService.saveFamilyRelationship(serialNumber, familyRelationshipRequest.getFamilySerialNumber(), familyRelationshipRequest.getFamilyRelationshipCode());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedFamilyRelationship);
    }


    @PutMapping("{baseSerialNumber}/relationship/{familySerialNumber}")
    public ResponseEntity<FamilyRelationship> updateFamilyRelationship(@PathVariable Integer baseSerialNumber,
                                                                       @PathVariable Integer familySerialNumber,
                                                                       @RequestBody FamilyRelationshipUpdateRequest familyRelationshipUpdateRequest) {
        FamilyRelationship updatedFamilyRelationship = familyRelationshipService.updateFamilyRelationshipCode(baseSerialNumber, familySerialNumber, familyRelationshipUpdateRequest.getFamilyRelationshipCode());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedFamilyRelationship);
    }

    @DeleteMapping("/{baseSerialNumber}/relationship/{familySerialNumber}")
    public ResponseEntity<Void> deleteFamilyRelationship(@PathVariable int baseSerialNumber, @PathVariable int familySerialNumber) {
        familyRelationshipService.deleteFamilyRelationship(baseSerialNumber, familySerialNumber);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT) //요청을 성공적으로 처리했지만 응답할 데이터가 없음.
                .build();
    }
}
