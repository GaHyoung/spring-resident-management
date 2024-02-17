package com.nhnacdmemy.resident.repository;

import com.nhnacdmemy.resident.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Resident 엔티티를 관리하는 Repository
 * 주민에 대한 CRUD(Create, Read, Update, Delete) 작업을 수행.
 */
public interface ResidentRepository extends JpaRepository<Resident, Integer> {

    //이름으로 주민 검색
    List<Resident> findByName(String name);

    //주민등럭번호로 주민 검색. 앞자리만 입력해도 검색 가능.
    List<Resident> findByResidentRegistrationNumberStartingWith(String registrationNumber);

}
