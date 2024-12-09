package org.sist.sist_project.consultationSchedule;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsultationScheduleRepository extends JpaRepository<ConsultationSchedule, Integer> {

    // 기관(지점) 선택으로 검색
    List<ConsultationSchedule> findByBranchContaining(String branch);

    // 예약 상태로 검색 (전체, 요청, 변경, 완료, 취소 등)
    List<ConsultationSchedule> findByReservationStatus(String reservationStatus);

    // 등록일 또는 예약일로 검색
    @Query("SELECT cs FROM ConsultationSchedule cs WHERE cs.reservationDateTime BETWEEN :startDate AND :endDate")
    List<ConsultationSchedule> findByDateRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    // 예약자 이름으로 검색
    List<ConsultationSchedule> findByNameContaining(String name);

    // 변경자 이름으로 검색
    @Query("SELECT cs FROM ConsultationSchedule cs WHERE cs.modifiedBy LIKE %:modifier%")
    List<ConsultationSchedule> findByModifier(@Param("modifier") String modifier);

    // 휴대폰 번호로 검색
    List<ConsultationSchedule> findByPhoneContaining(String phone);

    // 이메일로 검색
    List<ConsultationSchedule> findByEmailContaining(String email);

    // 비고로 검색
    @Query("SELECT cs FROM ConsultationSchedule cs WHERE cs.notes LIKE %:notes%")
    List<ConsultationSchedule> findByNotesContaining(@Param("notes") String notes);

    // 예약 상태와 기관(지점)으로 검색
    @Query("SELECT cs FROM ConsultationSchedule cs WHERE cs.reservationStatus = :status AND cs.branch LIKE %:branch%")
    List<ConsultationSchedule> findByStatusAndBranch(@Param("status") String status, @Param("branch") String branch);

    // 예약 상태와 기간으로 검색
    @Query("SELECT cs FROM ConsultationSchedule cs WHERE cs.reservationStatus = :status AND cs.reservationDateTime BETWEEN :startDate AND :endDate")
    List<ConsultationSchedule> findByStatusAndDateRange(@Param("status") String status, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
