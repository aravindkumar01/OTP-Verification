package com.springboot.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.entity.Registration;
import com.springboot.app.entity.Verify;
import com.springboot.app.logic.RandomNumber;
import com.springboot.app.repo.RegisterRepo;

@Service
public class RegisterService {
	
	@Autowired
	RegisterRepo repo;
	
	@Autowired
	RandomNumber rand;
	
	
	
	public String register(Registration regs)
	{
		try {
			repo.save(regs);
			rand.random(regs.getEmail());
			return "done";
		} catch (Exception e) {
			return e.toString();
			// TODO: handle exception
		}
		
	}

	public String verify(int number) {
		// TODO Auto-generated method stub
		try {
			
		 	System.out.println(number);
		 	String res=rand.check(number);
			System.out.println();
			return res;
		} catch (Exception e) {
			return e.toString();
			// TODO: handle exception
		}
	}

}
