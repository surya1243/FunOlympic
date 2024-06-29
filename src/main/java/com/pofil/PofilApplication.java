package com.pofil;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pofil.model.Role;
import com.pofil.repository.RoleRepository;
import com.pofil.service.CustomUserDetailsService;
import com.pofil.service.FileSystemStorageService;

@SpringBootApplication
public class PofilApplication {

	public static void main(String[] args) {
		SpringApplication.run(PofilApplication.class, args);
	}
	@Bean
	CommandLineRunner init(RoleRepository roleRepository, FileSystemStorageService storageService, 
			CustomUserDetailsService userDetailsService) {
	    return args -> {
	    	
	    	storageService.init();
	    	
			/*
			 * BankCardInfo bankCardInfo = bankCardInfoRepository.findByInstitution("POFL");
			 * if(bankCardInfo == null) { BankCardInfo newBankCardInfo = new BankCardInfo();
			 * newBankCardInfo.setBankName("Pokhara Finance Ltd.");
			 * newBankCardInfo.setbIN("62347712"); newBankCardInfo.setOldBin("637029");
			 * newBankCardInfo.setInstitution("POFL");
			 * newBankCardInfo.setCardProduct("POFD");
			 * bankCardInfoRepository.save(newBankCardInfo); }
			 */

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
	    };

	}
}
