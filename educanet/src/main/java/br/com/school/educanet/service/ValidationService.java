package br.com.school.educanet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.school.educanet.repository.UserRepository;

@Service
public class ValidationService {
	@Autowired
	UserRepository userRepository;

	public boolean ValditionUser(String email, String password) {
		return userRepository.existsByPasswordAndEmail(password, email);
	}
	
}