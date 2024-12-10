package org.sist.sist_project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.sist.sist_project.consultationSchedule.CenterType;
import org.sist.sist_project.consultationSchedule.ConsultationSchedule;
import org.sist.sist_project.consultationSchedule.ConsultationScheduleRepository;
import org.sist.sist_project.consultationSchedule.EduKind;
import org.sist.sist_project.consultationSchedule.MajorStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SistProjectApplicationTests {

    @Autowired
    private ConsultationScheduleRepository consultationScheduleRepository;

    @Test
    void testInsertConsultationSchedule() {
        // 새로운 예약 생성
        ConsultationSchedule schedule = new ConsultationSchedule();
        schedule.setName("홍길동");
        schedule.setPassword("password123");
        schedule.setTel("02-1234-5678");
        schedule.setCell("010-1234-5678");
        schedule.setEmail("hong@example.com");
        schedule.setMajorStatus(MajorStatus.MAJOR);
        schedule.setCenter(CenterType.GANGNAM);
        schedule.setEduKind(EduKind.EMPLOYED);
        schedule.setReservationDateTime(LocalDateTime.now());
        schedule.setReservationStatus("대기");
        schedule.setIsConfirmed(false);
        schedule.setIsCanceled(false);
        schedule.setEtc("첫 상담 예약");

        // 데이터 저장
        ConsultationSchedule savedSchedule = consultationScheduleRepository.save(schedule);

        // 검증
        assertNotNull(savedSchedule.getId());
        assertEquals("홍길동", savedSchedule.getName());
        assertEquals(MajorStatus.MAJOR, savedSchedule.getMajorStatus());
        assertEquals(CenterType.GANGNAM, savedSchedule.getCenter());
        assertEquals(EduKind.EMPLOYED, savedSchedule.getEduKind());
    }
    
    
    
    
}// class
