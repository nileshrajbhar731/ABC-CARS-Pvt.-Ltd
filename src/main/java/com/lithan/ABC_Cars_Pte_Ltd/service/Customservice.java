package com.lithan.ABC_Cars_Pte_Ltd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lithan.ABC_Cars_Pte_Ltd.dao.UserRepository;
import com.lithan.ABC_Cars_Pte_Ltd.dto.User;
import com.lithan.ABC_Cars_Pte_Ltd.security.ApplicationUserDetail;



@Service
public class Customservice implements UserDetailsService {
    @Autowired
	UserRepository userrepo;
    User user;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		user=userrepo.findByMailid(username);
		if(user==null) {
			System.out.println("email is Invalid");
		}
		return new ApplicationUserDetail(user);
	}

}
