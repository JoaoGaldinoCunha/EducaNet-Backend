package br.com.school.educanet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.school.educanet.model.TbUser;
import br.com.school.educanet.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
		
	 public TbUser saveUser(TbUser tbUser) {
	        TbUser existingUser = userRepository.findByEmail(tbUser.getEmail());
	        TbUser existingCpf = userRepository.findByUserCpf(tbUser.getUserCpf());
	        if (existingUser != null) {
	            throw new RuntimeException("E-mail já cadastrado!");
	        } 
	        else if(existingCpf != null) {
	        	throw new RuntimeException("CPF já cadastrado!");
	        }else {
	            return userRepository.save(tbUser);
	        }
	    }
	
	 
	 public void deleteUserByEmail(String email) {
	        TbUser existingUser = userRepository.findByEmail(email);
	        if (existingUser != null) {
	            userRepository.delete(existingUser);
	        } else {
	            throw new RuntimeException("Usuário não encontrado!");
	        }
	 }
	 
	 
}

