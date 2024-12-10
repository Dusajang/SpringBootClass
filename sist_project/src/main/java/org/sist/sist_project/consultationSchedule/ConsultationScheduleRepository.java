package org.sist.sist_project.consultationSchedule;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationScheduleRepository extends JpaRepository<ConsultationSchedule, Integer> {

	
}
