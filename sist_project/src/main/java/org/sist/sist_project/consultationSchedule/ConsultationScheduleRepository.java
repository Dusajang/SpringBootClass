package org.sist.sist_project.consultationSchedule;

import java.util.List;

import org.sist.sist_project.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConsultationScheduleRepository extends JpaRepository<ConsultationSchedule, Integer>{

	//@Query("SELECT a FROM ANSWER a WHERE")
	
	

}
