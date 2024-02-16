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
 * 출생사망신고주민 Entity 클래스
 * */
@Entity
@Table(name = "birth_death_report_resident")
@Getter
@Setter
public class BirthDeathReportResident {
    @EmbeddedId
    private Pk pk;

    @MapsId("residentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident; //주민일련번호(Resident)


    @Column(name = "birth_death_report_date")
    private LocalDate birthDeathReportDate; //출생사망신고일자

    @Column(name = "birth_report_qualifications_code")
    private String birthReportQualificationsCode; //출생신고자격코드

    @Column(name = "death_report_qualifications_code")
    private String deathReportQualificationsCode; //사망신고자격코드

    @Column(name = "email_address")
    private String emailAddress; //이메일주소

    @Column(name = "phone_number")
    private String phoneNumber; //전화번호

    /**
     * 출생사망신고주민 복합키 클래스
     * */
    @Embeddable
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class Pk implements Serializable{
        @Column(name = "birth_death_type_code")
        private String birthDeathTypeCode; //출생사망유형코드
        @Column(name = "report_resident_serial_number")
        private Integer reportResidentSerialNumber; //신고주민일련번호
        private Integer residentSerialNumber; //주민일련번호(Resident)
    }
}