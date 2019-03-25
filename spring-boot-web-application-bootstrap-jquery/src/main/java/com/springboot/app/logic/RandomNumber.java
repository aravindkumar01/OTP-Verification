package com.springboot.app.logic;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomNumber {
	@Autowired
	Message msg;
	
	@Autowired
	HttpSession session;
	public void random(String mail)
	{
		try {
			Random rand = new Random(); 
			int num = rand.nextInt(10000); 

            session.setAttribute("otp", num);
			System.out.println(num);
  	msg.sendMail(String.valueOf(num),mail);
			//return num;
			
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		//return 0;
	}
	public String  check(int num)
	{
		
		try {
			int otp= (int) session.getAttribute("otp");
			if(otp==num)
			{
				return "Vaild OTP";			
				
			}
			System.out.println(otp);
					return "worng OTP";
		} catch (Exception e) {
			return e.toString();
			// TODO: handle exception
		}
		
	}

}
