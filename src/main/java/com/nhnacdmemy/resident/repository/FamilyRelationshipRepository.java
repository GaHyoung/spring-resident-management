package com.nhnacdmemy.resident.repository;

import com.nhnacdmemy.resident.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {

    @Modifying
    @Transactional
    @Query("update FamilyRelationship fr " +
            "set fr.familyRelationshipCode = :familyRelationshipCode " +
            "where fr.pk.baseResidentSerialNumber = :baseResidentSerialNumber " +
            "and fr.pk.familyResidentSerialNumber = :familyResidentSerialNumber")
    int updateFamilyRelationshipCodeByPk(@Param("baseResidentSerialNumber")int baseResidentSerialNumber,
                                         @Param("familyResidentSerialNumber")int familyResidentSerialNumber,
                                         @Param("familyRelationshipCode") String familyRelationshipCode);

    @Modifying
    @Transactional
    @Query("delete from FamilyRelationship fr " +
            "where fr.pk.baseResidentSerialNumber = :baseResidentSerialNumber " +
            "and fr.pk.familyResidentSerialNumber = :familyResidentSerialNumber")
    void deleteBySerialNumbers(@Param("baseResidentSerialNumber") int baseResidentSerialNumber,
                               @Param("familyResidentSerialNumber") int familyResidentSerialNumber);
}
