package com.nhnacdmemy.resident.service;

import com.nhnacdmemy.resident.entity.Resident;
import com.nhnacdmemy.resident.exception.ResidentNotFoundException;
import com.nhnacdmemy.resident.repository.ResidentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ResidetListService {
    private final ResidentRepository residentRepository;

    @Autowired
    public ResidetListService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    public Resident saveResident(Resident resident){
        Resident saveResident = residentRepository.save(resident);
        log.debug("{} resident 등록", resident.getName());
        return saveResident;
    }

    public Resident updateResident(int serialNumber, Resident resident){
        Resident existResident = residentRepository.findById(serialNumber)
                .orElseThrow(ResidentNotFoundException::new);

        if (resident.getDeathDate() != null) {
            existResident.setDeathDate(resident.getDeathDate());
        }
        if (resident.getDeathPlaceCode() != null) {
            existResident.setDeathPlaceCode(resident.getDeathPlaceCode());
        }
        if (resident.getDeathPlaceAddress() != null) {
            existResident.setDeathPlaceAddress(resident.getDeathPlaceAddress());
        }

        Resident updatedResident = residentRepository.save(existResident);
        log.info("{} resident update", existResident.getName());

        return updatedResident;
    }

}