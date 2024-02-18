package com.nhnacdmemy.resident.repository;

import com.nhnacdmemy.resident.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {

    @Modifying
    @Query("update FamilyRelationship fr set fr.familyRelationshipCode = ?1 where fr.pk.baseResidentSerialNumber = ?2 and fr.pk.familyResidentSerialNumber = ?3")
    int updateFamilyRelationshipCodeByPk(String familyRelationshipCode, int baseResidentSerialNumber, int familyResidentSerialNumber);

}
