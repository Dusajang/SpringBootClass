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
    	
    }
    
    
}// class
