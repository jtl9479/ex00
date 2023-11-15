package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Chef {
	
	
	public String b = "aaa";
	
	
	public void getChef() {
		System.out.println("a");
	}
	
	public void test1() {
		System.out.println("111");
	}
	
}
