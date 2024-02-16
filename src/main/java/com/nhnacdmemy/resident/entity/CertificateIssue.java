package com.nhnacdmemy.resident.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * 증명서발급 Entity 클래스
 * */
@Entity
@Table(name = "certificate_issue")
@Getter
@Setter
public class CertificateIssue {

    @Id
    @Column(name = "certificate_confirmation_number")
    private long certificateConfirmationNumber; //증명서확인번호


    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident; //주민일련번호

    @Column(name = "certificate_type_code")
    private String certificateTypeCode; //증명서유형코드

    @Column(name = "certificate_issue_date")
    @Temporal(TemporalType.DATE)
    private Calendar certificateIssueDate; //증명서발급일자
}
