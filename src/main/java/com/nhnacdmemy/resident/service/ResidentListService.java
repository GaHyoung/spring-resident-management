package com.nhnacdmemy.resident.service;

import com.nhnacdmemy.resident.entity.Resident;
import com.nhnacdmemy.resident.exception.ResidentNotFoundException;

import java.util.List;

public interface ResidentListService {

    List<Resident> getAllResidents();

    Resident saveResident(Resident resident);

    Resident updateResident(int serialNumber, Resident resident) throws ResidentNotFoundException;

    void deleteResident(int serialNumber);
}