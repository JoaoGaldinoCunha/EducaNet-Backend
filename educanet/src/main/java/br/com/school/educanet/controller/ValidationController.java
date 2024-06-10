package br.com.school.educanet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.school.educanet.model.TbUser;
import br.com.school.educanet.service.ValidationService;

@RestController
public class ValidationController {
	
	
	@Autowired
    private  ValidationService validationService;



    @PostMapping("/validateUser")
    public ResponseEntity<String> validateUser(@RequestBody TbUser user) {
          boolean validateUser =  validationService.ValditionUser(user.getEmail(), user.getPassword());
          if (validateUser) {
              return ResponseEntity.ok("Usuário encontrado!");
          }

          return ResponseEntity.badRequest().body("Usuário não encontrado!");

    }
}


