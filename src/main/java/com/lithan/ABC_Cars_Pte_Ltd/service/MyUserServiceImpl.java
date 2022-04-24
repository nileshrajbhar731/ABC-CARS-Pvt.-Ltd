package com.lithan.ABC_Cars_Pte_Ltd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lithan.ABC_Cars_Pte_Ltd.dao.UserRepository;
import com.lithan.ABC_Cars_Pte_Ltd.dto.Car;
import com.lithan.ABC_Cars_Pte_Ltd.dto.User;




@Service
public class MyUserServiceImpl implements MyUserService {
	private PasswordEncoder passwordencoder;
	@Autowired
	UserRepository userrepo;
	@Autowired
	public MyUserServiceImpl(PasswordEncoder encoder) {
		// TODO Auto-generated constructor stub
		this.passwordencoder=encoder;
	}
	@Override
	public String addUser(User us) {
		// TODO Auto-generated method stub
		us.setRole("USER");
		us.setPassword(passwordencoder.encode(us.getPassword()));
		User u = userrepo.findByMailid(us.getMailid());
		System.out.println(u +" 33");
		if( u == null) {
			User m = userrepo.search(us.getUserName());
			System.out.println(m +" 36");
			if(m == null) {
				userrepo.save(us);
				 return "DATA ADDED";
			}else {
				return "user exit";
			}
			
			
		}else {
			return "email exit";
		}
		
		 
	}

	@Override
	public void deleteUser(Long Id) {
		// TODO Auto-generated method stub
		userrepo.deleteById(Id);
	}
	@Override
	public User updateData(Long id) {
		// TODO Auto-generated method stub
		Optional<User> mydata=userrepo.findById(id);
		User p= mydata.get();
		return p;
	}
	@Override
	public User UpdateaddUser(User us) {
		// TODO Auto-generated method stub
		userrepo.save(us);
		return us;
	}

	@Override
	public User profileupdate(String username) {
		// TODO Auto-generated method stub
		Optional<User> mydata=userrepo.findByUserName(username);
		User p= mydata.get();
		return p;
		
	}
	@Override
	public String profileupdateSave(User pro) {
		// TODO Auto-generated method stub
		User u = userrepo.findByMailid(pro.getMailid());
		if( u == null) {
			userrepo.save(pro);
		 return "DATA ADDED";
	}else {
		return "email exit";
	}
		
		
	}
	@Override
	public User findbyprofile(String profile) {
		// TODO Auto-generated method stub
		Optional<User> mydata=userrepo.findByUserName(profile);
		User p= mydata.get();
		return p;
	}
	@Override
	public String checkUser(User us) {
		return null;
		// TODO Auto-generated method stub
//		User m = userrepo.search(us.getUserName());
//		if( m == null) {
//			userrepo.save(us);
//			 return "DATA ADDED";
//		}else {
//			return "user exit";
//		}
		
	}
	

	
	
	
	
	
	

}
