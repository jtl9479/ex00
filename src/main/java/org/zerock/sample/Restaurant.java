package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Restaurant {
	
	@Autowired
	Chef chef;
	
	public String sibal = "시발";
	
	public void test() {
		System.out.println(chef.b);
	}
	
}
