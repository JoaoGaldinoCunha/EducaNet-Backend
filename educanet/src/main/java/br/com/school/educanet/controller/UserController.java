package br.com.school.educanet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.school.educanet.model.TbUser;
import br.com.school.educanet.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;


    @PostMapping("/users")
    public ResponseEntity<String> saveUser(@RequestBody TbUser tbUser) {
        TbUser existingUser = userRepository.findByEmail(tbUser.getEmail());
        TbUser existingCpf = userRepository.findByUserCpf(tbUser.getUserCpf());
        if (existingUser != null) {
            return ResponseEntity
            		.status(HttpStatus.CONFLICT)
            		.body("E-mail já cadastrado!");
        } 
        else if(existingCpf != null) {
            return ResponseEntity
            		.status(HttpStatus.CONFLICT)
            		.body("CPF já cadastrado!");
        }
        else {
            userRepository.save(tbUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
        }
    }
    
    
    @DeleteMapping("/users/{email}")
    public ResponseEntity<String> deleteUserByEmail(@PathVariable String email) {
        TbUser existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            userRepository.delete(existingUser);
            return ResponseEntity.ok("Usuário excluído com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
    }

}
