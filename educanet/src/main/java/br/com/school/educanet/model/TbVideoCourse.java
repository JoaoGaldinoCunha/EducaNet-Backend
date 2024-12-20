package br.com.school.educanet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_videoCourse")
public class TbVideoCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long videoCourseId;
	private String videoCourseName;
	private String videoCourseUrlId;
	private String videoCourseDescription;
	@ManyToOne
	@JoinColumn(name = "courseId",referencedColumnName = "courseId")
	private TbCourse tbCourse;
	
	
	public long getVideoCourseId() {
		return videoCourseId;
	}
	public void setVideoCourseId(long videoCourseId) {
		this.videoCourseId = videoCourseId;
	}
	public String getVideoCourseName() {
		return videoCourseName;
	}
	public void setVideoCourseName(String videoCourseName) {
		this.videoCourseName = videoCourseName;
	}
	public String getVideoCourseUrlId() {
		return videoCourseUrlId;
	}
	public void setVideoCourseUrlId(String videoCourseUrlId) {
		this.videoCourseUrlId = videoCourseUrlId;
	}
	public String getVideoCourseDescription() {
		return videoCourseDescription;
	}
	public void setVideoCourseDescription(String videoCourseDescription) {
		this.videoCourseDescription = videoCourseDescription;
	}
	public TbCourse getTbCourse() {
		return tbCourse;
	}
	public void setTbCourse(TbCourse tbCourse) {
		this.tbCourse = tbCourse;
	}
	
	
	
	
	
}

