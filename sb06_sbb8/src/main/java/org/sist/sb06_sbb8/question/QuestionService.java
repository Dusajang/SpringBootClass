package org.sist.sb06_sbb8.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sist.sb06_sbb8.answer.Answer;
import org.sist.sb06_sbb8.exception.DataNotFoundException;
import org.sist.sb06_sbb8.user.SiteUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository; // 주입
	
	// 질문 목록 + 페이징 처리 x
	public List<Question> getList() {
		return this.questionRepository.findAll();
	} //
	
	// id에 해당하는 질문
	public Question getQuestion(Integer id) {
		Optional<Question> oQuestion = this.questionRepository.findById(id);
		if (oQuestion.isPresent()) {
			return oQuestion.get(); // get() : Optional<Question> -> Question 으로 바꾼다.
		} else {
			// 강제로 사용자 정의 예외를 발생시키겠다.
			// exception 패키지 + DataNotFoundException 예외 클래스 추가
			throw new DataNotFoundException("question not found");
		} // if else
	} //
	
	// 질문을 등록
	public void create(String subject, String content, SiteUser user) {
		Question question = new Question();
		question.setSubject(subject);
		question.setContent(content);
		question.setCreateDate(LocalDateTime.now());
		
		question.setAuthor(user); // 작성자
		
		this.questionRepository.save(question);
	} //
	
	/*
	//[1]
	// 페이징 처리 + 목록 / 1번 페이지를 주고 싶으면 0을 줘야된다.
	public Page<Question> getList(int page) {
								// pageNumber : 현재 페이지, pageSize : 한 페이지에 몇개
//		Pageable pageable = PageRequest.of(page, 10);
		
		List<Sort.Order> sorts = new ArrayList<>();
		
		sorts.add(Sort.Order.desc("id"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		return this.questionRepository.findAll(pageable);
	} //
	*/
	
	public void modify(Question question, String subject, String content) {
		question.setSubject(subject);
		question.setContent(content);
		question.setModifyDate(LocalDateTime.now());
		this.questionRepository.save(question);
		
	}
	
	
	// 질문 삭제
	public void delete(Question question) {
        this.questionRepository.delete(question);
    }
	
	// 추천
	public void vote(Question question, SiteUser siteUser) {
		question.getVoter().add(siteUser);
		this.questionRepository.save(question);
	}
	
	/*
	//[2]
	// 페이징 처리 + 검색
	public Page<Question> getList(int page, String kw) {
		
		List<Sort.Order> sorts = new ArrayList<>();
		
		sorts.add(Sort.Order.desc("id"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		
		Specification<Question> spec = search(kw);
		return this.questionRepository.findAll(spec, pageable);
	
	}
	*/
	
	
	/*
	//[2]
	// 페이징 처리 + 검색
	public Page<Question> getList(int page, String kw) {
		
		List<Sort.Order> sorts = new ArrayList<>();
		
		sorts.add(Sort.Order.desc("id"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		
		Specification<Question> spec = search(kw);
		//return this.questionRepository.findAll(spec, pageable);
		
		return this.questionRepository.findAllByKeyword(kw, pageable);
	}
	*/
	
	
	// [3] 페이징 처리 + 검색 + Querydsl
    public Page<Question>  getList(int page, String type, String keyword){  // keyword  
      
       List<Sort.Order> sorts = new ArrayList<>();
       sorts.add(Sort.Order.desc("id"));      
       Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        
       String [] types = type.split("");
       return  this.questionRepository.seachAll(types, keyword, pageable);        
   
    }
	
	
	// Specification
	private Specification<Question> search(String kw) {
		//		익명 클래스 객체 생성해서 반환
        return new Specification<>() { // 인터페이스
            private static final long serialVersionUID = 1L;
            @Override
            public Predicate toPredicate(Root<Question> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
            	// JPA API -> JPQL ==
                query.distinct(true);  // 중복을 제거 
                Join<Question, SiteUser> u1 = q.join("author", JoinType.LEFT);
                Join<Question, Answer> a = q.join("answerList", JoinType.LEFT);
                Join<Answer, SiteUser> u2 = a.join("author", JoinType.LEFT);
                // if로 분기 작업도 가능..
                return cb.or(
                		cb.like(q.get("subject"), "%" + kw + "%"), // 제목 
                        cb.like(q.get("content"), "%" + kw + "%"),      // 내용 
                        cb.like(u1.get("username"), "%" + kw + "%"),    // 질문 작성자 
                        cb.like(a.get("content"), "%" + kw + "%"),      // 답변 내용 
                        cb.like(u2.get("username"), "%" + kw + "%")
                        );   // 답변 작성자 
            }
        };
    }
	
} // class
