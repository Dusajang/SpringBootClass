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

    // 상담 예약 검색
    public List<ConsultationSchedule> searchConsultations(String searchType, String keyword, String branch,
                                                           String status, LocalDateTime startDate, LocalDateTime endDate) {

        if ("name".equals(searchType) && keyword != null) {
            return consultationScheduleRepository.findByNameContaining(keyword);
        } else if ("modifier".equals(searchType) && keyword != null) {
            return consultationScheduleRepository.findByModifier(keyword);
        } else if ("phone".equals(searchType) && keyword != null) {
            return consultationScheduleRepository.findByPhoneContaining(keyword);
        } else if ("email".equals(searchType) && keyword != null) {
            return consultationScheduleRepository.findByEmailContaining(keyword);
        } else if ("notes".equals(searchType) && keyword != null) {
            return consultationScheduleRepository.findByNotesContaining(keyword);
        } else if (branch != null && status != null) {
            return consultationScheduleRepository.findByStatusAndBranch(status, branch);
        } else if (status != null && startDate != null && endDate != null) {
            return consultationScheduleRepository.findByStatusAndDateRange(status, startDate, endDate);
        } else if (startDate != null && endDate != null) {
            return consultationScheduleRepository.findByDateRange(startDate, endDate);
        } else if (branch != null) {
            return consultationScheduleRepository.findByBranchContaining(branch);
        } else if (status != null) {
            return consultationScheduleRepository.findByReservationStatus(status);
        }

        return consultationScheduleRepository.findAll();
    }
}
