package com.nhnacdmemy.resident.service;

import com.nhnacdmemy.resident.entity.FamilyRelationship;
import com.nhnacdmemy.resident.exception.FamilyRelationshipNotFoundException;
import com.nhnacdmemy.resident.repository.FamilyRelationshipRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FamilyRelationshipService {
    private final FamilyRelationshipRepository familyRelationshipRepository;

    @Autowired
    public FamilyRelationshipService(FamilyRelationshipRepository familyRelationshipRepository) {
        this.familyRelationshipRepository = familyRelationshipRepository;
    }

    public List<FamilyRelationship> getAllFamilyRelationships() {
        return familyRelationshipRepository.findAll();
    }

    public FamilyRelationship saveFamilyRelationship(FamilyRelationship familyRelationship) {
        FamilyRelationship savedFamilyRelationship = familyRelationshipRepository.save(familyRelationship);
        log.debug("Family relationship 등록: {}", savedFamilyRelationship);
        return savedFamilyRelationship;
    }

    public FamilyRelationship updateFamilyRelationship(FamilyRelationship.Pk pk, FamilyRelationship familyRelationship) {
        FamilyRelationship existingFamilyRelationship = familyRelationshipRepository.findById(pk)
                .orElseThrow(FamilyRelationshipNotFoundException::new);

        if (familyRelationship.getFamilyRelationshipCode() != null) {
            existingFamilyRelationship.setFamilyRelationshipCode(familyRelationship.getFamilyRelationshipCode());
        }

        FamilyRelationship updatedFamilyRelationship = familyRelationshipRepository.save(existingFamilyRelationship);
        log.info("Family relationship 업데이트: {}", updatedFamilyRelationship);
        return updatedFamilyRelationship;
    }

    public void deleteFamilyRelationship(FamilyRelationship.Pk pk) {
        familyRelationshipRepository.deleteById(pk);
    }

}
