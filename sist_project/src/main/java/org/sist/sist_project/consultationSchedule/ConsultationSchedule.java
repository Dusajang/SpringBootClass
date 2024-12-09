package org.sist.sist_project.consultationSchedule;

import java.time.LocalDateTime;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "예약자 이름은 필수 입력 값입니다.")
    @Size(max = 50, message = "이름은 50자를 초과할 수 없습니다.")
    private String name; // 예약자 이름
    
    @Nullable
    private String contect;

    @NotNull(message = "휴대폰 번호는 필수 입력 값입니다.")
    @Size(max = 15, message = "휴대폰 번호는 15자를 초과할 수 없습니다.")
    private String phone; // 휴대폰 번호

    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @Size(max = 100, message = "이메일은 100자를 초과할 수 없습니다.")
    private String email; // 이메일

    @NotNull(message = "전공 유무는 필수 입력 값입니다.")
    private Boolean isMajor; // 전공 유무 (true: 전공자, false: 비전공자)

    @NotNull(message = "지점 선택은 필수 입력 값입니다.")
    private String center; // 지점 선택

    @Size(max = 100, message = "상담 과목은 100자를 초과할 수 없습니다.")
    private String subject; // 상담 과목

    @NotNull(message = "예약 일시는 필수 입력 값입니다.")
    private LocalDateTime reservationDateTime; // 예약 일시 (LocalDateTime으로 변경)

    @NotNull(message = "예약 상태는 필수 입력 값입니다.")
    @Size(max = 20, message = "예약 상태는 20자를 초과할 수 없습니다.")
    private String reservationStatus; // 예약 상태 (예: 대기, 완료)

    @Column(nullable = false)
    private Boolean isConfirmed = false; // 예약 확인 여부 (기본값: false)

    @Column(nullable = false)
    private Boolean isCanceled = false; // 예약 취소 여부 (기본값: false)

    @Size(max = 500, message = "내용은 500자를 초과할 수 없습니다.")
    private String notes; // 예약 관련 내용

}