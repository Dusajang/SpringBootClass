package org.sist.sist_project.consultationSchedule;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsultationScheduleRepository extends JpaRepository<ConsultationSchedule, Integer>{

	//@Query("SELECT a FROM ANSWER a WHERE")
	
	// 예약 상태로 스케줄 검색
    List<ConsultationSchedule> findByReservationStatus(String reservationStatus);

    // 특정 지점에 해당하는 스케줄 검색
    List<ConsultationSchedule> findByBranch(String branch);

    // 예약자 이름으로 스케줄 검색
    List<ConsultationSchedule> findByNameContaining(String name);

    // 예약 일시로 검색
    List<ConsultationSchedule> findByReservationDateTime(String reservationDateTime);

    // 예약 상태가 '취소됨'인 스케줄 검색
    List<ConsultationSchedule> findByIsCanceledTrue();

    // 예약 확인이 안 된 스케줄 검색
    List<ConsultationSchedule> findByIsConfirmedFalse();

    // 전공 유무로 스케줄 검색
    List<ConsultationSchedule> findByIsMajor(Boolean isMajor);

    // 예약자 이름과 휴대폰으로 스케줄 검색
    @Query("SELECT cs FROM ConsultationSchedule cs WHERE cs.name = :name AND cs.phone = :phone")
    Optional<ConsultationSchedule> findByNameAndPhone(@Param("name") String name, @Param("phone") String phone);

    // 특정 지점과 예약 상태에 따른 스케줄 검색
    @Query("SELECT cs FROM ConsultationSchedule cs WHERE cs.branch = :branch AND cs.reservationStatus = :status")
    List<ConsultationSchedule> findByBranchAndStatus(@Param("branch") String branch, @Param("status") String status);

    // 모든 예약 확인이 완료되지 않은 스케줄의 예약자 이름 목록 반환
    @Query("SELECT cs.name FROM ConsultationSchedule cs WHERE cs.isConfirmed = false")
    List<String> findUnconfirmedReservations();

    // 특정 기간의 스케줄 검색 (예: 시작일 ~ 종료일)
    @Query("SELECT cs FROM ConsultationSchedule cs WHERE cs.reservationDateTime BETWEEN :startDate AND :endDate")
    List<ConsultationSchedule> findSchedulesBetweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);
	

}
