package com.cts.digibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.digibook.dao.UserDao;
import com.cts.digibook.entity.MyUserDetails;
import com.cts.digibook.entity.User;



@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User name = userDao.findByUserName(username);
		if (name != null) {
			return new MyUserDetails(name);
		} else {
			throw new UsernameNotFoundException("Incorrect Username");
		}

	}
}