package com.nhnacdmemy.resident.service.impl;

import com.nhnacdmemy.resident.entity.FamilyRelationship;
import com.nhnacdmemy.resident.entity.Resident;
import com.nhnacdmemy.resident.exception.FamilyRelationshipNotFoundException;
import com.nhnacdmemy.resident.exception.ResidentNotFoundException;
import com.nhnacdmemy.resident.repository.FamilyRelationshipRepository;
import com.nhnacdmemy.resident.repository.ResidentRepository;
import com.nhnacdmemy.resident.service.FamilyRelationshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService {
    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final ResidentRepository residentRepository;


    public FamilyRelationshipServiceImpl(FamilyRelationshipRepository familyRelationshipRepository, ResidentRepository residentRepository) {
        this.familyRelationshipRepository = familyRelationshipRepository;
        this.residentRepository = residentRepository;
    }


    @Override
    public List<FamilyRelationship> getAllFamilyRelationship(Integer serialNumber) {
        return familyRelationshipRepository.findAll();
    }

    @Override
    public FamilyRelationship saveFamilyRelationship(Integer baseserialNumber, Integer familySerialNumber, String familyRelationshipCode) {
        Resident resident = residentRepository.findById(baseserialNumber)
                .orElseThrow(ResidentNotFoundException::new);
        log.debug("save -> 이름 {}, 기준주민일련번호 {} : ", resident.getName(), resident.getResidentSerialNumber());

        FamilyRelationship familyRelationship = new FamilyRelationship();
        familyRelationship.setResident(resident);
        familyRelationship.setFamilyRelationshipCode(familyRelationshipCode);

        FamilyRelationship.Pk pk = new FamilyRelationship.Pk(familySerialNumber, resident.getResidentSerialNumber());
        familyRelationship.setPk(pk);
        return familyRelationshipRepository.save(familyRelationship);
    }

    @Override
    public FamilyRelationship updateFamilyRelationshipCode(int baseSerialNumber, int familySerialNumber, String familyRelationshipCode) {
        Resident resident = residentRepository.findById(baseSerialNumber)
                .orElseThrow(ResidentNotFoundException::new);
        log.debug("update -> 이름 {}, 기준주민일련번호 {} : ", resident.getName(), familyRelationshipCode);


        int updatedRows = familyRelationshipRepository.updateFamilyRelationshipCodeByPk(baseSerialNumber, familySerialNumber, familyRelationshipCode);
        if (updatedRows == 0) {
            throw new FamilyRelationshipNotFoundException();
        }

        return familyRelationshipRepository.findById(new FamilyRelationship.Pk(familySerialNumber,baseSerialNumber))
                .orElseThrow(FamilyRelationshipNotFoundException::new);
    }

    @Override
    public void deleteFamilyRelationship(int baseSerialNumber, int familySerialNumber) {

        if(!familyRelationshipRepository.findById(new FamilyRelationship.Pk(baseSerialNumber, familySerialNumber)).isPresent()){
            throw new FamilyRelationshipNotFoundException();
        }
        familyRelationshipRepository.deleteBySerialNumbers(baseSerialNumber, familySerialNumber);
    }
}
