package com.common;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dao.RoleRepository;
import com.dao.UserRepository;
import com.entity.Role;
import com.entity.User;

@Service
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		//Admin account
		if(userRepository.findByEmail("hieuvv1@fsoft.com.vn") == null ) {
			User admin = new User();
			admin.setEmail("hieuvv1@fsoft.com.vn");
			admin.setPassword(passwordEncoder.encode("123456"));
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepository.findByName("ROLE_ADMIN"));
			roles.add(roleRepository.findByName("ROLE_MEMBER"));
			admin.setRoles(roles);
			userRepository.save(admin);
		}
		
		//Member account
		if(userRepository.findByEmail("member@fsoft.com.vn") == null) {
			User user = new User();
			user.setEmail("member@fsoft.com.vn");
			user.setPassword(passwordEncoder.encode("123456"));
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepository.findByName("ROLE_MEMBER"));
			user.setRoles(roles);
			userRepository.save(user);
		}
		
		
	}
	
	
}
