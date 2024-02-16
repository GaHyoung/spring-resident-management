package com.nhnacdmemy.resident.repository;

import com.nhnacdmemy.resident.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {
}
