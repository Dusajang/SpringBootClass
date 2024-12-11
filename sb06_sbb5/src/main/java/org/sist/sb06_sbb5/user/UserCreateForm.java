package org.sist.sb06_sbb5.user;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {

	@Size(max=25, min=3)
	@NotEmpty(message = "사용자 ID는 필수항목입니다.")
	private String username;
	
	@NotEmpty(message="비밀번호는 필수항목입니다.")
	private String password1;
	@NotEmpty(message="비밀번호 확인는 필수항목입니다.")
	private String password2;
	
	@NotEmpty(message="email은 필수항목입니다.")
	@Email
	private String email;
}
