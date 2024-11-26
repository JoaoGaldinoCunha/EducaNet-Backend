package br.com.school.educanet.service;


<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 67acf015e9231c8cffc3e95cb6359119ddcf4019
import br.com.school.educanet.model.TbUserCourse;
import br.com.school.educanet.repository.CourseRepository;
import br.com.school.educanet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import br.com.school.educanet.model.TbCourse;
=======
>>>>>>> 67acf015e9231c8cffc3e95cb6359119ddcf4019
import br.com.school.educanet.repository.UserCourseRepository;

import java.util.List;

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
<<<<<<< HEAD
=======



	public String removeUserFromCourse(Long userId, Long courseId){

		if(courseRepository.existsByCourseId(courseId) && userRepository.existsById(userId)){
			var course = courseRepository.findByCourseId(courseId);
			var user =  userRepository.findByUserId(userId);

			if (userCourseRepository.existsByTbCourseAndTbUser(course, user)){
				userCourseRepository.deleteUserFromCourse(course.getCourseId(), user.getUserId());
				return ("Usuário removido do curso com sucesso!");
			}

			throw new RuntimeException("Usuário não possui matricula neste curso!");

		}
		throw new RuntimeException("Usuário ou Curso não encontrado!");
	}

	public List<TbUserCourse> searchUserInCourse(Long id){
		if (courseRepository.existsByCourseId(id)){
			return userCourseRepository.searchingUserRegisteredInCourses(id);
		}
		return null;
	}
>>>>>>> 67acf015e9231c8cffc3e95cb6359119ddcf4019
}
