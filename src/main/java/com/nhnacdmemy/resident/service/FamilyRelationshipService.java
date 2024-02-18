package com.nhnacdmemy.resident.service;

import com.nhnacdmemy.resident.entity.FamilyRelationship;
import com.nhnacdmemy.resident.entity.Resident;
import com.nhnacdmemy.resident.exception.FamilyRelationshipNotFoundException;
import com.nhnacdmemy.resident.exception.ResidentNotFoundException;
import com.nhnacdmemy.resident.repository.FamilyRelationshipRepository;
import com.nhnacdmemy.resident.repository.ResidentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class FamilyRelationshipService {
    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final ResidentRepository residentRepository;

    @Autowired
    public FamilyRelationshipService(FamilyRelationshipRepository familyRelationshipRepository, ResidentRepository residentRepository) {
        this.familyRelationshipRepository = familyRelationshipRepository;
        this.residentRepository = residentRepository;
    }

//    public FamilyRelationship saveFamilyRelationship(Integer residentSerialNumber, FamilyRelationship familyRelationship) {
//        Resident resident = residentRepository.findById(residentSerialNumber)
//                .orElseThrow(ResidentNotFoundException::new);
//        log.debug("save -> 이름 {}, 기준주민일련번호 {} : ", resident.getName(), resident.getResidentSerialNumber());
//        FamilyRelationship.Pk pk = new FamilyRelationship.Pk();
//
//        familyRelationship.setResident(resident);
//        pk.setBaseResidentSerialNumber(residentSerialNumber);
//        pk.setFamilyResidentSerialNumber(familyRelationship.getPk().getFamilyResidentSerialNumber()); // 수정된 부분
//        pk.setBaseResidentSerialNumber(residentSerialNumber);
//
//        familyRelationship.setPk(pk);


//        return familyRelationshipRepository.save(familyRelationship);
//    }

    public FamilyRelationship saveFamilyRelationship(Integer residentSerialNumber, FamilyRelationship familyRelationship) {
        Resident resident = residentRepository.findById(residentSerialNumber)
                .orElseThrow(ResidentNotFoundException::new);
        log.debug("save -> 이름 {}, 기준주민일련번호 {} : ", resident.getName(), resident.getResidentSerialNumber());
        FamilyRelationship.Pk pk = new FamilyRelationship.Pk();

        familyRelationship.setResident(resident);
        pk.setFamilyResidentSerialNumber(familyRelationship.getPk().getFamilyResidentSerialNumber()); // 수정된 부분
        pk.setBaseResidentSerialNumber(residentSerialNumber);
        familyRelationship.setPk(pk);

        return familyRelationshipRepository.save(familyRelationship);
    }



    public FamilyRelationship updateFamilyRelationshipCode(int baseSerialNumber, int familySerialNumber, String familyRelationshipCode) {
        int updatedRows = familyRelationshipRepository.updateFamilyRelationshipCodeByPk(familyRelationshipCode, baseSerialNumber, familySerialNumber);
        if (updatedRows == 0) {
            throw new FamilyRelationshipNotFoundException();
        }
        return familyRelationshipRepository.findById(new FamilyRelationship.Pk(baseSerialNumber, familySerialNumber))
                .orElseThrow(FamilyRelationshipNotFoundException::new);
    }

    public void deleteFamilyRelationship(int baseResidentSerialNumber, int familyResidentSerialNumber) {
        familyRelationshipRepository.deleteById(new FamilyRelationship.Pk(baseResidentSerialNumber, familyResidentSerialNumber));
    }

}
