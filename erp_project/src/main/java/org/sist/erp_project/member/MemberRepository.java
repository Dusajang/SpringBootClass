package org.sist.erp_project.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	Member findByUsername(String username); // 사용자 이름으로 회원 조회
	
}
