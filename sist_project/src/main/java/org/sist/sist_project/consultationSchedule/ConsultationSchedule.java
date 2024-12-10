package org.sist.sist_project.consultationSchedule;

import java.time.LocalDateTime;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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
    
    @NotNull(message = "비밀번호는 필수 입력 값입니다.")
    @Size(max=20, message = "비밀번호는 20자를 초과할 수 없습니다.")
    private String password;
    
    @Nullable
    private String tel;

    @NotNull(message = "휴대폰 번호는 필수 입력 값입니다.")
    @Size(max = 13, message = "휴대폰 번호는 13자를 초과할 수 없습니다.")
    private String cell; // 휴대폰 번호
    
    @NotNull(message = "email은 필수 입력 값입니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @Size(max = 100, message = "이메일은 100자를 초과할 수 없습니다.")
    private String email; // 이메일
    
    

    @NotNull(message = "전공 유무는 필수 입력 값입니다.")
    @Enumerated(EnumType.STRING) // Enum 값을 문자열로 저장
    private MajorStatus majorStatus; // 전공 여부
    
    @NotNull(message = "지점 선택은 필수 입력 값입니다.")
    @Enumerated(EnumType.STRING) // Enum 값을 문자열로 저장
    private CenterType center; // 지점 선택

    @Nullable
    @Enumerated(EnumType.STRING) // Enum 값을 문자열로 저장
    private EduKind eduKind; // 상담 과목 종류
    
    

    @NotNull(message = "예약 일시는 필수 입력 값입니다.")
    private LocalDateTime reservationDateTime; // 예약 일시 (LocalDateTime으로 변경)

    @NotNull
    private String reservationStatus = "확인"; // 예약 상태 기본 값 설정
    @PrePersist
    private void prePersist() {
        if (this.reservationStatus == null) {
            this.reservationStatus = "확인";
        }
    }

    @Column(nullable = false)
    private Boolean isCanceled = false; // 예약 취소 여부 (기본값: false)

    @Size(max = 500, message = "내용은 500자를 초과할 수 없습니다.")
    private String etc; // 예약 관련 내용
    
    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private ConsultationSubject consultationSubject; // 상담 과목
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "center_id", referencedColumnName = "id") // 외래 키 매핑
    private Center center; // 지점 정보
    */
    
}