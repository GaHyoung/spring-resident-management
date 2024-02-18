package com.nhnacdmemy.resident.repository;

import com.nhnacdmemy.resident.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {

    //기준주민일련번호
    List<FamilyRelationship> findByResidentSerialNumber(Long residentSerialNumber);


}
