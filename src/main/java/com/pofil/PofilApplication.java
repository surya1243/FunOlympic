package com.pofil;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pofil.model.AppUser;
import com.pofil.model.Role;
import com.pofil.repository.RoleRepository;
import com.pofil.service.CustomUserDetailsService;
import com.pofil.service.FileSystemStorageService;
import com.pofil.service.UserDetailService;

@SpringBootApplication
public class PofilApplication {

	public static void main(String[] args) {
		SpringApplication.run(PofilApplication.class, args);
	}
	@Bean
	CommandLineRunner init(RoleRepository roleRepository, FileSystemStorageService storageService, 
			CustomUserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
	    return args -> {
	    	
	    	storageService.init();

	    	 Role viewerRole = roleRepository.findByRole("VIEWER");
		        if (viewerRole == null) {
		            Role newViewerRole = new Role();
		            newViewerRole.setRole("VIEWER");
		            roleRepository.save(newViewerRole);
		        }
		        
	        Role adminRole = roleRepository.findByRole("ADMIN");
	        if (adminRole == null) {
	            Role newAdminRole = new Role();
	            newAdminRole.setRole("ADMIN");
	            roleRepository.save(newAdminRole);
	        }
			
			/*
			 * AppUser adminUser = userDetailsService.findUserByEmail("admin1@gmail.com");
			 * if (adminUser == null) { AppUser newAdminUser = new AppUser();
			 * newAdminUser.setFirstName("admin1"); newAdminUser.setLastName("Max");
			 * newAdminUser.setEmail("admin1@gmail.com"); newAdminUser.setEnabled(true);
			 * Set<Role> roles = new HashSet<>(); roles.add(adminRole); // Assign ADMIN role
			 * 
			 * String encodedPassword = bCryptPasswordEncoder.encode("111111");
			 * newAdminUser.setPassword(encodedPassword);
			 * System.out.println("Encoded Password: " + encodedPassword);
			 * newAdminUser.setRoles(roles);
			 * userDetailsService.saveUser(newAdminUser,"ADMIN"); }
			 */
			 	
	        		
	    };

	}
}
