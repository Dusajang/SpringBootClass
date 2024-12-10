package org.sist.sist_project.consultationSchedule;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ConsultationSubject {

	@Id
    private Integer id; // Primary Key
	
	@NotNull
	private String subject;
}
