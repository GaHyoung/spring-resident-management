package com.nhnacdmemy.resident.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * 세대 Entity 클래스
 * */
@Entity
@Table(name = "household")
@Getter
@Setter
public class Household {

    @Id
    @Column(name = "household_serial_number")
    private Integer householdSerialNumber; //세대일련번호


    @ManyToOne
    @JoinColumn(name = "household_resident_serial_number")
    private Resident resident; //세대주주민일련번호

    @Column(name = "household_composition_date")
    private LocalDate householdCompositionDate; //세대구성일자

    @Column(name = "household_composition_reason_code")
    private String householdCompositionReasonCode; //세대구성사유코드

    @Column(name = "current_house_movement_address")
    private String currentHouseMovementAddress; //현재전입주소
}