package org.sist.sist_project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
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
        // 1. Create - 새로운 데이터 저장
        ConsultationSchedule schedule = new ConsultationSchedule();
        schedule.setName("김철수");
        schedule.setPhone("010-1234-5678");
        schedule.setEmail("asdfgh1234@naver.com");
        schedule.setIsMajor(true);
        schedule.setCenter("강남교육센터");
        schedule.setSubject("자바 풀스택");
        schedule.setReservationDateTime(LocalDateTime.of(2024, 12, 12, 16, 0));
        schedule.setReservationStatus("확인");
        schedule.setIsConfirmed(true);
        schedule.setIsCanceled(false);
        schedule.setNotes("비전공자인데 괜찮을까요?");

        ConsultationSchedule savedSchedule = consultationScheduleRepository.save(schedule);
        assertNotNull(savedSchedule.getId()); // 저장된 엔티티의 ID가 null이 아닌지 확인

        // 2. Read - 데이터 조회
        List<ConsultationSchedule> schedules = consultationScheduleRepository.findAll();
        assertNotNull(schedules);
        assertEquals(1, schedules.size()); // 저장된 데이터 개수 확인

        // 3. Update - 데이터 수정
        savedSchedule.setSubject("프론트엔드");
        ConsultationSchedule updatedSchedule = consultationScheduleRepository.save(savedSchedule);
        assertEquals("프론트엔드", updatedSchedule.getSubject()); // 수정된 데이터 확인

        // 4. Delete - 데이터 삭제
        consultationScheduleRepository.delete(updatedSchedule);
        List<ConsultationSchedule> remainingSchedules = consultationScheduleRepository.findAll();
        assertEquals(0, remainingSchedules.size()); // 데이터가 삭제되었는지 확인
    }
}
