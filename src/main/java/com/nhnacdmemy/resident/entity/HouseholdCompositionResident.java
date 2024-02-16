package com.nhnacdmemy.resident.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * 세대구성주민 Entity 클래스
 * */
@Entity
@Table(name = "household_composition_resident")
@Getter
@Setter
public class HouseholdCompositionResident {
    @EmbeddedId
    private Pk pk;

    @MapsId("householdSerialNumber")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @MapsId("residentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;


    @Column(name = "report_date")
    @Temporal(TemporalType.DATE)
    private Calendar reportDate; //신고일자

    @Column(name = "household_relationship_code")
    private String householdRelationshipCode; //세대주관계코드

    @Column(name = "household_composition_change_reason_code")
    private String householdCompositionChangeReasonCode; //세대구성변동사유코드

    /**
     * 세대구성주민 복합키 클래스
     * */
    @Embeddable
    @EqualsAndHashCode
    @NoArgsConstructor
    public static class Pk implements Serializable{
        @Column(name = "household_serial_number")
        private Integer householdSerialNumber; //세대일련번호
        @Column(name = "resident_serial_number")
        private Integer residentSerialNumber; //주민일련번호
    }

}
