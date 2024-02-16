package com.nhnacdmemy.resident.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 가족관계 Entity 클래스
 * */
@Entity
@Table(name = "family_relationship")
@Getter
@Setter
public class FamilyRelationship {

    @EmbeddedId
    private Pk pk;

    @MapsId("baseResidentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "base_resident_serial_number")
    private Resident resident; //기준주민일련번호(Resident)


    @Column(name = "family_relationship_code")
    private String familyRelationshipCode; //가족관계코드

    /**
     * 가족관계 복합키 클래스
     * */
    @Embeddable
    @EqualsAndHashCode
    @NoArgsConstructor
    public static class Pk implements Serializable{
        @Column(name = "family_resident_serial_number")
        private Integer familyResidentSerialNumber; //가족주민일련번호
        private Integer baseResidentSerialNumber; //기준주민일련번호
    }
}