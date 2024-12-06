package org.sist.sb06_sbb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor // final 필드와 @NonNull로 선언된 필드만 초기화하는 생성자를 자동으로 생성하는 Lombok 어노테이션
public class HelloLombok {
	
	private final String hello;
	private final int lombok;

	public static void main(String[] args) {
		//System.out.println("hello world");
		HelloLombok helloLombok = new HelloLombok("헬로", 5);
		
		
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());

	}// main

}// class


/*
@Getter
@Setter
public class HelloLombok {
	
	private String hello;
	private int lombok;

	public static void main(String[] args) {
		//System.out.println("hello world");
		HelloLombok helloLombok = new HelloLombok();
		helloLombok.setHello("헬로");
		helloLombok.setLombok(5);
		
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());

	}// main

}// class
*/


