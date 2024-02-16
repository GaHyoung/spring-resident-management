package com.nhnacdmemy.resident.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * 주민 Entity 클래스
 * */
@Entity
@Table(name = "resident")
@Getter
@Setter
public class Resident {

    @Id
    @Column(name = "resident_serial_number")
    private Integer residentSerialNumber; //주민일련번호


    private String name; //성명

    @Column(name = "resident_registration_number")
    private String residentRegistrationNumber; //주민등록번호

    @Column(name = "gender_code")
    private String genderCode; //성별코드

    @Column(name = "birth_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar birthDate; //출생일시

    @Column(name = "birth_place_code")
    private String birthPlaceCode; //출생장소코드

    @Column(name = "registration_base_address")
    private String registrationBaseAddress; //등록기준지주소

    @Column(name = "death_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar deathDate; //사망일시

    @Column(name = "death_place_code")
    private String deathPlaceCode; //사망장소코드

    @Column(name = "death_place_address")
    private String deathPlaceAddress; //사망장소주소
}