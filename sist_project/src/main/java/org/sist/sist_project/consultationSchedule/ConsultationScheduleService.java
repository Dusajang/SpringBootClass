package org.sist.sist_project.consultationSchedule;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ConsultationScheduleService {

    private final ConsultationScheduleRepository consultationScheduleRepository;

    public ConsultationScheduleService(ConsultationScheduleRepository consultationScheduleRepository) {
        this.consultationScheduleRepository = consultationScheduleRepository;
    }

    
}
