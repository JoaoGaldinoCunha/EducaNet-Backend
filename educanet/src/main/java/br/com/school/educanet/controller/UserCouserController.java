package br.com.school.educanet.controller;

import br.com.school.educanet.model.request.UserCourseRequest;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import br.com.school.educanet.service.UserCourseService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class UserCouserController {
	
	@Autowired
	UserCourseService userCourseService;

	@PostMapping("/JoinUserInCourse")
	public ResponseEntity<String> insertUserAndCourse(@RequestBody UserCourseRequest userCourseRequest){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userCourseService.saveUserInCourse(userCourseRequest.getUserId(), userCourseRequest.getCourseId()));
	}
	
	
}
