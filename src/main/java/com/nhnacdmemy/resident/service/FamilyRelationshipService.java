package com.nhnacdmemy.resident.service;

import com.nhnacdmemy.resident.entity.FamilyRelationship;
import com.nhnacdmemy.resident.entity.Resident;

import java.util.List;

public interface FamilyRelationshipService {
    List<FamilyRelationship> getAllFamilyRelationship(Integer serialNumber);
    FamilyRelationship saveFamilyRelationship(Integer serialNumber, Integer familySerialNumber, String familyRelationshipCode);
    FamilyRelationship updateFamilyRelationshipCode(int baseSerialNumber, int familySerialNumber, String familyRelationshipCode);
    void deleteFamilyRelationship(int baseResidentSerialNumber, int familyResidentSerialNumber);
}
