package org.sist.sist_project.consultationSchedule;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Center {

	@Id
    private Integer id; // Primary Key
	
	@NotNull
	private String center;
	
}
