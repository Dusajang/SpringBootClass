package org.sist.sist_project.consultationSchedule;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "consultation_schedule")
public class ConsultationSchedule {

    /*
     * 상담 스케줄
     * ID, 예약자, 휴대폰, 예약일시, 전공유무, 지점선택, 상담과목, 예약상태, 예약확인, 예약취소, 내용
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Primary Key

    private String name; // 예약자 이름
    private String phone; // 휴대폰 번호
    private String reservationDateTime; // 예약 일시
    private Boolean isMajor; // 전공 유무
    private String branch; // 지점 선택
    private String subject; // 상담 과목
    private String reservationStatus; // 예약 상태 (예: 대기, 완료)
    private Boolean isConfirmed; // 예약 확인 여부
    private Boolean isCanceled; // 예약 취소 여부
    private String notes; // 예약 관련 내용

}