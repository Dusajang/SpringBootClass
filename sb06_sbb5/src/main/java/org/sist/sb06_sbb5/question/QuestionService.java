package org.sist.sb06_sbb5.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sist.sb06_sbb5.exception.DataNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

	private final QuestionRepository questionRepository;
	
	// 질문 목록 가져오는...
	public List<Question> getList(){
		return this.questionRepository.findAll();
	}
	
	// 아이디에 해당하는 질문을 가져오는...
	public Question getQuestion(Integer id) {
		Optional<Question> oQuestion = this.questionRepository.findById(id);
		if (oQuestion.isPresent()) {
			return oQuestion.get();   // Optional<Question> -> Question
		}else {
			// 강제로 사용자 정의 예외를 발생시키겠다.
			// exception 패키지 + DataNotFoundException 예외 클래스 추가
			throw new DataNotFoundException("question not found");
		}
	}
	
	// 질문을 등록하는...
	public void create(String subject, String content) {
		Question question = new Question();
		question.setSubject(subject);
		question.setContent(content);
		question.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(question);
	}
	
	
	// 페이징 처리 + 목록
	public Page<Question> getList(int page){
		// 1번 페이지는 0을 준다
								   //pageNumber, pageSize
		//Pageable pageable = PageRequest.of(page, 10);
		
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("id"));
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		
		return this.questionRepository.findAll(pageable);
	}
	
	
}// class
