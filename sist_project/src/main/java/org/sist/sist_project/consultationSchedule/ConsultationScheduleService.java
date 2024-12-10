package org.sist.sist_project.consultationSchedule;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ConsultationScheduleService {

    private final ConsultationScheduleRepository consultationScheduleRepository;

    public List<ConsultationSchedule> getAllSchedules() {
        return consultationScheduleRepository.findAll();
    }
}
