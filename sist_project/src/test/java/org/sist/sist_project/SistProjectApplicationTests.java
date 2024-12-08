package org.sist.sist_project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.sist.sist_project.consultationSchedule.ConsultationSchedule;
import org.sist.sist_project.consultationSchedule.ConsultationScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SistProjectApplicationTests {

	@Autowired
    private ConsultationScheduleRepository consultationScheduleRepository;

    @Test
    void testJpa() {
        // 더미 데이터 삽입
        ConsultationSchedule schedule1 = new ConsultationSchedule();
        schedule1.setName("홍길동");
        schedule1.setPhone("010-1234-5678");
        schedule1.setReservationDateTime("2024-12-10 10:00");
        schedule1.setIsMajor(true);
        schedule1.setBranch("강남점");
        schedule1.setSubject("100%정부지원▶2//3 개강 AWS와 Docker & Kubernetes를 활용한 Java Full-Stack 개발자 양성과정");
        schedule1.setReservationStatus("예약 완료");
        schedule1.setIsConfirmed(true);
        schedule1.setIsCanceled(false);
        schedule1.setNotes("국민취업지원제도 이용방법도 궁금합니다.");

        ConsultationSchedule schedule2 = new ConsultationSchedule();
        schedule2.setName("김철수");
        schedule2.setPhone("010-8765-4321");
        schedule2.setReservationDateTime("2024-12-11 14:00");
        schedule2.setIsMajor(false);
        schedule2.setBranch("강북점");
        schedule2.setSubject("100%정부지원▶12//11마감AWS 클라우드와 Kafka를 활용한 Java(자바) Full-Stack 개발자 양성과정");
        schedule2.setReservationStatus("대기 중");
        schedule2.setIsConfirmed(false);
        schedule2.setIsCanceled(false);
        schedule2.setNotes("자바 풀스텍 과정이라고 생각하면 될까요??");

        consultationScheduleRepository.save(schedule1);
        consultationScheduleRepository.save(schedule2);

        // 저장된 데이터 확인
        List<ConsultationSchedule> schedules = consultationScheduleRepository.findAll();
        assertEquals(2, schedules.size());

        ConsultationSchedule fetchedSchedule = consultationScheduleRepository.findByNameContaining("홍길동").get(0);
        assertNotNull(fetchedSchedule);
        assertEquals("홍길동", fetchedSchedule.getName());
        assertEquals("서울 지점", fetchedSchedule.getBranch());

        // 예약 상태가 '대기 중'인 스케줄 확인
        List<ConsultationSchedule> pendingSchedules = consultationScheduleRepository.findByReservationStatus("대기 중");
        assertEquals(1, pendingSchedules.size());
        assertEquals("김철수", pendingSchedules.get(0).getName());

        System.out.println("JPA 테스트 성공");
    }
	


	
}// class
