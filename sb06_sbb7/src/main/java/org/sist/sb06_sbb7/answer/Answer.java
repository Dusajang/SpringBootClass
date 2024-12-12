package org.sist.sb06_sbb7.answer;

import java.time.LocalDateTime;
import java.util.Set;

import org.sist.sb06_sbb7.question.Question;
import org.sist.sb06_sbb7.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
// @Builder // setter 말고 이걸 사용해도 된다.
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
	
	// 연관관계를 맺어줘야된다. / 아니면 오류뜬다.
	@ManyToOne // 1대n 질문 1개에 답변이 n개
	private Question question; // 다르다. / 주의 / FK / question_id 로 나온다.
	
	@ManyToOne // 다대일 여러개의 답변 - 한명의 유저
	private SiteUser author;
	
	private LocalDateTime modifyDate;
	
	// 답변 - 회원 다대다
	@ManyToMany
	private Set<SiteUser> voter;
	
} // class
