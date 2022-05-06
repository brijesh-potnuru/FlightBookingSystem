package caseStudy.UserMicroservice.SecurityConfig;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import caseStudy.UserMicroservice.dao.AdminRepository;
import caseStudy.UserMicroservice.entity.AdminDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AdminDetails secModel = repo.findById(username).get();
		return new User(secModel.getadminname(), secModel.getPassword(), new ArrayList<>());
	}

	

}