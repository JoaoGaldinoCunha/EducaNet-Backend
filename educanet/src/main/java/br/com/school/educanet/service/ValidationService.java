package br.com.school.educanet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.school.educanet.repository.UserRepository;

@Service
public class ValidationService {
	@Autowired
	UserRepository userRepository;
	public ResponseEntity<Object> validateonUser(String email, String senha) throws Exception {
		try {
			userRepository.findByEmail(email).isPresent();
			userRepository.findBySenha(senha).isPresent();
            return ResponseEntity.ok("Usuário encontrado!");	
		}catch (Exception e){
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body("Usuário não encontrado.");
		}
	}
}