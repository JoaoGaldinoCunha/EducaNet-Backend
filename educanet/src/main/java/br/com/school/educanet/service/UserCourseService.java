package br.com.school.educanet.service;


import java.util.List;

import br.com.school.educanet.model.TbUserCourse;
import br.com.school.educanet.repository.CourseRepository;
import br.com.school.educanet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.school.educanet.model.TbCourse;
import br.com.school.educanet.repository.UserCourseRepository;
@Service
public class UserCourseService {
	@Autowired
	UserCourseRepository userCourseRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	UserRepository userRepository;

	public String saveUserInCourse(Long userId, Long courseId){

		if(courseRepository.existsByCourseId(courseId) && userRepository.existsById(userId)){
			var course = courseRepository.findByCourseId(courseId);
			var user =  userRepository.findByUserId(userId);

			if (userCourseRepository.existsByTbCourseAndTbUser(course, user)){
				return ("Usuário já cadastrado no curso!");
			}

			userCourseRepository.saveUserInCourse(user.getUserId(), course.getCourseId());
			return ("Sucesso ao usuário linkado com o Curso");
		}
		return ("Erro ao Linkar usuário e curso!");
	}
}
