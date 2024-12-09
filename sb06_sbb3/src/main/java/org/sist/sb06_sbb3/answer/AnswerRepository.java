package org.sist.sb06_sbb3.answer;

import java.util.List;

import org.sist.sb06_sbb3.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{

	//@Query("SELECT a FROM ANSWER a WHERE")
	
	List<Answer> findByQuestion(Question question);

}
