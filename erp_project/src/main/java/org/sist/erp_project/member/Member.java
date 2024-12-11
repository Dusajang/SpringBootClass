package org.sist.erp_project.member;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
@Entity
@Table(name = "member")
public class Member {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 회원번호 자동 증가
    private Long memberId;

    @Column(nullable = false, unique = true) 
    private String username;

    @Column(nullable = false) 
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate; // 생일

    @Column(nullable = false, unique = true)
    private String phone; 

    @Column(unique = true, nullable = false) // 이메일 고유값 설정
    private String email;

    @Column(nullable = false)
    private String gender; // 성별

    private boolean smsOptIn = false; // SMS 수신 여부

    private boolean emailOptIn = false; // 이메일 수신 여부

    @Column(updatable = false) // 가입일은 수정 불가
    private LocalDate joinDate;

    private String status = "ACTIVE"; // 회원 상태

    private Long courseId; // 과정 ID
    
    //@ManyToOne
    //private Course cousere

    private String location; // 소재지

    @Column(nullable = false)
    private String postalCode; // 우편번호

    @Column(nullable = false)
    private String address; // 기본 주소

    @Column(nullable = false)
    private String addressDetail; // 나머지 주소
    
    //        member필드와 연결                  연쇄 저장, 삭제     
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Authority> authorities; // 권한 리스트
    
    @PrePersist
    public void prePersist() {
        if (this.joinDate == null) {
            this.joinDate = LocalDate.now();
        }
    }

}//class
