package org.sist.sist_project.answer;

import java.util.List;

import org.sist.sist_project.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{

	//@Query("SELECT a FROM ANSWER a WHERE")
	
	List<Answer> findByQuestion(Question question);

}
