package org.sist.sb06_sbb3.question;

import java.time.LocalDateTime;
import java.util.List;

import org.sist.sb06_sbb3.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity  // 엔티티에서는 setter 안써도 된다. 있어도 문제는 없다.
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")  // 글자수 제한이 없는 문자열
	private String content;
	
	private LocalDateTime createDate;  // create_date
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Answer> answerList;
}
