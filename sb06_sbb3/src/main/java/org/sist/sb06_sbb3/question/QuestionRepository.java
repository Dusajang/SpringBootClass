package org.sist.sb06_sbb3.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

													// 연관된 엔티티, pk타입
public interface QuestionRepository extends JpaRepository<Question, Integer>{

	// CRUD 메서드 이미 내장...
	
	Question findBySubject(String subject);
	
	// 제목에 특정 문자열이 포함된 엔티티 검색
	
	// 1. Query Method
	// 메서드 이름으로 쿼리를 자동으로 생성해주는 기능
	// find컬럼명Like
	// find컬럼명Containing
    List<Question> findBySubjectContaining(String keyword);
    
    // 2. @Query
    //@Query("SELECT q FROM Question q WHERE q.subject LIKE %:subject%")
    //List<Question> findBySubjectLike(@Param("subject") String subject);
    
    // 3. 쿼리 DSL
    
    // 2-2 쿼리메서드
    List<Question> findBySubjectLike(String subject);
    
    // WHERE subject=? AND content=?
    Question findBySubjectAndContent(String subject, String content);
    
    
}
