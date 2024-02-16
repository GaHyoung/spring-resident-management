package com.nhnacdmemy.resident.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * 세대전입주소 Entity 클래스
 * */
@Entity
@Table(name = "household_movement_address")
@Getter
@Setter
public class HouseholdMovementAddress {

    @EmbeddedId
    private Pk pk;

    @MapsId("householdSerialNumber")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @Column(name = "house_movement_address")
    private String houseMovementAddress; //전입주소

    @Column(name = "last_address_yn")
    private String lastAddressYn; //최종주소여부

    /**
     * 세대전입주소 복합키 클래스
     * */
    @Embeddable
    @EqualsAndHashCode
    @NoArgsConstructor
    public static class Pk implements Serializable{
        @Column(name = "house_movement_report_date")
        private LocalDate houseMovementReportDate; //전입신고일자
        private Integer householdSerialNumber; //세대일련번호

    }
}