package com.pofil.service;

import java.util.List;
import java.util.Optional;

import com.pofil.model.AppUser;

public interface UserDetailService {

	AppUser getUserByEmail(String email);

	List<AppUser> getAllUsers();

	AppUser getUserByEmailAndRole(String email, String roles);

	Optional<AppUser> getUserById(String id);
	public void updatePassword(String email, String password);

	/* Long countUser(String field, String value); */
}
