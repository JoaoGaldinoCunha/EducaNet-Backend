package br.com.school.educanet.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.school.educanet.model.TbCourse;
import br.com.school.educanet.repository.CourseRepository;
import br.com.school.educanet.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	CourseService courseService;
	
	
	@PostMapping("/course/coursesave")
	public ResponseEntity<String> saveCouse (@RequestBody TbCourse tbCourse){
		TbCourse existingCourse = courseRepository.findByName(tbCourse.getCourseName());
		if(existingCourse != null) {
			return ResponseEntity
			.status(HttpStatus.CONFLICT)
			.body("Não foi possivel criar um curso com esse nome pois já um existente");
		} 
		else {
			courseRepository.save(tbCourse);
			return ResponseEntity
			.status(HttpStatus.OK)
			.body("curso criado com sucesso");
				
		}
		
	}
	
	
	@DeleteMapping("/course/deleteCourse/{id}")
	public ResponseEntity<String> deleleteCoursEntity (@PathVariable Integer id){
		if( courseRepository.findById(id) != null) {
			courseRepository.deleteById(id);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("Curso excluido com sucesso");
		}
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Id não encontrado");
	}
	
	
	@GetMapping("/course/AllCourses")
	public ResponseEntity<List<TbCourse>> allCourses( ){
	return ResponseEntity.status(HttpStatus.OK).body(courseRepository.findAll());
	}
	
	
	@GetMapping("/course/{id}")
	public ResponseEntity<Optional<TbCourse>> FindByIdCourse(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(courseService.returningCourseById(id));
	}
	
	
	@PutMapping("/course/{courseId}")
    public ResponseEntity<String> updateCourse(@PathVariable Integer courseId, @RequestBody TbCourse updatedCourse) {
        TbCourse course = courseService.updateCourse(courseId, updatedCourse);
        return ResponseEntity.ok("Curso Atualizado com sucesso");
    }
}

