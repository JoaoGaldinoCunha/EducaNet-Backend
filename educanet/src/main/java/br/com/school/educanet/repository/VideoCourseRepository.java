package br.com.school.educanet.repository;

import br.com.school.educanet.model.TbCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.school.educanet.model.TbVideoCourse;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VideoCourseRepository extends JpaRepository<TbVideoCourse, Integer> {
	
	@Query("select c from TbVideoCourse c where c.videoCourseName= :Name")
	TbVideoCourse findByName(@Param("Name") String videoCourseName);
	
	@Query(value = "SELECT videoCourseId FROM tb_videoCourse WHERE courseId = :id",nativeQuery = true)
	Integer searchingById(Long id);

	@Transactional
	void deleteAllByTbCourse(TbCourse tbCourse);

	boolean existsByTbCourse(TbCourse tbCourse);
}
