
-- Member와 Authority 테이블 초기화
DELETE FROM authority;
DELETE FROM member;

-- Member 테이블에 관리자 추가 (member_id 자동 생성)
INSERT INTO member (username, password, name, birth_date, phone, email, gender, sms_opt_in, email_opt_in, join_date, status, course_id, location, postal_code, address, address_detail)
VALUES 
('admin', 'adminpassword', 'Admin User', '1980-01-01', '010-1111-1111', 'admin@example.com', 'MALE', true, true, '2023-12-08', 'ACTIVE', NULL, 'Seoul', '12345', '123 Admin St', 'Suite 1');

-- Authority 테이블에 관리자 권한 추가
INSERT INTO authority (role_name, member_id)
VALUES
('ROLE_ADMIN', (SELECT member_id FROM member WHERE username = 'admin')),
('ROLE_USER', (SELECT member_id FROM member WHERE username = 'admin'));