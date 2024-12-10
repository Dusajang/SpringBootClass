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
        
    }
    
    
    
    
}// class
