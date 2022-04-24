package com.lithan.ABC_Cars_Pte_Ltd.service;

import java.util.List;

import com.lithan.ABC_Cars_Pte_Ltd.dto.User;

public interface MyUserService {

	public String addUser(User us);
	public User UpdateaddUser(User us);
	public void deleteUser(Long Id);
	public User updateData(Long id);
	public String profileupdateSave(User pro);
	public User profileupdate(String username);
	public User findbyprofile(String profile);
	public String checkUser(User us);
	


	
	
	
	
}
