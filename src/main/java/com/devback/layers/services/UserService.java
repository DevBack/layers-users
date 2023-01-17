package com.devback.layers.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devback.layers.dto.UserDTO;
import com.devback.layers.dto.UserInsertDTO;
import com.devback.layers.entities.User;
import com.devback.layers.repositories.UserRepository;
import com.devback.layers.services.exceptions.ServiceException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public List<UserDTO> findAll() {
		List<User> list = userRepository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	public UserDTO insert(UserInsertDTO dto) {
		
		User obj = userRepository.findByEmail(dto.getEmail());
		if (obj != null) {
			throw new ServiceException("Email já Cadastrado.");
		}
		
		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		user = userRepository.save(user);
		
		return new UserDTO(user);
	}
}
