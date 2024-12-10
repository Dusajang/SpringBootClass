package org.sist.sist_project.consultationSchedule;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsultationScheduleRepository extends JpaRepository<ConsultationSchedule, Integer> {

	
}
