package com.pofil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pofil.model.AppUser;
import com.pofil.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailService{

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional
	@Override
    public void updatePassword(String email, String password) {
		AppUser user = userRepository.findByEmail(email);
        if (user != null) {
            // Update only the password field
            user.setPassword(password);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with email: " + email);
        }
    }
	@Transactional
	@Override
	public void updateSelectedGameList(String email, String[] selectedGames) {
		AppUser user = userRepository.findByEmail(email);
        if (user != null) {
            // Update only the selectedGames field
            user.setSelectedSports(selectedGames);
            userRepository.save(user);
        } else {
            throw new RuntimeException("Could not update info for: " + email);
        }
		
	}

	@Override
	public AppUser getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<AppUser> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public AppUser getUserByEmailAndRole(String email, String roles) {
		return userRepository.findByEmailAndRoles(email, roles);
	}

	@Override
	public Optional<AppUser> getUserById(String id) {
		return userRepository.findById(id);
	}
	/*
	 * @Override public Long countUser(String field, String value) { return
	 * userRepository.countUser(field, value); }
	 */

	@Override
	public Long countViewerSelectedSports(String field, String value) {
		return userRepository.countViewerSportsCount(field, value);
	}


	

/*	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		final AppUser appUserFromDb = userRepository.findByEmail(email);

		if (appUserFromDb == null)
			throw new UsernameNotFoundException(email);

		return new UserDetails() {
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				Collection<GrantedAuthority> authority = new LinkedList<>();
				authority.add(new GrantedAuthority() {
					@Override
					public String getAuthority() {
						return appUserFromDb.getRoles();
					}
				});
				return authority;
			}

			@Override
			public String getPassword() {
				return appUserFromDb.getPassword();
			}

			@Override
			public String getUsername() {
				return appUserFromDb.getEmail();
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isEnabled() {
				return appUserFromDb.isEnabled();
			}
		};
	}*/


}