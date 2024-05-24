package br.com.school.educanet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.school.educanet.entity.User;
import br.com.school.educanet.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public 	User saveUser(User user) {
		return userRepository.save(user);
	}	
	public User AlterarUsuario(User user) {
	if
	(userRepository.findByEmail(user.getUsuarioEmail()).isPresent()){
		throw new
		RuntimeException("Email Cadastrado");
	}
		
		return userRepository.saveAndFlush(user);
	}
	public void  ApgarUsuario(String UsuarioEmail ) {
		User user= userRepository.findById(UsuarioEmail).get();
		userRepository.delete(user);
	}
	}

